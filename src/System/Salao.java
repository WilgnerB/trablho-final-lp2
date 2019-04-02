package System;

import Controller.*;
import Model.Bean.Cliente;
import Model.Bean.Funcionario;
import Model.Bean.Marca;
import Model.Bean.Produto;
import Model.Bean.Venda;
import java.util.List;

public class Salao implements ISalao {

    private static ISalao instance;
    private String nome;
    private ClienteControl CtrlCliente;
    private FuncionarioControl CtrlFuncionario;
    private ProdutoControl CtrlProduto;
    private ProdutoVendaControl CtrlProdutoVenda;
    private VendaControl CtrlVenda;
    private UsuarioControl CtrlUsuario;
    private MarcaControl CtrlMarca;

    public Salao(String nome, ClienteControl CtrlCliente, FuncionarioControl CtrlFuncionario, ProdutoControl CtrlProduto, ProdutoVendaControl CtrlProdutoVenda, VendaControl CtrlVenda, UsuarioControl CtrlUsuario, MarcaControl CtrlMarca) {
        this.nome = nome;
        this.CtrlCliente = CtrlCliente;
        this.CtrlFuncionario = CtrlFuncionario;
        this.CtrlProduto = CtrlProduto;
        this.CtrlProdutoVenda = CtrlProdutoVenda;
        this.CtrlVenda = CtrlVenda;
        this.CtrlUsuario = CtrlUsuario;
        this.CtrlMarca = CtrlMarca;
    }

    public static ISalao getInstance(String nome, ClienteControl CtrlCliente, FuncionarioControl CtrlFuncionario, ProdutoControl CtrlProduto, ProdutoVendaControl CtrlProdutoVenda, VendaControl CtrlVenda, UsuarioControl CtrlUsuario,MarcaControl CtrlMarca) {
        if (instance == null) {
            instance = new Salao(nome, CtrlCliente, CtrlFuncionario, CtrlProduto, CtrlProdutoVenda, CtrlVenda, CtrlUsuario,CtrlMarca);
            return instance;
        } else {
            return instance;
        }
    }

    public static ISalao getSingleton() {
        return instance;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public List<Produto> getProdutos() {
        return CtrlProduto.read();
    }
    
    @Override
    public List<Produto> getProdutosForDesc(String desc) {
                return CtrlProduto.readForDesc(desc);
    }
    
    @Override
    public boolean updateProdutos(List<Produto> produtosestoque) {
        return CtrlProduto.update(produtosestoque);
    }
    
    @Override
        public boolean createProduto(int i, String text, int parseInt, double parseDouble, Marca marca) {
        return CtrlProduto.create(i,text,parseInt,parseDouble,marca);
    }

    @Override
    public boolean deleteProduto(Produto p) {
        return CtrlProduto.delete(p);
    }

    @Override
    public boolean updateProduto(int i, String text, int parseInt, double parseDouble, Marca marca) {
        return CtrlProduto.update(i,text,parseInt,parseDouble,marca);
    }

    @Override
    public List<Cliente> getClientes() {
        return CtrlCliente.read();
    }

    @Override
    public List<Funcionario> getFuncionarios() {
        return CtrlFuncionario.read();
    }

    @Override
    public boolean CheckLogin(String login, String senha) {
        return CtrlUsuario.CheckLogin(login, senha);
    }

    @Override
    public boolean createUsuario(String login, String senha) {
        return CtrlUsuario.create(login, senha);
    }

    @Override
    public boolean createVenda(int IdCliente, int IdFuncionario) {
        return CtrlVenda.create(IdCliente, IdFuncionario);
    }

    @Override
    public boolean podeVender(int QtdEst, int QtdVend) {
        return CtrlProdutoVenda.testVenda(QtdEst, QtdVend);
    }

    @Override
    public boolean createProdutoVenda(List<Produto> produtosvenda) {
        return CtrlProdutoVenda.create(produtosvenda, CtrlVenda.getVenda());
    }

    @Override
    public boolean createMarca(String nome) {
        return CtrlMarca.createMarca(nome);
    }

    @Override
    public List<Marca> getMarcas() {
        return CtrlMarca.read();
    }

    @Override
    public List<Venda> getVendas() {
        return CtrlVenda.read();
    }

    @Override
    public List<Venda> getVendasForNMAT(String NM) {
        return CtrlVenda.readForNMAT(NM);
    }

    @Override
    public List<Venda> getVendasForNMCL(String NM) {
        return CtrlVenda.readForNMCL(NM);
    }

    @Override
    public List<Cliente> getClientesForNm(String Nm) {
        return CtrlCliente.readForNm(Nm);
    }

    @Override
    public boolean createCliente( String NmCliente, String telefone, String DtNasc) {
        return CtrlCliente.create(NmCliente,telefone,DtNasc);
    }

    @Override
    public boolean deleteCliente(Cliente c) {
        return CtrlCliente.delete(c);
    }

    @Override
    public boolean updateCliente(int idcliente, String NmCliente, String telefone, String DtNasc) {
        return CtrlCliente.update(idcliente,NmCliente,telefone,DtNasc);
    }
}

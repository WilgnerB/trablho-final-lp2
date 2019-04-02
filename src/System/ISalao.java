/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Model.Bean.Cliente;
import Model.Bean.Funcionario;
import Model.Bean.Marca;
import Model.Bean.Produto;
import Model.Bean.Venda;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface ISalao {

    boolean CheckLogin(String login, String senha);

    boolean createCliente(String NmCliente, String telefone, String DtNasc);

    boolean createMarca(String nome);

    boolean createProduto(int i, String text, int parseInt, double parseDouble, Marca marca);

    boolean createProdutoVenda(List<Produto> produtosvenda);

    boolean createUsuario(String login, String senha);

    boolean createVenda(int IdCliente, int IdFuncionario);

    boolean deleteCliente(Cliente c);

    boolean deleteProduto(Produto p);

    List<Cliente> getClientes();

    List<Cliente> getClientesForNm(String Nm);

    List<Funcionario> getFuncionarios();

    List<Marca> getMarcas();

    String getNome();

    List<Produto> getProdutos();

    List<Produto> getProdutosForDesc(String desc);

    List<Venda> getVendas();

    List<Venda> getVendasForNMAT(String NM);

    List<Venda> getVendasForNMCL(String NM);

    boolean podeVender(int QtdEst, int QtdVend);

    void setNome(String nome);

    boolean updateCliente(int idcliente, String NmCliente, String telefone, String DtNasc);

    boolean updateProduto(int i, String text, int parseInt, double parseDouble, Marca marca);

    boolean updateProdutos(List<Produto> produtosestoque);
    
}

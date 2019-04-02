
import Controller.ClienteControl;
import Controller.FuncionarioControl;
import Controller.MarcaControl;
import Controller.ProdutoControl;
import Controller.ProdutoVendaControl;
import Controller.UsuarioControl;
import Controller.VendaControl;
import Interfaces.IClienteRepo;
import Interfaces.IFuncionarioRepo;
import Interfaces.IMarcaRepo;
import Interfaces.IProdutoRepo;
import Interfaces.IProdutoVendaRepo;
import Interfaces.IUsuarioRepo;
import Interfaces.IVendaRepo;
import Model.DAO.ClienteDAO;
import Model.DAO.FuncionarioDAO;
import Model.DAO.MarcaDAO;
import Model.DAO.ProdutoDAO;
import Model.DAO.ProdutoVendaDAO;
import Model.DAO.UsuarioDAO;
import Model.DAO.VendaDAO;
import System.ISalao;
import System.Salao;
import View.ViewCRUDProduto;
import View.ViewHome;
import View.ViewInitVendas;
import View.ViewLogin;
import View.ViewVendas;

public class Programa {

    public static void main(String args[]) {
        IClienteRepo cdao = new ClienteDAO();
        IFuncionarioRepo fdao = new FuncionarioDAO();
        IProdutoRepo pdao = new ProdutoDAO();
        IProdutoVendaRepo pvdao = new ProdutoVendaDAO();
        IVendaRepo vdao = new VendaDAO();
        IUsuarioRepo udao = new UsuarioDAO();
        IMarcaRepo mdao=new MarcaDAO();

        String nome = "Salao Da Eliane";
        ClienteControl CtrlCliente = new ClienteControl(cdao);
        FuncionarioControl CtrlFuncionario = new FuncionarioControl(fdao);
        ProdutoControl CtrlProduto = new ProdutoControl(pdao);
        ProdutoVendaControl CtrlProdutoVenda = new ProdutoVendaControl(pvdao);
        VendaControl CtrlVenda = new VendaControl(vdao);
        UsuarioControl CtrlUsuario = new UsuarioControl(udao);
        MarcaControl CtrlMarca = new MarcaControl(mdao);

        ISalao salao = Salao.getInstance(nome, CtrlCliente, CtrlFuncionario, CtrlProduto, CtrlProdutoVenda, CtrlVenda, CtrlUsuario, CtrlMarca);
        ViewLogin frame = new ViewLogin();
        frame.setVisible(true);
    }
}

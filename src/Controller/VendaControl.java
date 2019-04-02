package Controller;

import Interfaces.IVendaRepo;
import Model.Bean.Venda;
import java.util.List;


public class VendaControl{
    IVendaRepo vdao;

    public VendaControl(IVendaRepo vdao) {
        this.vdao = vdao;
    }

    public boolean create(int IdCliente, int IdFuncionario) {
        Venda v = Venda.NewInstance(IdCliente, IdFuncionario);
        return vdao.create(v);
    }

    public Venda getVenda() {
        return vdao.getVenda();
    }

    public List<Venda> read() {
        return vdao.read();
    }

    public List<Venda> readForNMAT(String Nm) {
        return vdao.readForNMAT(Nm);
    }

    public List<Venda> readForNMCL(String Nm) {
        return vdao.readForNMCL(Nm);
    }
    
    
}

package Controller;

import Interfaces.IClienteRepo;
import Model.Bean.Cliente;
import java.util.List;

public class ClienteControl{
    IClienteRepo cdao;
    public ClienteControl(IClienteRepo cdao) {
        this.cdao = cdao;
    }
    


    public List<Cliente> read() {
        return cdao.read();
    }

    public boolean update(int idcliente, String NmCliente, String telefone, String DtNasc) {
        Cliente c=Cliente.NewInstace(NmCliente, telefone, DtNasc);
        c.setIdcliente(idcliente);
        return cdao.update(c);
    }

    public List<Cliente> readForNm(String Nm) {
        return cdao.readForNm(Nm);
    }

    public boolean delete(Cliente c) {
        return cdao.delete(c);
    }

    public boolean create(String NmCliente, String telefone, String DtNasc) {
        Cliente c=Cliente.NewInstace(NmCliente, telefone, DtNasc);
        return cdao.create(c);
    }

}

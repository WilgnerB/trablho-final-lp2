package Controller;

import Interfaces.IFuncionarioRepo;
import Model.Bean.Funcionario;
import java.util.List;

public class FuncionarioControl implements IFuncionarioRepo{
    IFuncionarioRepo fdao;

    public FuncionarioControl(IFuncionarioRepo fdao) {
        this.fdao = fdao;
    }

    

    @Override
    public List<Funcionario> read() {
        return fdao.read();
    } 
    
    
}

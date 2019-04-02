package Controller;

import Interfaces.IUsuarioRepo;
import Model.Bean.Usuario;


public class UsuarioControl {
    IUsuarioRepo udao;

    public UsuarioControl(IUsuarioRepo udao) {
        this.udao = udao;
    }

    public boolean CheckLogin(String Login, String Senha) {
        return udao.CheckLogin(Login, Senha);
    }

    public boolean create(String login, String senha) {
        Usuario u=Usuario.newInstance(login, senha);
        return udao.create(u);
    }
    
    
}

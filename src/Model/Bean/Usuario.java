/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Bean;

/**
 *
 * @author aluno
 */
public class Usuario {
    private int id;
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public static Usuario newInstance(String login, String senha){
        return new Usuario(login,senha);
    }

    public int getID(){
        return id;
    }
    
    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Bean.Usuario;

/**
 *
 * @author wilgn
 */
public interface IUsuarioRepo {

    boolean CheckLogin(String Login, String Senha);

    boolean create(Usuario u);
    
}

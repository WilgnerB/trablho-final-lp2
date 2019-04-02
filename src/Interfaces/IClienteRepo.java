/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Bean.Cliente;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface IClienteRepo {

    boolean create(Cliente c);

    boolean delete(Cliente c);

    List<Cliente> read();

    List<Cliente> readForNm(String Nm);

    boolean update(Cliente c);
    
}

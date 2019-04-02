/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Bean.Venda;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface IVendaRepo {

    boolean create(Venda v);

    Venda getVenda();

    List<Venda> read();

    List<Venda> readForNMAT(String Nm);

    List<Venda> readForNMCL(String Nm);
    
}

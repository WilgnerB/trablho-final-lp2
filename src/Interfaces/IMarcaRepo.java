/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Bean.Marca;
import java.util.List;

/**
 *
 * @author LucasAugusto
 */
public interface IMarcaRepo {

    boolean create(Marca m);

    List<Marca> read();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Bean.Produto;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface IProdutoRepo {

    boolean create(Produto p);

    boolean delete(Produto p);

    List<Produto> read();

    List<Produto> readForDesc(String desc);

    boolean update(Produto p);
    
    boolean update(List<Produto> p);
    
}

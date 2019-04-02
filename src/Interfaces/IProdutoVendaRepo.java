/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Bean.ProdutoVenda;
import java.util.List;

/**
 *
 * @author wilgn
 */
public interface IProdutoVendaRepo {

    boolean create(ProdutoVenda pv);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.IMarcaRepo;
import Model.Bean.Marca;
import java.util.List;

/**
 *
 * @author LucasAugusto
 */
public class MarcaControl {
    IMarcaRepo mdao;

    public MarcaControl(IMarcaRepo mdao) {
        this.mdao = mdao;
    }

    public boolean createMarca(String nome) {
        return mdao.create(Marca.newinstance(nome));
    }

    public List<Marca> read() {
        return mdao.read();
    }


    
}

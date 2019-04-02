/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Bean;

import java.util.List;


/**
 *
 * @author wilgn
 */
public class ProdutoVenda {
    List<Produto> p=null;
    private Venda v=null;

    private ProdutoVenda(List<Produto> p,Venda v) {
        this.p = (List<Produto>) p;
        this.v = v;
    }
    
    public static ProdutoVenda NewInstace(List<Produto> p,Venda v){
        if(p!=null && v!=null){
        return new ProdutoVenda(p,v);
        }else{
            return null;
        }
    }
    
    public static ProdutoVenda NewInstace(List<Produto> p,int IdVenda){
        if(p!=null && IdVenda>=0){
        return new ProdutoVenda(p,new Venda(IdVenda));
        }else{
            return null;
        }
    }

    public List<Produto> getP() {
        return p;
    }

    public void setP(List<Produto> p) {
        this.p = p;
    }
    
    public Venda getV() {
        return v;
    }

    public void setV(Venda v) {
        this.v = v;
    }
}

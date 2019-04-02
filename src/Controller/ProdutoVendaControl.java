package Controller;

import Interfaces.IProdutoVendaRepo;
import Model.Bean.Produto;
import Model.Bean.ProdutoVenda;
import Model.Bean.Venda;
import java.util.List;

public class ProdutoVendaControl {

    IProdutoVendaRepo pvdao;

    public ProdutoVendaControl(IProdutoVendaRepo pvdao) {
        this.pvdao = pvdao;
    }

    public boolean testVenda(int QtdEst, int QtdVend) {
        return QtdEst >= QtdVend;
    }

    public boolean create(List<Produto> produtosvenda,Venda v) {
        ProdutoVenda pv=ProdutoVenda.NewInstace(produtosvenda,v);
        return pvdao.create(pv);
    }
}

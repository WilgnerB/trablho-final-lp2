package Controller;

import Interfaces.IProdutoRepo;
import Model.Bean.Marca;
import Model.Bean.Produto;
import java.util.List;

public class ProdutoControl {

    IProdutoRepo pdao;

    public ProdutoControl(IProdutoRepo pdao) {
        this.pdao = pdao;
    }

    public boolean create(int i, String text, int parseInt, double parseDouble, Marca marca) {
        Produto p = Produto.newinstance(i, text, parseInt, parseDouble, marca);
        return pdao.create(p);
    }

    public List<Produto> read() {
        return pdao.read();
    }

    public List<Produto> readForDesc(String desc) {
        return pdao.readForDesc(desc);
    }

    public boolean update(List<Produto> produtosestoque) {
        return pdao.update(produtosestoque);
    }

    public boolean delete(Produto p) {
        return pdao.delete(p);
    }

    public boolean update(int i, String text, int parseInt, double parseDouble, Marca marca) {
        Produto p = Produto.newinstance(i, text, parseInt, parseDouble, marca);
        return pdao.update(p);
    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wilgn
 */
public class Venda {

    private int idVenda;
    private Cliente c = null;
    private Funcionario f = null;
    private Date DtVenda;
    private Double total;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private Venda(Cliente c, Funcionario f) {
        this.c = c;
        this.f = f;
    }
    
    public Venda(int idVenda) {
        this.idVenda = idVenda;
    }
    
    public static Venda NewInstance(Cliente c, Funcionario F) {
        return new Venda(c, F);
    }

    public static Venda NewInstance(int IdCliente, int IdFuncionario) {
        return new Venda(new Cliente(IdCliente), new Funcionario(IdFuncionario));
    }
    
    public static Venda NewInstance(int maxId) {
        return new Venda(maxId);
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public Funcionario getF() {
        return f;
    }

    public void setF(Funcionario f) {
        this.f = f;
    }

    public Date getDtVenda() {
        return DtVenda;
    }

    public void setDtVendaBD(Date DtVenda) {
        this.DtVenda = DtVenda;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }


    public void setDtVenda(String dtnasctxt) {
        try {
            format.setLenient(false);
            DtVenda = format.parse(dtnasctxt);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

}

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
public class Funcionario {

    private int idfunc;
    private String nmfunc;
    private String telefone;
    private Date dtnasc;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Funcionario(int idfunc) {
        this.idfunc = idfunc;
    }

    public Funcionario(String nmfunc) {
        this.nmfunc = nmfunc;
    }
    
    

    
//    public Funcionario(String nmfunc, String telefone, Date dtnasc) {
//        this.nmfunc = nmfunc;
//        this.telefone = telefone;
//        this.dtnasc = dtnasc;
//    }
//
//    
//    
//    public static Funcionario NewInstace(String nmcliente, String telefone, Date dtnasc){
//        return new Funcionario(nmcliente,telefone,dtnasc);
//    }
    
    public int getIdfunc() {
        return idfunc;
    }

    public void setIdfunc(int idfunc) {
        this.idfunc = idfunc;
    }

    public String getNmfunc() {
        return nmfunc;
    }

    public void setNmfunc(String nmfunc) {
        this.nmfunc = nmfunc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasctxt) {
        try {
            format.setLenient(false);
            dtnasc = format.parse(dtnasctxt);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public void setDtnascBD(Date dtnasc) {
        this.dtnasc = dtnasc;
    }
}

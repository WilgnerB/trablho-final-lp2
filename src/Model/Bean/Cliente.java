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
 * @author Aluno
 */
public class Cliente {

    private int idcliente;
    private String nmcliente;
    private String telefone;
    private Date dtnasc;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private Cliente(String nmcliente, String telefone, Date dtnasc) {
        this.nmcliente = nmcliente;
        this.telefone = telefone;
        this.dtnasc = dtnasc;
    }

    public Cliente(String nmcliente) {
        this.nmcliente = nmcliente;
    }

    public Cliente(int idcliente) {
        this.idcliente = idcliente;
    }
    

    public static Cliente NewInstace(String nmcliente, String telefone, String dtnasctxt){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dtnasc=null;
        try {
            format.setLenient(false);
            dtnasc = format.parse(dtnasctxt);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return new Cliente(nmcliente,telefone,dtnasc);
    }
    public static Cliente NewInstace(String nmcliente, String telefone, Date dtnasc){
        return new Cliente(nmcliente,telefone,dtnasc);
    }
    
    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNmcliente() {
        return nmcliente;
    }

    public void setNmcliente(String nmcliente) {
        this.nmcliente = nmcliente;
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
        this.dtnasc=dtnasc;
    }
}

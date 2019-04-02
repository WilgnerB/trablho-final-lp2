/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Bean;

import java.util.Date;

public class Produto {

    private Produto(int idprod, String nome, int qtd, double preco,Marca marca) {
        this.idprod = idprod;
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
        this.marca=marca;
    }

    private int idprod;
    private String nome;
    private int qtd;
    private double preco;
    private Date DataEnt = null;
    private String status ;
    private Marca marca;

    public static Produto newinstance(int idprod,String nome,int qtd,double preco,Marca marca){
        return new Produto(idprod,nome,qtd,preco,marca);
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataEnt(Date DataEnt) {
        this.DataEnt = DataEnt;
    }

    public Date getDataEnt() {
        return DataEnt;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
}

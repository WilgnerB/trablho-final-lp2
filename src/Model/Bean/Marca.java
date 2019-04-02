/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Bean;

/**
 *
 * @author LucasAugusto
 */
public class Marca {

    private int idmarca;
    private String Nome;

    private Marca(String Nome) {
        this.Nome = Nome;
    }

    public static Marca newinstance(String nome) {
        if (nome.equals("") == false) {
            return new Marca( nome);
        } else {
            return null;
        }
    }

    public int getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}

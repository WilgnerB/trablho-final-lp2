/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Model.Bean.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Samuelson
 */
public class FuncionarioTableModel extends AbstractTableModel{
    private List<Funcionario> dados = new ArrayList<>();
    private String[] colunas = {"Id","Nome","Telefone","Data Nasc."};

    public FuncionarioTableModel(List<Funcionario> d) {
        super();
        this.dados=d;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
         switch(coluna){
            case 0:
                return dados.get(linha).getIdfunc();
            case 1:
                return dados.get(linha).getNmfunc();
            case 2:
                return dados.get(linha).getTelefone();
            case 3: 
                return dados.get(linha).getDtnasc();
        }
        
        return null;
        
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 1:
                dados.get(linha).setNmfunc((String) valor);
                break;
            case 2:
                dados.get(linha).setTelefone((String) valor);
                break;
            case 3:
                dados.get(linha).setDtnasc((String) valor);
                break;
        }
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void addRow(Funcionario f){
        this.dados.add(f);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    
}

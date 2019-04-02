/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Model.Bean.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Samuelson
 */
public class VendaTableModel extends AbstractTableModel{
    private List<Venda> dados = new ArrayList<>();
    private String[] colunas = {"Id", "Nome Atendente", "Nome Cliente", "Data Venda", "Total"};

    public VendaTableModel(List<Venda> d) {
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
                return dados.get(linha).getIdVenda();
            case 1:
                return dados.get(linha).getF().getNmfunc();
            case 2:
                return dados.get(linha).getC().getNmcliente();
            case 3: 
                return dados.get(linha).getDtVenda();
            case 4:
                return dados.get(linha).getTotal();
        }
        
        return null;
        
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        switch(coluna){
            case 1:
                dados.get(linha).getF().setNmfunc((String) valor);
                break;
            case 2:
                dados.get(linha).getC().setNmcliente((String) valor);
                break;
            case 3:
                dados.get(linha).setDtVenda((String) valor);
                break;
            case 4:dados.get(linha).setTotal(Double.parseDouble((String) valor));
        }
        this.fireTableRowsUpdated(linha, linha);
//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public void addRow(Venda v){
        this.dados.add(v);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    
}

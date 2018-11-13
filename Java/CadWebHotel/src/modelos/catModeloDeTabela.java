/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tabelas.Categoria;
/**
 *
 * @author u18300
 */
public class catModeloDeTabela extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    private List<Categoria> cat;
    
    public catModeloDeTabela(List<Categoria> cat) {
       this.cat = cat;
    }
    
    @Override
     public String getColumnName(int column) {
       switch (column) {
       case 0:
         return "Nome da Categoria";
       case 1:
         return "Descricao";
       }
       return "";
     }
     
    @Override
    public int getColumnCount() {
        return 2;
    }

    // devolve a quantidade de linhas
    @Override
    public int getRowCount() {
        return cat.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Categoria categoria = cat.get(rowIndex);
         switch (columnIndex) {
         case 0:
           return categoria.getNomeC();
         case 1:
           return categoria.getDescricao();
         }
        return null;
    }
    public void addRow(Categoria e){
        cat.add(e);
    }
    
}

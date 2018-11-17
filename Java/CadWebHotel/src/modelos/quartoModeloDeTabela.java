/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tabelas.Quartos;
/**
 *
 * @author u18300
 */
public class quartoModeloDeTabela extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    private List<Quartos> quartos;
    
    public quartoModeloDeTabela(List<Quartos> h) {
       this.quartos = h;
    }
    
    @Override
     public String getColumnName(int column) {
       switch (column) {
       case 0:
            return "Id Quarto";
       case 1:
            return "Id Hotel";
       case 2:
            return "Número do Quarto";
       case 3:
            return "Id Cliente";
       case 4:
            return "Está ocupado?";
       case 5:
            return "preco";
       }
       return "";
     }
     
    @Override
    public int getColumnCount() {
        return 6;
    }

    // devolve a quantidade de linhas
    @Override
    public int getRowCount() {
        return quartos.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Quartos quarto = quartos.get(rowIndex);
         switch (columnIndex) {
         case 0:
           return quarto.getQuartoID();
         case 1:
           return quarto.getHotelId();
         case 2:
           return quarto.getNumeroQuarto();
         case 3:
           return quarto.getId_Cliente();
         case 4:
           return quarto.getOcupado();
         case 5:
           return quarto.getPreco();
         }
        return null;
    }
    public void addRow(Quartos e){
        quartos.add(e);
    }
    
}

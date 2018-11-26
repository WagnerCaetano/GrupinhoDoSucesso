/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tabelas.Hoteis;
/**
 *
 * @author u18300
 */
public class hoteisModeloDeTabela extends AbstractTableModel{
    private static final long serialVersionUID = 1L;
    private List<Hoteis> hoteis;
    
    public hoteisModeloDeTabela(List<Hoteis> h) {
        this.hoteis = h;       
    }
    
    @Override
     public String getColumnName(int column) {
       switch (column) {
       case 0:
            return "Hotel Id";
       case 1:
            return "Categoria";
       case 2:
            return "Nome do Hotel";
       case 3:
            return "Nota";
       case 4:
            return "Rua";
       case 5:
            return "Cidade";
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
        return hoteis.size();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Hoteis hotel = hoteis.get(rowIndex);
         switch (columnIndex) {
         case 0:
           return hotel.getHotelid();
         case 1:
           return hotel.getCategoria();
         case 2:
           return hotel.getNome_hotel();
         case 3:
           return hotel.getRate();
         case 4:
           return hotel.getAddress();
         case 5:
           return hotel.getCidade();
         }
        return null;
    }
    public void addRow(Hoteis e){
        hoteis.add(e);
    }
    
}

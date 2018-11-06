/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadwebhotel;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author u18300
 */
public class CadWebHotel {
    private BDConexao minhaConexao = new BDConexao();
    public CadWebHotel() throws ClassNotFoundException,SQLException{
        try{
            Connection c = null;
            c = minhaConexao.criaConexao();
            
            
            c.close();
        }
            catch(SQLException e){
            System.out.println("Erro de SqlException"+e);}
            catch(ClassNotFoundException e){
            System.out.println("Erro de ClassNotFound" +e);}
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadwebhotel;
import java.sql.*;

/**
 *
 * @author 00
 */
public class CRUDTodos {
    public static void inserirCidade(Cidade c , Connection con) throws SQLException
    {
        String StrSQL = "INSERT INTO WCidadeHoteis(City_Name,State_Name) VALUES(?,?)";
        
        PreparedStatement ps = con.prepareStatement(StrSQL);
        ps.setString(1,c.getCidade());
        ps.setString(2,c.getEstado());
        ps.execute();
    }
    public static void alterarCidade(Cidade c,Connection con) throws SQLException
    {
        String StrSQL = "update WCidadeHoteis set City_Name = ? ,State_Name = ? where CityId = ? ";
        
        PreparedStatement ps = con.prepareStatement(StrSQL);
        ps.setString(1,c.getCidade());
        ps.setString(2,c.getEstado());
        ps.setInt(3,c.getId());
        ps.execute();
    }
    public static void deletarCidade(String cidade,Connection con) throws SQLException
    {
        String StrSQL = "delete from WCidadeHoteis where City_Name = ?";
        
        PreparedStatement ps = con.prepareStatement(StrSQL);
        ps.setString(1,cidade);
        ps.execute();
    }
    public static void deletarCidade2(int Id ,Connection con) throws SQLException
    {
        String StrSQL = "delete from WCidadeHoteis where CityId = ?";
        
        PreparedStatement ps = con.prepareStatement(StrSQL);
        ps.setInt(1,Id);
        ps.execute();
    }
    public static ResultSet PesquisarCidades(Connection con) throws SQLException
    {
        PreparedStatement ps = con.prepareStatement("select * from WCidadeHoteis");
        return ps.executeQuery();
    }
    
}

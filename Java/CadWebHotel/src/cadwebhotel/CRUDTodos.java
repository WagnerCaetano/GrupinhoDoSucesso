/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadwebhotel;
import tabelas.*;
import java.sql.*;

/**
 *
 * @author 00
 */
public class CRUDTodos {
    /**
     * Categorias
     */    
    public static void InserirCat(Categoria K,Connection C) throws SQLException{
        if (K.getNomeC().length() > 0 && K.getDescricao().length() > 0){
        String StrSQL = "INSERT INTO WCategoriais VALUES(?,?)";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, K.getNomeC());
        ps.setString(2, K.getDescricao());
        ps.execute();}
    }
    public static void AlterarCat(Categoria K,Connection C) throws SQLException{
        if (K.getNomeC().length() > 0 && K.getDescricao().length() > 0){
        String StrSQL = "UPDATE WCategoriais set CatNome=?,Descricao=? where CatNome=?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, K.getNomeC());
        ps.setString(2, K.getDescricao());
        ps.setString(3, K.getNomeC());
        
        ps.execute();}
    }
    public static void DeletarCat(String Categoria,Connection C) throws SQLException{
        String StrSQL = "DELETE FROM WCategoriais WHERE CatNome=?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, Categoria);

        ps.execute();
    }
    public static ResultSet PesquisarCat(String descricao,Connection C) throws SQLException{
     String StrSQL = "SELECT * FROM WCategoriais WHERE descricao like '%?%'";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, descricao);

        return ps.executeQuery();   
    }

    /**
     * Hoteis
     */
    
    public static void InserirHoteis(Hoteis H,Connection C) throws SQLException{
    if (H.isUsed()){
        String StrSQL = "INSERT INTO WHotel(Category,HotelName,Rating,Street,City) VALUES(?,?,?,?,?)";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, H.getCategoria());
        ps.setString(2, H.getNome_hotel());
        ps.setInt(3, H.getRate());
        ps.setString(4, H.getAddress());
        ps.setString(5, H.getCidade());
        
        ps.execute();}
    }
    public static void AlterarHoteis(Hoteis H,Connection C) throws SQLException{
        
        String StrSQL = "UPDATE WHotel set Category=?,HotelName=?,Rating=?,Street=?,City=? where HotelName=?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, H.getCategoria());
        ps.setString(2, H.getNome_hotel());
        ps.setInt(3, H.getRate());
        ps.setString(4, H.getAddress());
        ps.setString(5, H.getCidade());
        ps.setString(6, H.getNome_hotel());
        
        ps.execute();

       }
    public static void DeletarHoteis(String Nome,Connection C) throws SQLException{
        String StrSQL = "DELETE FROM WHotel WHERE HotelName=?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, Nome);

        ps.execute();
    }
    public static ResultSet PesquisarHoteis(Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        return ps.executeQuery();   
    }
     public static ResultSet PesquisarHoteisNome(String Nome,Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel WHERE HotelName like '%?%'";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, Nome);

        return ps.executeQuery();   
    }
    public static ResultSet PesquisarHoteisCategoria(String Categoria,Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel WHERE Category like '%?%'";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, Categoria);

        return ps.executeQuery();   
    }
    public static ResultSet PesquisarHoteisCidade(String Cidade,Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel WHERE City like '%?%'";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, Cidade);

        return ps.executeQuery();   
    }
    public static ResultSet PesquisarHoteisNota(int NotaMin,int NotaMax,Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel WHERE Rating between ? and ?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setInt(1, NotaMin);
        ps.setInt(2, NotaMax);

        return ps.executeQuery();   
    }
    
    /**
     * Quartos
     */
    public static void InserirQuartos(Quartos Q,Connection C){
        
    }
    public static void AlterarQuartos(Quartos Q,Connection C){
        
    }
    public static void DeletarQuartos(int Id,Connection C){
        
    }
    public static ResultSet PesquisarQuartos(Connection Q){
        
    }   
}

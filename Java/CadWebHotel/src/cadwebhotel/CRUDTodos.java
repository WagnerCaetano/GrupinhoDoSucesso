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
    /*
    public static void InserirHoteis(Hoteis H,Connection C){
    
    }
    public static void AlterarHoteis(Hoteis H,Connection C){
        
    }
    public static void DeletarHoteis(String Nome,Connection C){
        
    }
    public static ResultSet PesquisarHoteis(Connection C){
        
    }
    */
    /**
     * Quartos
     */
    /*
    public static void InserirQuartos(Quartos H,Connection C){
    
    }
    public static void AlterarQuartos(Quartos H,Connection C){
        
    }
    public static void DeletarQuartos(int Id,Connection C){
        
    }
    public static ResultSet PesquisarQuartos(Connection C){
        
    }
    */
}

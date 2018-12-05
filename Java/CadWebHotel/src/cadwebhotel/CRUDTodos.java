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
    public static ResultSet PesquisarCatDescricao(String descricao,Connection C) throws SQLException{
     String StrSQL = "SELECT * FROM WCategoriais WHERE descricao like ?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, "%"+descricao+"%");

        return ps.executeQuery();   
    }
    public static ResultSet PesquisarCatNome(String nome,Connection C) throws SQLException{
     String StrSQL = "SELECT * FROM WCategoriais WHERE CatNome like ?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, "%"+nome+"%");

        return ps.executeQuery();   
    }
    public static ResultSet PesquisarCat(Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WCategoriais";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        return ps.executeQuery();   
    }

    /**
     * Hoteis
     */
    
    public static void InserirHoteis(Hoteis H,Connection C) throws SQLException{
    if (H.isUsed()){
        String StrSQL = "INSERT INTO WHotel(Category,HotelName,Rating,Street,City,fotoH) VALUES(?,?,?,?,?,?)";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, H.getCategoria());
        ps.setString(2, H.getNome_hotel());
        ps.setDouble(3, H.getRate());
        ps.setString(4, H.getAddress());
        ps.setString(5, H.getCidade());
        ps.setString(6, H.getFoto());
        
        ps.execute();}
    }
    public static void AlterarHoteis(Hoteis H,int Hid,Connection C) throws SQLException{
    if (H.isUsed()){
        String StrSQL = "UPDATE WHotel set Category=?,HotelName=?,Rating=?,Street=?,City=?,Fotoh=? where HotelId=?";
        
        System.out.println(""+H.getFoto());
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, H.getCategoria());
        ps.setString(2, H.getNome_hotel());
        ps.setDouble(3, H.getRate());
        ps.setString(4, H.getAddress());
        ps.setString(5, H.getCidade());
        ps.setString(6, H.getFoto());
        ps.setInt(7, Hid);
        
        ps.execute();}

       }
    public static void DeletarHoteis(int Id,Connection C) throws SQLException{
        String StrSQL = "DELETE FROM WHotel WHERE HotelId=?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setInt(1, Id);

        ps.execute();
    }
    public static ResultSet PesquisarHoteis(Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        return ps.executeQuery();   
    }
     public static ResultSet PesquisarHoteisNome(String Nome,Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel WHERE HotelName like ?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, "%"+Nome+"%");
        
        return ps.executeQuery();   
    }
     public static ResultSet PesquisarHoteisId(int id,Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel WHERE HotelId = ?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setInt(1, id);
        
        return ps.executeQuery();   
    }
    public static ResultSet PesquisarHoteisCategoria(String Categoria,Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel WHERE Category like ?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, "%"+Categoria+"%");

        return ps.executeQuery();   
    }
    public static ResultSet PesquisarHoteisCidade(String Cidade,Connection C) throws SQLException{
        String StrSQL = "SELECT * FROM WHotel WHERE City like ?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setString(1, "%"+Cidade+"%");

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
    
    public static void InserirQuartos(Quartos Q,Connection C) throws SQLException{
        if (Q.isUsed()){
            String StrSQL = "INSERT INTO WQuarto(HotelId,NumeroQuarto,preco) VALUES(?,?,?)";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setInt(1, Q.getHotelId());
        ps.setInt(2, Q.getNumeroQuarto());
        ps.setDouble(3, Q.getPreco());
        
        ps.execute();}
        }

    public static void InserirQuartosHospedado(Quartos Q,Connection C) throws SQLException{
        if (Q.isUsed()){
            String StrSQL = "INSERT INTO WQuarto(HotelId,NumeroQuarto,id_Cliente,isOcupado,preco) VALUES(?,?,?,?,?)";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setInt(1, Q.getHotelId());
        ps.setInt(2, Q.getNumeroQuarto());
        ps.setInt(3, Q.getId_Cliente());
        ps.setInt(4, Q.getOcupado());
        ps.setDouble(5, Q.getPreco());
        
        ps.execute();}
        }
    public static void AlterarQuartos(Quartos Q,int idquarto,Connection C) throws SQLException{
        
        if (Q.getId_Cliente() == 0){
        String StrSQL = "UPDATE WQuarto set hotelid=?,numeroquarto=?,preco=? where id_quarto=?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setInt(1, Q.getHotelId());
        ps.setInt(2, Q.getNumeroQuarto());
        ps.setDouble(3, Q.getPreco());
        ps.setInt(4, idquarto);
        
        ps.execute();}
        
        else{
            String str = "update wquarto set hotelid=?,numeroquarto=?,id_cliente=?,isocupado=1,preco=? where id_quarto=?";
            
            PreparedStatement ps = C.prepareStatement(str);
            ps.setInt(1,Q.getHotelId());
            ps.setInt(2,Q.getNumeroQuarto());
            ps.setInt(3,Q.getId_Cliente());
            ps.setInt(4,Q.getOcupado());
            ps.setDouble(5,Q.getPreco());
            ps.setInt(6,idquarto);
            
            ps.execute();}

    }
    public static void DeletarQuartos(int Id,Connection C) throws SQLException{
        String StrSQL = "DELETE FROM WQuarto WHERE id_quarto=?";
        
        PreparedStatement ps = C.prepareStatement(StrSQL);
        ps.setInt(1, Id);

        ps.execute();
    }
    public static ResultSet PesquisarQuartos(Connection Q) throws SQLException{
        String StrSQL = "SELECT * FROM WQuarto";
        
        PreparedStatement ps = Q.prepareStatement(StrSQL);
        return ps.executeQuery(); 
    }
    public static ResultSet PesquisarQuartosId(int id,Connection Q) throws SQLException{
        String StrSQL = "SELECT * FROM WQuarto where id_quarto = ?";
        
        PreparedStatement ps = Q.prepareStatement(StrSQL);
        ps.setInt(1,id);
        return ps.executeQuery(); 
    }
    public static ResultSet PesquisarQuartosCategoria(String categoria,Connection Q) throws SQLException{
        String StrSQL = "SELECT WQuarto.* FROM WQuarto,WHotel where WQuarto.hotelId = WHotel.HotelId and WHotel.Category like ? ";
        
        PreparedStatement ps = Q.prepareStatement(StrSQL);
        ps.setString(1,"%"+categoria+"%");
        return ps.executeQuery(); 
    }
    public static ResultSet PesquisarQuartosHotelNome(String Hotelname,Connection Q) throws SQLException{
        String StrSQL = "SELECT WQuarto.* FROM WQuarto,WHotel where WQuarto.hotelId = WHotel.HotelId and WHotel.HotelName like ? ";
        
        PreparedStatement ps = Q.prepareStatement(StrSQL);
        ps.setString(1,"%"+Hotelname+"%");
        return ps.executeQuery(); 
    }
    public static ResultSet PesquisarQuartosPreco(int precoMin , int precoMax,Connection Q) throws SQLException{
        String StrSQL = "SELECT WQuarto FROM WQuarto where preco between ? and ? ";
        
        PreparedStatement ps = Q.prepareStatement(StrSQL);
        ps.setInt(1, precoMin);
        ps.setInt(2, precoMax);
        return ps.executeQuery(); 
    }
}

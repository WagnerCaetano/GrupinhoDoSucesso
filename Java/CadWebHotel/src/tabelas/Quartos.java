/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

/**
 *
 * @author 00
 */
public class Quartos {

    private int QuartoID, hotelId ,numeroQuarto,id_Cliente,ocupado;
    private float preco;

    public int getQuartoID() {
        return QuartoID;
    }
    public boolean isUsed(){
        return (QuartoID > 0 && hotelId > 0 && numeroQuarto > 0 && id_Cliente >0 && preco > 0 && ocupado > 0 );
    }

    public void setQuartoID(int QuartoID) {
        this.QuartoID = QuartoID;
    }

    public Quartos(int hotelId, int numeroQuarto, float preco) {
        this.hotelId = hotelId;
        this.numeroQuarto = numeroQuarto;
        this.preco = preco;
    }

    public Quartos(int hotelId, int numeroQuarto, int id_Cliente, float preco) {
        this.hotelId = hotelId;
        this.numeroQuarto = numeroQuarto;
        this.id_Cliente = id_Cliente;
        this.preco = preco;
    }

    
    
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }
    
}

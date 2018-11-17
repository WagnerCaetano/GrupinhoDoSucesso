/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

/**
 *
 * @author u18300
 */
public class Hoteis {
    int Hotelid;
    String Categoria;
    String nome_hotel;
    double rate;
    String address;
    String Cidade;

    public int getHotelid() {
        return Hotelid;
    }

    public void setHotelid(int Hotelid) {
        this.Hotelid = Hotelid;
    }
    public boolean isUsed(){
        return (Categoria.length() > 0 && nome_hotel.length() > 0 && address.length() > 0 && Cidade.length() >0);
    }

    public Hoteis(String Categoria, String nome_hotel, double rate, String address, String Cidade) {
        this.Categoria = Categoria;
        this.nome_hotel = nome_hotel;
        this.rate = rate;
        this.address = address;
        this.Cidade= Cidade;
    }

    public Hoteis(int Hotelid, String Categoria, String nome_hotel, double rate, String address, String Cidade) {
        this.Hotelid = Hotelid;
        this.Categoria = Categoria;
        this.nome_hotel = nome_hotel;
        this.rate = rate;
        this.address = address;
        this.Cidade = Cidade;
    }

    public Hoteis(){this("","",0,"","");}
    
    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria_id) {
        this.Categoria = Categoria_id;
    }

    public String getNome_hotel() {
        return nome_hotel;
    }

    public void setNome_hotel(String nome_hotel) {
        this.nome_hotel = nome_hotel;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }
    
    
    
}

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
    int Categoria_id;
    String nome_hotel;
    int rate;
    String address;
    int Cidade_id;

    public Hoteis(int Categoria_id, String nome_hotel, int rate, String address, int Cidade_id) {
        this.Categoria_id = Categoria_id;
        this.nome_hotel = nome_hotel;
        this.rate = rate;
        this.address = address;
        this.Cidade_id = Cidade_id;
    }

    public Hoteis(){this(0,"",0,"",0);}
    
    public int getCategoria_id() {
        return Categoria_id;
    }

    public void setCategoria_id(int Categoria_id) {
        this.Categoria_id = Categoria_id;
    }

    public String getNome_hotel() {
        return nome_hotel;
    }

    public void setNome_hotel(String nome_hotel) {
        this.nome_hotel = nome_hotel;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCidade_id() {
        return Cidade_id;
    }

    public void setCidade_id(int Cidade_id) {
        this.Cidade_id = Cidade_id;
    }
    
    
    
}

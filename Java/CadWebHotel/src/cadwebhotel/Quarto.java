/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadwebhotel;

/**
 *
 * @author 00
 */
public class Quarto {
    protected int Id;
    protected int HotelId;
    protected int numeroQuarto;
    protected int id_Cliente;
    protected int isOcupado;
    protected int preco;
    
    public Quarto(int Id,int HId,int nQuarto,int idCli,int isOcupado,int preco)
    {
        
    }
    public void setId(int id) {this.Id = id;}
    
    public void setHotelId(int hi) {this.HotelId = hi;}
    
    public void setNQuarto(int n) {this.numeroQuarto = n;}
    
    public void setIdCli(int id) {this.id_Cliente = id;}
    
    public void setIsOcupado(int id) {if (id >=0 && id <=1)this.isOcupado = id;}
    
    public void setPreco(int id) {this.Id = id;}
    
    
}

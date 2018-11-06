/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadwebhotel;

/**
 *
 * @author u18300
 */
public class Cidade {
    protected int Id;
    protected String NomeCidade;
    protected String NomeEstado;
    
    /**
     * 
     * @param N Nome da cidade
     * @param En Nome do estado
     */
    public Cidade(String N,String En,int Id){
        setCidade(N);
        setEstado(En);
        setId(Id);
    }
    public Cidade (String N , String En)
    {
        this(N,En,-1);
    }
    public Cidade(){this("","");}
    public void setCidade(String c){this.NomeCidade = c;}
    public String getCidade(){return this.NomeCidade;}
    public void setId(int Id){this.Id = Id;}
    public int getId(){return this.Id;}
    public void setEstado(String e){this.NomeEstado = e;}
    public String getEstado(){return this.NomeEstado;}
}

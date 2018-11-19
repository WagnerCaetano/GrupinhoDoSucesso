/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import cadwebhotel.BDConexao;
import cadwebhotel.CRUDTodos;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import tabelas.Quartos;

/**
 *
 * @author 00
 */
public class FormularioAlteracaoQuarto extends JFrame{
    private JLabel HotelId;
    private JLabel numeroQuarto;
    private JLabel id_cliente;
    private JLabel isOcupado;
    private JLabel preco;
    
    private JTextField HotelIdT;
    private JTextField numeroQuartoT;
    private JTextField id_clienteT;
    private JTextField precoT;
    
    private JButton btnConfirmar;
    private JButton btnCancelar;
    
    public FormularioAlteracaoQuarto(int IdQuarto){
        super("Formulário de Alteração de Hotel");
        setLayout(new GridLayout(6, 2, 5, 5));
        setLocation(500, 480);
        
        HotelId = new JLabel("Hotel id");
        numeroQuarto = new JLabel("Número do quarto");
        id_cliente = new JLabel("Id do cliente /r/n(caso tenha)");
        preco = new JLabel("Cidade do Hotel");
        
        HotelId.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        numeroQuarto.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        id_cliente.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        preco.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        
        HotelIdT = new JTextField();
        numeroQuartoT = new JTextField();
        id_clienteT = new JTextField();
        precoT = new JTextField();
        
        HotelIdT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        numeroQuartoT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        id_clienteT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        precoT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int ocupado = 0; 
                    BDConexao b = new BDConexao();
                    Connection c = b.criaConexao();
                    if(id_cliente.getText().length() > 0 ){ocupado =1;}
                    CRUDTodos.AlterarQuartos(new Quartos(Integer.parseInt(HotelId.getText()),Integer.parseInt(numeroQuarto.getText()),Integer.parseInt(id_cliente.getText()),Double.parseDouble(preco.getText())),IdQuarto, c);
                }
                catch(SQLException | ClassNotFoundException ex){
                    Logger.getLogger(FormularioAlteracaoHotel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desabilitar();
            }
        });
        
        btnConfirmar.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
        btnCancelar.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
        
        add(HotelId);
        add(HotelIdT);
        
        add(numeroQuarto);
        add(numeroQuartoT);
        
        add(id_cliente);
        add(id_clienteT);
        
        add(preco);
        add(precoT);
        
        add(btnConfirmar);
        add(btnCancelar);
        
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
    }
    
    private void desabilitar()
    {
        this.setVisible(false);
    }
}

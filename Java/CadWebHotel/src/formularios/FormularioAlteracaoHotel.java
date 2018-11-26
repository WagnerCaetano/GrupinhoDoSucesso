/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import cadwebhotel.BDConexao;
import cadwebhotel.CRUDTodos;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tabelas.Hoteis;

/**
 *
 * @author 00
 */
public class FormularioAlteracaoHotel extends JFrame{
    String path;
    
    private JLabel nHotel;
    private JLabel catHotel;
    private JLabel rateHotel;
    private JLabel ruaHotel;
    private JLabel cidadeHotel;
    
    private JTextField nHotelT;
    private JTextField catHotelT;
    private JTextField rateHotelT;
    private JTextField ruaHotelT;
    private JTextField cidadeHotelT;
    
    private JButton btnConfirmar;
    private JButton btnCancelar;
    private JButton btnLoadImagem;
    
    public FormularioAlteracaoHotel(int IdHotel){
        super("Formulário de Alteração de Hotel");
        setLayout(new GridLayout(7, 2, 5, 5));
        setLocation(500, 480);
        
        nHotel = new JLabel("Nome do Hotel");
        catHotel = new JLabel("Categoria do Hotel");
        rateHotel = new JLabel("Nota do Hotel");
        ruaHotel = new JLabel("Rua do Hotel");
        cidadeHotel = new JLabel("Cidade do Hotel");
        
        
        nHotel.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        catHotel.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        rateHotel.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        ruaHotel.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        cidadeHotel.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        
        nHotelT = new JTextField();
        catHotelT = new JTextField();
        rateHotelT = new JTextField();
        ruaHotelT = new JTextField();
        cidadeHotelT = new JTextField();
        
        nHotelT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        catHotelT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        rateHotelT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        ruaHotelT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        cidadeHotelT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BDConexao b = new BDConexao();
                    Connection c = b.criaConexao();
                    CRUDTodos.AlterarHoteis(new Hoteis(catHotelT.getText(),nHotelT.getText(),Double.parseDouble(rateHotelT.getText()),ruaHotelT.getText(),cidadeHotelT.getText(),path),IdHotel, c);
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
        btnLoadImagem = new JButton("Set Image");
        btnLoadImagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {      
                JPanel painel = new JPanel();
                JFileChooser escolher = new JFileChooser();
                painel.add(escolher);
                escolher.showOpenDialog(painel);
                if(escolher.getSelectedFile() != null){
                path = escolher.getSelectedFile().getPath();
                }
            }
        });
        
        btnConfirmar.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
        btnCancelar.setFont(new Font("SANS_SERIF", Font.BOLD, 36));
        btnLoadImagem.setFont(new Font("SANS_SERIF", Font.BOLD,36));
        
        
        add(nHotel);
        add(nHotelT);
        
        add(catHotel);
        add(catHotelT);
        
        add(rateHotel);
        add(rateHotelT);
        
        add(ruaHotel);
        add(ruaHotelT);
        
        add(cidadeHotel);
        add(cidadeHotelT);
        
        add(btnLoadImagem);
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

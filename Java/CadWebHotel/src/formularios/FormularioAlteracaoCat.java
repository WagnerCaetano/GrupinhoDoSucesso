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
import tabelas.Categoria;

/**
 *
 * @author 00
 */
public class FormularioAlteracaoCat extends JFrame{
    private JLabel Catnome;
    private JLabel descricao;
    
    private JTextField CatnomeT;
    private JTextField descricaoT;
    
    private JButton btnConfirmar;
    private JButton btnCancelar;
    
    public FormularioAlteracaoCat(String Cat){
        super("Formulário de Alteração de Categoria");
        setLayout(new GridLayout(6, 2, 5, 5));
        setLocation(500, 480);
        
        Catnome = new JLabel("Categoria");
        descricao = new JLabel("Descricao");
        
        Catnome.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        descricao.setFont(new Font("SANS_SERIF", Font.CENTER_BASELINE, 36));
        
        CatnomeT = new JTextField();
        descricaoT = new JTextField();
        
        CatnomeT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        descricaoT.setFont(new Font("Sans_Serif",Font.ITALIC,18));
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    BDConexao b = new BDConexao();
                    Connection c = b.criaConexao();
                    CRUDTodos.AlterarCat(new Categoria(CatnomeT.getText(),descricaoT.getText()), c);
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
        
        add(Catnome);
        add(CatnomeT);
        
        add(descricao);
        add(descricaoT);
        
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

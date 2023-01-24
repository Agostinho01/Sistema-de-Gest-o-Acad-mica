/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Estudante;
import controller.LoginCtr;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Login extends JFrame implements ActionListener{
    
    private JLabel lbUser, lbSenha;
    private JTextField tfUser;
    private JPasswordField senha;
    private JButton entrar;
    
    public Login(){
    
        this.setTitle("Login");
        this.setLayout(null);
        this.setSize(420,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        lbUser = new JLabel();
        lbUser.setText("Codigo de Estudante: ");
        lbUser.setBounds(50, 50, 150, 30);
        
        tfUser = new JTextField();
        tfUser.setBounds(220, 50, 150, 30);
        
        lbSenha = new JLabel();
        lbSenha.setText("Palavra Passe: ");
        lbSenha.setBounds(50, 100, 150, 30);

        senha = new JPasswordField();
        senha.setBounds(220,100,150,30);
        
        entrar = new JButton();
        entrar.setText("Login");
        entrar.setBounds(160,200,100,40);
        entrar.addActionListener(this);
        
        
        this.setVisible(true);
        this.add(lbUser);
        this.add(tfUser);
        this.add(lbSenha);
        this.add(senha);
        this.add(entrar);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user,pass;
        LoginCtr lg = new LoginCtr();
        Estudante resp;
        if(e.getSource()==entrar){
            //Codigo que autentica
            //user = tfUser.getText();
            //pass = senha.getText();
            //Abaixo o codigo para testes e evitar inserir dados de login sempre
            user = "20202392";
            pass = "28062001";
            if(user.isEmpty()||pass.isEmpty()){
                //JOptionPane.showMessageDialog(null, "Prencha todos Campos");
            }else{
               resp = lg.validacao(user, pass);
               if(resp == null){
                   JOptionPane.showMessageDialog(null, "Codigo de estudante ou palavra passe invalida");
               }else{
                       ViewEstudante v = new ViewEstudante(resp);
               }
            }
        }
        
    }
    
    
    
}

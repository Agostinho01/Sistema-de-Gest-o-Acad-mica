/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Curso;
import Model.CursoDAO;
import Model.Estudante;
import Model.EstudanteDAO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Júnior
 */
public class MeuPerfil extends JPanel{
    
    JPanel pn1, pn2;
    JLabel lbNome, lbId, lbData,lbMae, lbPai,lbSexo, lbNacionalidade, lbNaturalidade,
        lbCurso, lbFaculdade, lbAnoIngreso,lbMorada,lbTelemovel,lbEmail;
    JButton btEditar, btSalvar;
    JTextField tfCurso,tfFaculdade,tfAno,tfCurriculo,tfMorada, tfTelefone, tfEmail, tfEmailInst;
    JSeparator h1,h[],v1, hp;//hp- linha horizontal do painel 2
    
    Font largeFont = new Font("Segoe UI",Font.BOLD,20);
    Font smollFont = new Font("Segoe UI",Font.BOLD|Font.ITALIC,20);
    Font sFont = new Font("Segoe UI",Font.ROMAN_BASELINE|Font.PLAIN,18);
    private Estudante est;
    
    public MeuPerfil(Estudante est){
        this.est = est;
        this.setBackground(Color.white);
        this.setLayout(null);
        painel1();
        painel2();
        this.add(pn1);
        this.add(pn2);
        preencherPerfil();
          
    }
    
    private void painel1(){
        pn1 = new JPanel();
        pn1.setLayout(null);
        pn1.setBounds(0, 0, 400, 714);
        pn1.setBackground(Color.white);
        
        lbNome = new JLabel();
        lbNome.setHorizontalAlignment(JLabel.CENTER);
        lbNome.setFont(largeFont);
        lbNome.setBounds(20, 20, 380, 30);
        
        lbId = new JLabel();
        lbId.setHorizontalAlignment(JLabel.CENTER);
        lbId.setFont(largeFont);
        lbId.setBounds(20,100,380, 30);
        
        JLabel dados = new JLabel("Dados Pessoais:");
        dados.setBounds(30,150,380,30);
        dados.setFont(smollFont);
        
        h1 = new JSeparator();
        h1.setBounds(15, 185, 370, 2);
        h1.setForeground(Color.darkGray);
        
        //************Linhas Horizontais**************
        h = new JSeparator[6];int aux = 0;
        for(int i = 0; i<6; i++){
            h[i] = new JSeparator();
            if(i==0){
                h[i].setBounds(15, 235, 370, 2);
                h[i].setForeground(Color.lightGray);
            }else{
                h[i].setBounds(15, 235+aux, 370, 2);
                h[i].setForeground(Color.lightGray);
            }
            aux+=50;
            pn1.add(h[i]);
        }
        
       
        lbData = new JLabel();
        lbData.setText("Data de Nascimento ");
        lbData.setBounds(20, 193, 370, 30);
        lbData.setFont(sFont);
             
        lbSexo = new JLabel();
        lbSexo.setText("Sexo ");
        lbSexo.setBounds(20, 243, 370, 30);
        lbSexo.setFont(sFont);
        
        
        lbPai = new JLabel();
        lbPai.setText("Nome do Pai ");
        lbPai.setBounds(20, 293, 370, 30);
        lbPai.setFont(sFont);
        
        
        lbMae = new JLabel();
        lbMae.setText("Nome da Mae ");        
        lbMae.setBounds(20, 343, 370, 30);
        lbMae.setFont(sFont);
        
        lbNacionalidade = new JLabel();
        lbNacionalidade.setText("Nacionalidade ");
        lbNacionalidade.setBounds(20, 393, 370, 30);
        lbNacionalidade.setFont(sFont);
        
        lbNaturalidade = new JLabel();
        lbNaturalidade.setText("Naturalidade ");
        lbNaturalidade.setBounds(20, 443, 370, 30);
        lbNaturalidade.setFont(sFont);
       
        v1 = new JSeparator(SwingConstants.VERTICAL);
        v1.setBounds(397,20,2,652);
        v1.setForeground(Color.DARK_GRAY);
        
        pn1.add(lbNome);
        pn1.add(lbId);
        pn1.add(dados);
        pn1.add(h1);
        pn1.add(lbData);
        pn1.add(lbSexo);
        pn1.add(lbPai);
        pn1.add(lbMae);
        pn1.add(lbNacionalidade);
        pn1.add(lbNaturalidade);
        pn1.add(v1);
    }
    
    //Este metodo configura as cores da borda das JLabels no painel2
    public void configuraLabel(JLabel comp){
        comp.setFont(sFont);
        comp.setBorder(BorderFactory.createLineBorder(new Color(0,192,239),1));
        comp.setOpaque(true);
        comp.setBackground(new Color(0,192,239));
        comp.setForeground(Color.WHITE);
    }
    
    //Este metodo configura os Campos de texto no painel2
    public void configuraTextField(JTextField comp){
        //comp.setEditable(false);
        comp.setFont(sFont);
        comp.setBorder(BorderFactory.createEmptyBorder());

    }
    
    
    private void painel2(){
        
        JLabel lbCurso, lbFaculdade, lbAno,lbCurriculo,lbMorada, lbTelefone, lbEmail, lbEmailInst;
        
        pn2 = new JPanel();
        pn2.setLayout(null);
        pn2.setBounds(400, 0, 1136, 714);
        pn2.setBackground(Color.white);
        
        hp = new JSeparator();
        hp.setBounds(100, 150, 736, 2);
        hp.setForeground(Color.darkGray);
        
        JLabel dados = new JLabel("Dados Academicos e Contactos");
        dados.setBounds(300,110,380,30);
        dados.setFont(new Font("Segoe UI",Font.PLAIN,20));
        
        lbCurso = new JLabel("Curso");
        lbCurso.setBounds(50,180,55,30);
        configuraLabel(lbCurso);
        
        tfCurso = new JTextField();
        tfCurso.setBounds(50, 215, 350, 40);
        tfCurso.setFont(new Font("Segoe UI",Font.ROMAN_BASELINE|Font.PLAIN,20));
        tfCurso.setBorder(BorderFactory.createEmptyBorder());
                
        lbFaculdade = new JLabel("Faculdade");
        lbFaculdade.setBounds(50,265,90,30);
        configuraLabel(lbFaculdade);
        
        tfFaculdade = new JTextField();
        tfFaculdade.setBounds(50, 300, 350, 40);
        configuraTextField(tfFaculdade);
        
        lbAno = new JLabel("Ano de Ingresso");
        lbAno.setBounds(50,350,140,30);
        configuraLabel(lbAno);
        tfAno = new JTextField();
        tfAno.setBounds(50,385,50,40);
        configuraTextField(tfAno);
         
        lbCurriculo = new JLabel("Curriculo");
        lbCurriculo.setBounds(50,435,80,30);
        configuraLabel(lbCurriculo);
        tfCurriculo = new JTextField();
        tfCurriculo.setBounds(50,470,370,40);
        configuraTextField(tfCurriculo);
        
        lbMorada = new JLabel("Morada");
        lbMorada.setBounds(500,180,70,30);
        configuraLabel(lbMorada);
        tfMorada = new JTextField();
        tfMorada.setBounds(500, 215, 390, 40);
        configuraTextField(tfMorada);
        
        
        lbTelefone = new JLabel("Telefone");
        lbTelefone.setBounds(500, 265, 75, 30);
        configuraLabel(lbTelefone);
        tfTelefone = new JTextField();
        tfTelefone.setBounds(500, 300, 390, 40);
        configuraTextField(tfTelefone);
        
        lbEmail = new JLabel("Email Pessoal");
        lbEmail.setBounds(500,350,115,30);
        configuraLabel(lbEmail);
        tfEmail = new JTextField();
        tfEmail.setBounds(500,385,390,40);
        configuraTextField(tfEmail);
        
        lbEmailInst = new JLabel("Email Institucional");
        lbEmailInst.setBounds(500,435,150,30);
        configuraLabel(lbEmailInst);
        tfEmailInst = new JTextField();
        tfEmailInst.setBounds(500,470,390,40);
        configuraTextField(tfEmailInst);
        
        btEditar = new JButton("Editar");
        btEditar.setBounds(220,560,200,50);
        btEditar.setFocusable(false);
        btEditar.setForeground(Color.black);
        btEditar.setBackground(Color.white);
        
        btSalvar = new JButton("Salvar");
        btSalvar.setBounds(480,560,200,50);
        btSalvar.setFocusable(false);
        btSalvar.setForeground(Color.black);
        btSalvar.setBackground(Color.white);
        
        
        pn2.add(hp);
        pn2.add(dados);
        pn2.add(lbCurso);
        pn2.add(tfCurso);
        pn2.add(lbFaculdade);
        pn2.add(tfFaculdade);
        pn2.add(lbMorada);
        pn2.add(tfMorada);
        pn2.add(lbAno);
        pn2.add(tfAno);
        pn2.add(lbCurriculo);
        pn2.add(tfCurriculo);
        pn2.add(lbEmail);
        pn2.add(tfEmail);
        pn2.add(lbEmailInst);
        pn2.add(tfEmailInst);
        pn2.add(lbTelefone);
        pn2.add(tfTelefone);
        pn2.add(btEditar);
        pn2.add(btSalvar);
        
        
    }
    
    private void preencherPerfil(){
        CursoDAO cdao = new CursoDAO();
        Curso curso = cdao.buscar(est.getId());
        //Estas variaveis locais tem as mesmas configuracoes que as globais com o mesmo nome, criei para que o texto
        //das variaveis globais fique alinhado a esquerda e das variaveis locais a direita(acredito que exite forma mais practica de
        //fazer isso mas nao achei)
        JLabel lbData, lbSexo, lbPai, lbMae, lbNacionalidade, lbNaturalidade;
        
        lbData = new JLabel();
        lbData.setBounds(200, 193, 365, 30);
        lbData.setFont(sFont);
        
        lbSexo = new JLabel();
        lbSexo.setBounds(200, 243, 365, 30);
        lbSexo.setFont(sFont);
        
        lbPai = new JLabel();
        lbPai.setText("Nome do Pai ");
        lbPai.setBounds(200, 293, 365, 30);
        lbPai.setFont(sFont);
         
        lbMae = new JLabel();
        lbMae.setText("Nome da Mae ");        
        lbMae.setBounds(200, 343, 365, 30);
        lbMae.setFont(sFont);
        
        lbNacionalidade = new JLabel();
        lbNacionalidade.setText("Nacionalidade ");
        lbNacionalidade.setBounds(200, 393, 365, 30);
        lbNacionalidade.setFont(sFont);
        
        lbNaturalidade = new JLabel();
        lbNaturalidade.setText("Naturalidade ");
        lbNaturalidade.setBounds(200, 443, 365, 30);
        lbNaturalidade.setFont(sFont);
              
        lbData.setText(String.valueOf(est.getDataNascimento()));
        lbData.setHorizontalAlignment(SwingConstants.LEFT);
        lbSexo.setText(String.valueOf(est.getSexo()));
        lbSexo.setHorizontalAlignment( SwingConstants.LEFT);
        lbPai.setText(est.getNomePai());
        lbPai.setHorizontalAlignment(SwingConstants.LEFT);
        lbMae.setText(est.getNomeMae()); 
        lbMae.setHorizontalAlignment(SwingConstants.LEFT);
        lbNacionalidade.setText(est.getNacionalidade());
        lbNacionalidade.setHorizontalAlignment(SwingConstants.LEFT);
        lbNaturalidade.setText(est.getNaturalidade());
        lbNaturalidade.setHorizontalAlignment(SwingConstants.LEFT);
        
        lbNome.setText(String.valueOf(est.getNome()));
        lbId.setText(String.valueOf(est.getId()));
        tfMorada.setText(est.getMorada());
        tfTelefone.setText(est.getTelefone());
        tfEmail.setText(est.getEmailPessoal());
        tfEmailInst.setText(est.getEmailInstitucional());
        tfAno.setText(est.getAnoIngresso());
        tfCurso.setText(curso.getNome());
        tfFaculdade.setText(curso.getFaculdade());
        tfCurriculo.setText(curso.getCurriculo());
        
        pn1.add(lbData);
        pn1.add(lbSexo);
        pn1.add(lbPai);
        pn1.add(lbMae);
        pn1.add(lbNacionalidade);
        pn1.add(lbNaturalidade);
    }
    
}

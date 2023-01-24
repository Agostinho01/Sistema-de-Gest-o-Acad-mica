/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Estudante;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.NORMAL;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Agostinho
 */
public class ViewEstudante implements ActionListener{
    
    private JFrame frame;
    private JPanel pnCima,pnBaixo, pnCentro, pnEsquerda;
    private JLabel lbNome;
    private JComboBox c;
    private JButton btHome, btInicial, btPerfil, btMatricula, btInscricao, btTurmas, btAvaliacoes,
            btDocentes, btPagamentos, btRelatorio;
    private JTextField tfEstudante;
    private JTree treePerfil,treeMatriculas, treeInscricoes, treeTurmas, treeAvaliacoes,
            treeDocentes, treePagamentos, treeRelatorios; 
    
    private Estudante est;
 
    Font fonteBotao = new Font("Segoe UI",Font.BOLD,20);
    
    public ViewEstudante(Estudante est){
        this.est = est;
        frame = new JFrame();
        frame.setTitle("SIGA");
        frame.setLayout(new BorderLayout());
      
  
        frame.setSize(1555,864);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        PainelCima();  
        painelEsquerda();
        painelBaixo();
        painelCentro();
        
        frame.add(pnCima,BorderLayout.NORTH);
        frame.add(pnEsquerda,BorderLayout.WEST);
        frame.add(pnCentro,BorderLayout.CENTER);
        frame.add(pnBaixo, BorderLayout.SOUTH);
                
        frame.setVisible(true);
    }
     
    private void PainelCima(){
        pnCima = new JPanel();
        pnCima.setPreferredSize(new Dimension(1536,100));
        pnCima.setBackground(new Color(65,91,30));
        pnCima.setLayout(null);
     
        JSeparator vertical = new JSeparator(SwingConstants.VERTICAL);
        vertical.setBounds(200,50,1,50);
        vertical.setForeground(Color.LIGHT_GRAY);
        JSeparator horizontal = new JSeparator();
        horizontal.setBounds(0, (int) 49.99, 1336, 1);
        horizontal.setForeground(Color.DARK_GRAY);
        
        //-------------painel 1---------------------------
        JLabel siga = new JLabel("SIGA & UEM");
        siga.setFont(new Font("Segoe UI",Font.PLAIN,35));
        siga.setForeground(Color.white);
        siga.setBounds(20,5,220,40);
  
        tfEstudante = new JTextField("Estudante");
        tfEstudante.setFont(new Font("Segoe UI",Font.PLAIN,15));
        tfEstudante.setBounds(1150, 10, 75, 30);
        tfEstudante.setEditable(false);
        
        lbNome = new JLabel(est.getNome());
        lbNome.setBounds(1240, 10, 350, 30);
        lbNome.setFont(new Font("Segoe UI",Font.PLAIN,20));
        lbNome.setForeground(Color.white);
        
        JPanel pn1 = new JPanel();
        pn1.setLayout(null);
        pn1.setBounds(0,0,1536,50);
        pn1.setBackground(new Color(38,53,17));
        pn1.add(siga);
        pn1.add(tfEstudante);
        pn1.add(lbNome);
        
        //-----------painel 2---------------------------
        btHome = new JButton("Home",new ImageIcon("pagina-inicial.png"));
        btHome.setForeground(Color.black);
        btHome.setBackground(Color.white);
        btHome.setHorizontalTextPosition(JButton.RIGHT);
        btHome.setVerticalTextPosition(JButton.CENTER);
        btHome.setBounds(5,10,100,30);
        btHome.setFont(new Font("Segoe UI",Font.PLAIN,20));
        //btHome.setIconTextGap(5);
        btHome.setFocusable(false);
        //btHome.setOpaque(true);
        btHome.setBorder(BorderFactory.createEtchedBorder());
        btHome.addActionListener(this);
        
        JLabel info = new JLabel();
        info.setText("Ano Lectivo: "+java.time.Year.now()+" / Semestre: 1");
        info.setFont(new Font("Segoe UI",Font.PLAIN,20));
        info.setForeground(Color.black);
        info.setBounds(1040,15,350,20);
        
        JPanel pn2 = new JPanel();
        pn2.setBounds(200,50,1336,50);
        pn2.setBackground(Color.white);
        pn2.setLayout(null);
        pn2.add(btHome);
        pn2.add(info);
        pn2.add(horizontal); 
        
        pnCima.add(vertical);
        pnCima.add(pn1);
        pnCima.add(pn2); 
       
    }
    
    private void painelEsquerda(){
        pnEsquerda = new JPanel();
        pnEsquerda.setLayout(new FlowLayout(FlowLayout.CENTER,5,3));
        pnEsquerda.setPreferredSize(new Dimension(200,768));
        pnEsquerda.setBackground(new Color(65,91,30));
        
        JSeparator horizontal = new JSeparator();
        horizontal.setBounds(0, 500, 1000, 1);
        horizontal.setForeground(Color.red);
        horizontal.setVisible(true);
        
        //Botao Pagina Inicial
        btInicial = new JButton("Pagina Inicial",new ImageIcon("pagina-inicial.png"));
        btInicial.setForeground(Color.black);
        btInicial.setBackground(Color.white);
        btInicial.setHorizontalTextPosition(JButton.RIGHT);
        btInicial.setVerticalTextPosition(JButton.CENTER);
        btInicial.setPreferredSize(new Dimension(190,35));
        btInicial.setFont(fonteBotao);
        //botao.setIconTextGap(5);
        btInicial.setFocusable(false);
        //botao.setOpaque(true);
        btInicial.setBorder(BorderFactory.createEtchedBorder());
        
        //Arvore
        treePerfil = configuraArvore("Meu Perfil", "Perfil", "Editar Perfil");
        treeMatriculas = configuraArvore("Matriculas", "Renovacoes", "Renovar");
        treeInscricoes = configuraArvore("Inscricoes", "Aprovadas", "Reprovadas");
        treeTurmas = configuraArvore("Turmas", "Activas", "Anteriores");
        treeAvaliacoes = configuraArvore("Avaliacoes", "Ver Avaliacoes", "Calendario");
        treeDocentes = configuraArvore("Docentes", "Activos", "Todos");
        treePagamentos = configuraArvore("Pagamentos", "Minha Conta", "");
        treeRelatorios = configuraArvore("Relatorio", "Visao Geral", "");
        
        pnEsquerda.add(horizontal);
        pnEsquerda.add(treePerfil);
        pnEsquerda.add(treeMatriculas);
        pnEsquerda.add(treeInscricoes);
        pnEsquerda.add(treeTurmas);
        pnEsquerda.add(treeAvaliacoes);
        pnEsquerda.add(treeDocentes);
        pnEsquerda.add(treePagamentos);
        pnEsquerda.add(treeRelatorios);
        
    }
    private void painelBaixo(){
        pnBaixo = new JPanel();
        pnBaixo.setPreferredSize(new Dimension(1360,50));
        pnBaixo.setBackground(new Color(38,53,17));
        pnBaixo.setLayout(null);
        
        JLabel label = new JLabel("@2010-2022 UEM-DRA| Desenvolvido por AGOSTINHO|Versao");
        label.setForeground(Color.white);
        label.setFont(new Font("Segoe UI",Font.PLAIN,15));
        label.setBounds(20,10,600,30);
        
        pnBaixo.add(label);
    }
    
    private void painelCentro(){
        
        //(1160,618)
        pnCentro = new JPanel();
        pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER,50,60));
        pnCentro.setBackground(Color.white);
        
        btPerfil = new JButton("Meu Perfil", new ImageIcon("perfil.png"));
        configuraBotoes(btPerfil);
        btMatricula = new JButton("Matriculas", new ImageIcon("matricula.png"));
        configuraBotoes(btMatricula);
        btInscricao = new JButton("Inscriçôes",new ImageIcon("estude.png"));
        configuraBotoes(btInscricao);
        btTurmas = new JButton("Turmas",new ImageIcon("turma.png"));
        configuraBotoes(btTurmas);  
        btAvaliacoes = new JButton("Avaliações",new ImageIcon("teste.png"));
        configuraBotoes(btAvaliacoes);
        btDocentes = new JButton("Docentes",new ImageIcon("perfil.png"));
        configuraBotoes(btDocentes); 
        btPagamentos = new JButton("Pagamentos",new ImageIcon("pagamento.png"));
        configuraBotoes(btPagamentos); 
        btRelatorio = new JButton("Relatório",new ImageIcon("relatorio.png"));
        configuraBotoes(btRelatorio);
        
        
        pnCentro.add(btPerfil);
        pnCentro.add(btMatricula);
        pnCentro.add(btInscricao);
        pnCentro.add(btTurmas);
        pnCentro.add(btAvaliacoes);
        pnCentro.add(btDocentes);
        pnCentro.add(btPagamentos);
        pnCentro.add(btRelatorio);
        
    }
    
    //Metodo para configurar os botoes do painel do centro
    private void configuraBotoes(JButton botao){
        botao.setForeground(Color.black);
        botao.setBackground(Color.white);
        botao.setHorizontalTextPosition(JButton.CENTER);
        botao.setVerticalTextPosition(JButton.BOTTOM);
        botao.setPreferredSize(new Dimension(250,250));
        botao.setFont(fonteBotao);
        botao.setIconTextGap(5);
        botao.setFocusable(false);
        botao.setOpaque(true);
        botao.setBorder(BorderFactory.createEtchedBorder());
        botao.addActionListener(this);
        
        UIManager.put("Button.select", new Color(38,53,17));
        
    }
    
    private JTree configuraArvore(String no, String a, String b){
        
        if(b.equals("")){
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(no);
            DefaultMutableTreeNode filho1 = new DefaultMutableTreeNode(a);
            node.add(filho1);
            JTree tree = new JTree(node);
            tree.setPreferredSize(new Dimension(190,50));
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            tree.setFont(new Font("Segoe UI",Font.BOLD,15));
            tree.setBackground(new Color(65,91,30));
            return tree; 
        }
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(no);
        DefaultMutableTreeNode filho1 = new DefaultMutableTreeNode(a);
        DefaultMutableTreeNode filho2 = new DefaultMutableTreeNode(b); 
        node.add(filho1);
        node.add(filho2);
        JTree tree = new JTree(node);
        tree.setPreferredSize(new Dimension(190,70));
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setFont(new Font("Segoe UI",Font.BOLD,15));
        tree.setBackground(new Color(65,91,30));
        DefaultTreeCellRenderer render = new DefaultTreeCellRenderer();
        tree.setCellRenderer(render);
       
        return tree;
    }

    private void pnCentroLimpo(JPanel painel){
       
       BorderLayout layout = (BorderLayout)frame.getContentPane().getLayout();
       frame.remove((JPanel)layout.getLayoutComponent(BorderLayout.CENTER));
       
       pnCentro.setLayout(new FlowLayout(FlowLayout.CENTER,50,60));
       pnCentro.setBackground(Color.white);
       frame.add(painel,BorderLayout.CENTER);
       
       frame.revalidate();
       frame.repaint();
 
    }
    private void homePage(){
        painelCentro();
        pnCentroLimpo(pnCentro);
        frame.revalidate();
        frame.repaint();
    }
    
       
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btPerfil){
            pnCentroLimpo(new MeuPerfil(est));
        }
        if(e.getSource()==btHome){
            homePage();
        }
        if(e.getSource()==btInscricao){
            pnCentroLimpo(new Inscricoes(est.getId()));
        }
        if(e.getSource()==btAvaliacoes){
            pnCentroLimpo(new Avaliacoes());
        }
    }
    
    
}

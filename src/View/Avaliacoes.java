/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author User
 */
public class Avaliacoes extends JPanel {
    
     
    private JTable tabela;
    private JScrollPane barra;
    
    
    public Avaliacoes(){
        
        this.setBackground(Color.white);
        this.setLayout(null);
        
        String [] nomeColuna = {"NOME DA AVALIACAO","TURMA","CURSO","TIPO DE AVALIACAO","PESO DE AVALIACAO","ESTADO","OPCOES"};
        DefaultTableModel modelo = new DefaultTableModel(null,nomeColuna);
       tabela = new JTable() {
            public Component prepareRenderer(TableCellRenderer renderer,
                    int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                Color color1 = new Color(220, 220, 220);
                Color color2 = Color.WHITE;
                if (!c.getBackground().equals(getSelectionBackground())) {
                    Color coleur = (row % 2 == 0 ? color1 : color2);
                    c.setBackground(coleur);
                    coleur = null;
                }
                return c;
            }
            public boolean isCellEditable(int row, int column) {                
                return false;               
            };
        };
        tabela.setModel(modelo);
        
        barra = new JScrollPane(tabela);
        barra.setBounds(20,20,1297,630);
        //Configura  as corres da linha de titulo da tabela
        JTableHeader Theader = tabela.getTableHeader();
        Theader.setBackground(new Color(222,227,233));
        Theader.setForeground(Color.BLACK);
        Theader.setFont(new Font("Segoe UI", Font.BOLD, 15));
        
        
        this.add(barra);
    }
    
     public void preencherTabela(){
        
        //PacienteDAO pdao = new PacienteDAO();
        //List<Paciente> lista = pdao.listarTodos();
        //DefaultTableModel modeloTabela = (DefaultTableModel)tabela.getModel();
        //modeloTabela.setRowCount(0);
        //for(Paciente p: lista){
        //    modeloTabela.addRow(new Object[]{p.getId_paciente(),p.getNome(),p.getCpf(),p.getEmail(),p.getSexo(),p.getDataNascimento(),p.getTelefone()});
        }
}

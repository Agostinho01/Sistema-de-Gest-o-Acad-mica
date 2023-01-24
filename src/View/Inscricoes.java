/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Curso;
import Model.CursoDAO;
import Model.Disciplina;
import Model.DisciplinaDAO;
import Model.Estudante;
import controller.InscricoesCtr;
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
public class Inscricoes extends JPanel {

    private JTable tabela;
    private JScrollPane barra;
    private int est;

    public Inscricoes(int idEst) {

        this.est = idEst;
        this.setBackground(Color.white);
        this.setLayout(null);

        String[] nomeColuna = {"DISCIPLINA", "CURSO", "ANO LECTIVO", "ANO CURRICULAR", "SEMESTRE", "NOTA FINAL", "OBSERVACAO", "OPCOES"};
        DefaultTableModel modelo = new DefaultTableModel(null, nomeColuna);
        //Faz com que a estutura da tabela alterne as corres entre as linhas(Color1 e Color2) 
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
        barra.setBounds(20, 20, 1297, 630);

        //Configura  as corres da linha de titulo da tabela
        JTableHeader Theader = tabela.getTableHeader();
        Theader.setBackground(new Color(222,227,233));
        Theader.setForeground(Color.BLACK);
        Theader.setFont(new Font("Segoe UI", Font.BOLD, 15));

        this.add(barra);
        preencherIncricoes();
    }

    private void preencherIncricoes() {

        DisciplinaDAO ddao = new DisciplinaDAO();
        CursoDAO cdao = new CursoDAO();
        InscricoesCtr inc = new InscricoesCtr();
        Curso c = cdao.buscar(est);

        List<Disciplina> lista = ddao.listarTodos(est);
        DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
        modeloTabela.setRowCount(0);
        for (Disciplina d : lista) {
            modeloTabela.addRow(new Object[]{d.getNome(), c.getSigla(), java.time.Year.now(), d.getAnoCurricular(), d.getSemestre(), inc.bringNotas(est, d.getId()), inc.observacao(est, d.getId()), "still not"});
        }

    }

}

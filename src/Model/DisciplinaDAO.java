/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.ConexaoBD;
import Model.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */

public class DisciplinaDAO {
    
       public Disciplina buscar(){
        Connection con = ConexaoBD.getConectar();
        String sql = "SELECT * FROM disciplina WHERE id IN (SELECT idDisciplina FROM estudante_disciplina where idEstudante=20202392);";
        Disciplina d = new Disciplina();
        
        try(PreparedStatement smt = con.prepareCall(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                d.setId(resultado.getInt("id"));
                d.setNome(resultado.getNString("nome")); 
                d.setSigla(resultado.getNString("sigla"));
                d.setSemestre((resultado.getNString("semestre")).charAt(0));
                d.setIdCurso(resultado.getInt("idCurso"));
                d.setAnoCurricular(resultado.getInt("anoCurricular"));
                
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros");
        }
        return d;
    }
    
    public List<Disciplina> listarTodos(int idEst){
        Connection con = ConexaoBD.getConectar();
        List<Disciplina> lista = new ArrayList<>();
        String sql = "SELECT * FROM disciplina WHERE id IN (SELECT idDisciplina FROM estudante_disciplina where idEstudante="+idEst+");";
        try(PreparedStatement smt = con.prepareCall(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                Disciplina d = new Disciplina();
                d.setId(resultado.getInt("id"));
                d.setNome(resultado.getNString("nome")); 
                d.setSigla(resultado.getNString("sigla"));
                d.setSemestre((resultado.getNString("semestre")).charAt(0));
                d.setIdCurso(resultado.getInt("idCurso"));
                d.setAnoCurricular(resultado.getInt("anoCurricular"));
                lista.add(d);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros: "+ex.getMessage());
        }
        
        return lista;
    }   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class NotasDAO {
    
     
     public Notas buscar(int idEst,int idDisc){
        Connection con = ConexaoBD.getConectar();
        String sql = "SELECT  idNotas,t1,t2 FROM estudante_disciplina E INNER JOIN notas N ON N.idNotas = E.inscricao WHERE E.idDisciplina="+idDisc+" AND idEstudante="+idEst+";";
        Notas n = new Notas();
        try(PreparedStatement smt = con.prepareCall(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                n.setIdNotas(resultado.getInt("idNotas"));
                n.setT1(resultado.getInt("t1"));
                n.setT2(resultado.getInt("t2"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros");
        }
        return n;
    }
    
    public List<Notas> listarTodos(Estudante est){
        Connection con = ConexaoBD.getConectar();
        List<Notas> lista = new ArrayList<>();
        String sql = "SELECT distinct idNotas, t1, t2 FROM estudante_disciplina E,"
                + " notas N  WHERE E.idEstudante="+String.valueOf(est.getId())+";";
        try(PreparedStatement smt = con.prepareCall(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                Notas n = new Notas();
                n.setIdNotas(resultado.getInt("idNotas"));
                n.setT1(resultado.getInt("t1"));
                n.setT2(resultado.getInt("t2"));
                lista.add(n);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros: "+ex.getMessage());
        }
        
        return lista;
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Estudante_DisciplinaDAO {
    
     public Estudante_Disciplina buscar(){
        Connection con = ConexaoBD.getConectar();
        String sql = "SELECT * FROM curso WHERE id = (SELECT idCurso FROM estudante where id=20202392)";
        Estudante_Disciplina ed = new Estudante_Disciplina();
        try(PreparedStatement smt = con.prepareCall(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                ed.setIdEstudante(resultado.getInt("idEstudante"));
                ed.setIdDisciplina(resultado.getInt("idDisciplina"));
                ed.setDisciplina(resultado.getInt("disciplina"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros");
        }
        return ed;
    }
    
    
    
    
}

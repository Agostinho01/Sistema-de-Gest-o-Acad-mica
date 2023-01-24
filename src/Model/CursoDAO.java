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
public class CursoDAO {
    
    public Curso buscar(int idEst){
        Connection con = ConexaoBD.getConectar();
        String sql = "SELECT * FROM curso WHERE id = (SELECT idCurso FROM estudante where id="+idEst+")";
        Curso c = new Curso();
        try(PreparedStatement smt = con.prepareCall(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getNString("nome")); 
                c.setSigla(resultado.getNString("sigla"));
                c.setDuracao(resultado.getInt("duracaoAnos"));
                c.setCurriculo(resultado.getNString("curriculo"));
                c.setFaculdade(resultado.getNString("faculdade"));
                
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros");
        }
        return c;
    }
    
    
    
    
}

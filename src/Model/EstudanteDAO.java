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
public class EstudanteDAO {
    
    public Estudante buscar(int id){
        Connection con = ConexaoBD.getConectar();
        String sql = "SELECT * FROM estudante WHERE id="+String.valueOf(id)+"";
        Estudante e = new Estudante();
        try(PreparedStatement smt = con.prepareCall(sql)){
            ResultSet resultado = smt.executeQuery();
            while(resultado.next()){
                e.setId(resultado.getInt("id"));
                e.setNome(resultado.getNString("nome"));
                e.setSexo(resultado.getNString("sexo").charAt(0)); 
                e.setMorada(resultado.getNString("morada"));
                e.setNomePai(resultado.getNString("nomePai"));
                e.setNomeMae(resultado.getNString("nomeMae"));
                e.setNacionalidade(resultado.getNString("nacionalidade"));
                e.setNaturalidade(resultado.getNString("naturalidade"));
                e.setEmailPessoal(resultado.getString("emailPessoal"));
                e.setEmailInstitucional(resultado.getString("emailInstitucional"));
                e.setTelefone(resultado.getNString("telefone"));
                e.setDataNascimento(String.valueOf(resultado.getDate("dataNascimento")));
                e.setIdCurso(resultado.getInt("idCurso"));
                e.setAnoIngresso(resultado.getNString("anoIngresso"));
                e.setSenha(resultado.getNString("senha"));
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao buscar registros");
        }
        return e;
    }
    
}

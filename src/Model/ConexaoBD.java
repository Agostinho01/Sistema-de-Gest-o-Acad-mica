/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author User
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class ConexaoBD {
    
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String usuario = "root";
    private static final String senha = "824516700";
    private static final String url = "jdbc:mysql://localhost/academico";

    public static Connection getConectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar a base de dados " + ex.getMessage());
        }
        return con;
    }
    
}

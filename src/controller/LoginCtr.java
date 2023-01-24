/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Estudante;
import Model.EstudanteDAO;

/**
 *
 * @author User
 */
public class LoginCtr {
    
    EstudanteDAO estDao = new EstudanteDAO();
    public Estudante validacao(String user, String senha){ 
        int id;
        try{
            id = Integer.parseInt(user);
        }catch(NumberFormatException n){
            return null;
        }
        if(senha.length()<6){
            return null;
        }else{
            Estudante est = estDao.buscar(id);
            if(est.getId()==id && est.getSenha().equals(senha)){
                return est;
            }
        }
        return null;   
    }
    
    
}

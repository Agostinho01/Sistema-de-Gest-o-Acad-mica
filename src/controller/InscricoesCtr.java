/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.Estudante;
import Model.Notas;
import Model.NotasDAO;

/**
 *
 * @author User
 */
public class InscricoesCtr {
    
    public float bringNotas(int idEst, int idDisc){
        float t1,t2,media=0;
        NotasDAO ndao = new NotasDAO();
        Notas n = ndao.buscar(idEst, idDisc);
        media = (n.getT1()+n.getT2())/2;
        
        return media;
    }
    
    public String observacao(int idEst, int idDisc){
        float nota = bringNotas(idEst, idDisc);
        String resp;
        if (nota>=10 & nota<14){
            resp = "ADMITIDO AO EXAME";
        }else if(nota>=14){
            resp="DISPENSADO";
        }else{
            resp="EXCLUIDO";
        }
        return resp;
    }
    
    
    
    
}

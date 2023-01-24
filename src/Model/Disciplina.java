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
public class Disciplina {
    
    private String nome,sigla;
    private char semestre;
    private int id, idCurso, anoCurricular;

    public int getAnoCurricular() {
        return anoCurricular;
    }

    public void setAnoCurricular(int anoCurricular) {
        this.anoCurricular = anoCurricular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public char getSemestre() {
        return semestre;
    }

    public void setSemestre(char semestre) {
        this.semestre = semestre;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    
}

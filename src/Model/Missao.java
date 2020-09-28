/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author rafa_
 */
public class Missao {
        private int equipe;
        private Agente agente = new Agente();
        private String horarioInicio;
        private String horarioFim;
        private int totalKm;
        private String varredura;

    public Missao(int equipe, String horarioInicio, String horarioFim, int totalKm, String varredura) {
        this.equipe = equipe;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.totalKm = totalKm;
        this.varredura = varredura;
    }

    public Missao() {
    }

    public int getEquipe() {
        return equipe;
    }

    public void setEquipe(int equipe) {
        this.equipe = equipe;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public int getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(int totalKm) {
        this.totalKm = totalKm;
    }

    public String getVarredura() {
        return varredura;
    }

    public void setVarredura(String varredura) {
        this.varredura = varredura;
    }
        
        
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.AgenteDAO;
import java.util.ArrayList;
import com.itextpdf.text.Image;
import java.util.List;
/**
 *
 * @author rafa_
 */
public class Agente {
    private int codigo;
    private String nome;
    private String placa;
    private String reside;
    private String horaInicio;
    private String horaFim;
    private String horaChegada;
    private int totalKM;
    private String varredura;
    private String timeLine;
    
    private List<Image> imagens = new ArrayList<Image>();
 

    public Agente() {
    }

    public Agente(int codigo ,String nome, String placa,String reside, String horaInicio, String horaFim, String horaChegada, int totalKM, String varredura, String timeLine) {
        this.codigo = codigo;
        this.nome = nome;
        this.placa = placa;
        this.reside = reside;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.horaChegada = horaChegada;
        this.totalKM = totalKM;
        this.varredura = varredura;
        this.timeLine = timeLine;
    }

    public List<Image> getImagens() {
        return imagens;
    }

    public void setImagens(List<Image> imagens) {
        this.imagens = imagens;
    }

    public int gravar(Agente agente){
        AgenteDAO dao = new AgenteDAO();
        return dao.create(agente);
     
    }
    public List<Agente> pegarAgentes(){
        List<Agente> agente = new ArrayList<Agente>();
        AgenteDAO dao = new AgenteDAO();
        agente = dao.read();
        return agente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public int getTotalKM() {
        return totalKM;
    }

    public void setTotalKM(int totalKM) {
        this.totalKM = totalKM;
    }

    public String getVarredura() {
        return varredura;
    }

    public void setVarredura(String varredura) {
        this.varredura = varredura;
    }

    public String getTimeLine() {
        return timeLine;
    }

    public void setTimeLine(String timeLine) {
        this.timeLine = timeLine;
    }

    public String getReside() {
        return reside;
    }

    public void setReside(String reside) {
        this.reside = reside;
    }
    
    @Override
    public String toString() {
        return "Agente{" + "codigo=" + codigo + ", nome=" + nome + ", placa=" + placa + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", horaChegada=" + horaChegada + ", totalKM=" + totalKM + ", varredura=" + varredura + ", timeLine=" + timeLine + ", imagens=" + imagens + '}';
    }
    
    
    
}

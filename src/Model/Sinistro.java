/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.IscaDAO;
import DAO.SinistroDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafa_
 */
public class Sinistro {
    
    int Protocolo;
    String dataCriacao;
    String Cliente;
    String TipoOcorrencia,Informante,contato,HoraOcorrencia,placa,carreta,modelo,cor,coordenadas,cidade;
    String NomeCondutor,cpfCondutor,contatoCondutor,tipoAcionamento,descricao;
    Agente agente;
    double ValorCarga;
    int isca;
    int ChamadoAgentes;
  
    public Sinistro(){
        
    }

    public Sinistro(String Cliente, String TipoOcorrencia, String Informante, String contato, String HoraOcorrencia, String placa, String carreta, String modelo, String cor, String coordenadas, String cidade, String NomeCondutor, String cpfCondutor, String contatoCondutor, String tipoAcionamento, String descricao, Agente agente, double ValorCarga, int isca, int ChamadoAgentes) {
        this.Cliente = Cliente;
        this.TipoOcorrencia = TipoOcorrencia;
        this.Informante = Informante;
        this.contato = contato;
        this.HoraOcorrencia = HoraOcorrencia;
        this.placa = placa;
        this.carreta = carreta;
        this.modelo = modelo;
        this.cor = cor;
        this.coordenadas = coordenadas;
        this.cidade = cidade;
        this.NomeCondutor = NomeCondutor;
        this.cpfCondutor = cpfCondutor;
        this.contatoCondutor = contatoCondutor;
        this.tipoAcionamento = tipoAcionamento;
        this.descricao = descricao;
        this.agente = agente;
        this.ValorCarga = ValorCarga;
        this.isca = isca;
        this.ChamadoAgentes = ChamadoAgentes;
        
    }

   

    public Sinistro(int protocolo,String cliente, String tipoOcorrencia, String Informante, String Contato, String HoraOcorrencia, String Placa, String Carreta, String Modelo, String Cor, String Coordenadas, String Cidade, String NomeCondutor, String CpfCondutor, String contatoCondutor, String TipoAcionamento, String Descricao, Agente agente, double ValorCarga, int ca, String dataCriacao) {
        this.Protocolo = protocolo;
        this.Cliente = cliente;
        this.TipoOcorrencia = tipoOcorrencia;
        this.Informante = Informante;
        this.contato = Contato;
        this.HoraOcorrencia = HoraOcorrencia;
        this.placa = Placa;
        this.carreta = Carreta;
        this.modelo = Modelo;
        this.cor = Cor;
        this.coordenadas = Coordenadas;
        this.cidade = Cidade;
        this.NomeCondutor = NomeCondutor;
        this.cpfCondutor = CpfCondutor;
        this.contatoCondutor = contatoCondutor;
        this.tipoAcionamento = TipoAcionamento;
        this.descricao = Descricao;
        this.agente = agente;
        this.ValorCarga = ValorCarga;
        this.isca = ca;
        this.dataCriacao = dataCriacao;
    }

    

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
     
    

    public int getChamadoAgentes() {
        return ChamadoAgentes;
    }

    public void setChamadoAgentes(int ChamadoAgentes) {
        this.ChamadoAgentes = ChamadoAgentes;
    }

    public int getProtocolo() {
        return Protocolo;
    }

    public void setProtocolo(int Protocolo) {
        this.Protocolo = Protocolo;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getTipoOcorrencia() {
        return TipoOcorrencia;
    }

    public void setTipoOcorrencia(String TipoOcorrencia) {
        this.TipoOcorrencia = TipoOcorrencia;
    }

    public String getInformante() {
        return Informante;
    }

    public void setInformante(String Informante) {
        this.Informante = Informante;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getHoraOcorrencia() {
        return HoraOcorrencia;
    }

    public void setHoraOcorrencia(String HoraOcorrencia) {
        this.HoraOcorrencia = HoraOcorrencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCarreta() {
        return carreta;
    }

    public void setCarreta(String carreta) {
        this.carreta = carreta;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNomeCondutor() {
        return NomeCondutor;
    }

    public void setNomeCondutor(String NomeCondutor) {
        this.NomeCondutor = NomeCondutor;
    }

    public String getCpfCondutor() {
        return cpfCondutor;
    }

    public void setCpfCondutor(String cpfCondutor) {
        this.cpfCondutor = cpfCondutor;
    }

    public String getContatoCondutor() {
        return contatoCondutor;
    }

    public void setContatoCondutor(String contatoCondutor) {
        this.contatoCondutor = contatoCondutor;
    }

    public String getTipoAcionamento() {
        return tipoAcionamento;
    }

    public void setTipoAcionamento(String tipoAcionamento) {
        this.tipoAcionamento = tipoAcionamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public double getValorCarga() {
        return ValorCarga;
    }

    public void setValorCarga(double ValorCarga) {
        this.ValorCarga = ValorCarga;
    }

    public int getIsca() {
        return isca;
    }

    public void setIsca(int isca) {
        this.isca = isca;
    }

    

    

    
   public Sinistro bucarSinistro(int protocolo){
       SinistroDAO dao = new SinistroDAO();
       Sinistro sinistro = dao.buscar(protocolo);
       return sinistro;
   }
    
  

  
    public boolean Gravar(Sinistro sinistro){
        SinistroDAO dao = new SinistroDAO();
        
        int resp = dao.create(sinistro);
        if (resp != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static DefaultTableModel getTableModel(){
        SinistroDAO dao = new SinistroDAO();
        List<Sinistro> aaa = dao.read();
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("Protocolo");
        model.addColumn("Data");
        model.addColumn("Cliente");
        model.addColumn("Tipo Ocorrencia");
        model.addColumn("Tipo Acionamento   ");
        model.addColumn("Valor Carga");
        for (Sinistro i:aaa){
           
           
            String[] reg = {String.valueOf(i.getProtocolo()),i.getDataCriacao(),i.getCliente(),i.getTipoOcorrencia(),i.getTipoAcionamento(),String.valueOf(i.getValorCarga())};
            model.addRow(reg);
        
        
    }
        return model;
    }
    
    
    
}

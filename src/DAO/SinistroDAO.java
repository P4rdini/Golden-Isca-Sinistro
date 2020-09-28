/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Agente;
import Model.Isca;
import Model.Sinistro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author rafa_
 */
public class SinistroDAO implements Persistencia {

    
    public int create(Sinistro obj) {
           int Protocolo = 0;
           Connection con = ConnectionFactoryIsca.getConnection();
           PreparedStatement ps = null;
           ResultSet rs=null;
           String sql = "INSERT INTO SINISTRO (Cliente,TipoOcorrencia,Informante,Contato,HoraOcorrencia,"
                   +"placa,carreta,modelo,cor,valorCarga,coordenadas,cidade,isca,nomeCondutor,cpfCondutor,"
                   + "contatoCondutor,tipoAcionamento,descricao,agente,dataCriacao) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      //   String sql = "Insert into SINISTRO(Cliente,TipoOcorrencia,TipoAcionamento) values (?,?,?)";
           try{
               ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
               
               ps.setString(1,obj.getCliente());
               ps.setString(2,obj.getTipoOcorrencia());
               ps.setString(3,obj.getInformante());
               ps.setString(4,obj.getContato());
               ps.setString(5,obj.getHoraOcorrencia());
               ps.setString(6,obj.getPlaca());
               ps.setString(7,obj.getCarreta());
               ps.setString(8,obj.getModelo());
               ps.setString(9,obj.getCor());
               ps.setDouble(10,obj.getValorCarga());
               ps.setString(11,obj.getCoordenadas());
               ps.setString(12,obj.getCidade());
               ps.setInt(13, obj.getIsca());
               ps.setString(14,obj.getNomeCondutor());
               ps.setString(15,obj.getCpfCondutor());
               ps.setString(16,obj.getContatoCondutor());
               ps.setString(17,obj.getTipoAcionamento());
               ps.setString(18,obj.getDescricao());
               Agente a = new Agente();
               a=obj.getAgente();
               int valor=a.gravar(obj.getAgente());
                if(valor != 0 ){
                    System.out.println("deu certo");
               ps.setInt(19, valor);
                    
                }else{
                    System.out.println("nao salvou o agente no sinistro");
                }
               System.out.println("Numero do agente "+valor);
               
               ps.setString(20, Isca.modeloData(Calendar.getInstance().getTime()));
             
               
               ps.execute();
               rs=ps.getGeneratedKeys();
               while(rs.next()){
                   Protocolo = rs.getInt(1);
                   System.out.println("valor do retrno do banco " + rs.getInt(1));
               }
           }catch(SQLException e){
               Protocolo = 0 ;
               System.out.println(e.getLocalizedMessage() +"  Erro em Salvar o relatorio de Sinistro");
           }finally{
               ConnectionFactoryIsca.closeConnection(con, ps, rs);
           }
           return Protocolo;
    }

    @Override
    public List read() {
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM SINISTRO ORDER BY Cliente";
        List<Sinistro> lista = new ArrayList<Sinistro>();
        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                Cliente,TipoOcorrencia,Informante,Contato,HoraOcorrencia,"
//                   + "TipoAcionamento,HoraAcionamento,HoraTermino,NomeAgente,PlacaAgente,HoraChegadaAgente"
//                   + ",Placa,Carreta,Modelo,Cor,Endereco,ValorCarga,Coordenadas,Cidade,NomeCondutor,CpfCondutor,"
//                   + "ContatoCondutor,Descricao
                int protocolo = rs.getInt("Protocolo");
                String cliente = rs.getString("cliente");
                String tipoOcorrencia = rs.getString("TipoOcorrencia");
                String Informante = rs.getString("Informante");
                String Contato = rs.getString("Contato");
                String HoraOcorrencia = rs.getString("HoraOcorrencia");          
                String Placa = rs.getString("Placa");
                String Carreta = rs.getString("Carreta");
                String Modelo = rs.getString("Modelo");
                String Cor = rs.getString("Cor");
                double ValorCarga = rs.getDouble("ValorCarga");
                String Coordenadas = rs.getString("Coordenadas");
                String Cidade = rs.getString("Cidade");
                int isca = rs.getInt("isca");                          
                String NomeCondutor = rs.getString("NomeCondutor");
                String CpfCondutor = rs.getString("CpfCondutor");
                String ContatoCondutor = rs.getString("ContatoCondutor");
                String TipoAcionamento = rs.getString("TipoAcionamento");
                String Descricao = rs.getString("Descricao");
                AgenteDAO dao = new AgenteDAO();
                Agente agente =dao.buscarAgente(rs.getInt("agente"));
                String dataCriacao=rs.getString("dataCriacao");
                
                
                lista.add(new Sinistro(protocolo,cliente, tipoOcorrencia, Informante, Contato, HoraOcorrencia, Placa, Carreta, Modelo, Cor, Coordenadas, Cidade, NomeCondutor, CpfCondutor, ContatoCondutor, TipoAcionamento, Descricao, agente, ValorCarga, isca,dataCriacao));
                System.out.println(lista.get(0).getCliente());
            }
        } catch (SQLException ex) {
            throw new RuntimeException("erro no select");
        } finally {
            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return lista;


    }
    
    public Sinistro buscar(int Protocolo){
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM SINISTRO where protocolo ="+Protocolo+"";
        Sinistro sinistro = new Sinistro();
        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
//                Cliente,TipoOcorrencia,Informante,Contato,HoraOcorrencia,"
//                   + "TipoAcionamento,HoraAcionamento,HoraTermino,NomeAgente,PlacaAgente,HoraChegadaAgente"
//                   + ",Placa,Carreta,Modelo,Cor,Endereco,ValorCarga,Coordenadas,Cidade,NomeCondutor,CpfCondutor,"
//                   + "ContatoCondutor,Descricao
                int protocolo = rs.getInt("Protocolo");
                String cliente = rs.getString("cliente");
                String tipoOcorrencia = rs.getString("TipoOcorrencia");
                String Informante = rs.getString("Informante");
                String Contato = rs.getString("Contato");
                String HoraOcorrencia = rs.getString("HoraOcorrencia");          
                String Placa = rs.getString("Placa");
                String Carreta = rs.getString("Carreta");
                String Modelo = rs.getString("Modelo");
                String Cor = rs.getString("Cor");
                double ValorCarga = rs.getDouble("ValorCarga");
                String Coordenadas = rs.getString("Coordenadas");
                String Cidade = rs.getString("Cidade");
                int isca = rs.getInt("isca");                          
                String NomeCondutor = rs.getString("NomeCondutor");
                String CpfCondutor = rs.getString("CpfCondutor");
                String ContatoCondutor = rs.getString("ContatoCondutor");
                String TipoAcionamento = rs.getString("TipoAcionamento");
                String Descricao = rs.getString("Descricao");
                AgenteDAO dao = new AgenteDAO();
                Agente agente =dao.buscarAgente(rs.getInt("agente"));
                String dataCriacao=rs.getString("dataCriacao");
                
                
                sinistro = new Sinistro(protocolo,cliente, tipoOcorrencia, Informante, Contato, HoraOcorrencia, Placa, Carreta, Modelo, Cor, Coordenadas, Cidade, NomeCondutor, CpfCondutor, ContatoCondutor, TipoAcionamento, Descricao, agente, ValorCarga, isca,dataCriacao);
         
            }
        } catch (SQLException ex) {
            throw new RuntimeException("erro ao buscar o sinistro");
        } finally {
            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return sinistro;

    }
    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

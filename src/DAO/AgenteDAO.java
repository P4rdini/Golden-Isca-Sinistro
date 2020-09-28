/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Agente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author rafa_
 */
public class AgenteDAO {
    
    public List<Agente> read() {
        
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM AGENTE ORDER BY nome";
        ArrayList<Agente> agente = new ArrayList<Agente>();
        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
              
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("Nome");
                String placa = rs.getString("placa");
                String reside = rs.getString("Reside");
                String horarioInicio = rs.getString("horarioInicio");
                String horarioFim = rs.getString("horarioFim");
                String horarioChegada = rs.getString("horarioChegada");
                int totalKM = rs.getInt("totalKM");
                String varreduta = rs.getString("varredura");
                String timeLine = rs.getString("timeLine");
               
                agente.add(new Agente(codigo, nome, placa,reside, horarioInicio, horarioFim, horarioChegada, totalKM, varreduta, timeLine));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("erro no select");
        } finally {
            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return agente;
    }
    
    public int create(Agente obj){
         int id = 0;
        Connection con = ConnectionFactoryIsca.getConnection();
        System.out.println("conectado");
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO AGENTE(Nome,placa,horarioInicio,horarioFim,horaChegada,totalKm,varredura,timeLine,reside)VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            Calendar calendario = new GregorianCalendar();
            Date date = new Date();
            System.out.println();

            //  for(int i=0;i<obj.lista.size();i++){
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getPlaca());
            pst.setString(3, obj.getHoraInicio());
            pst.setString(4, obj.getHoraFim());
            pst.setString(5, obj.getHoraChegada());
            pst.setInt(6, obj.getTotalKM());
            pst.setString(7, obj.getVarredura());
            pst.setString(8, obj.getTimeLine());
            pst.setString(9, obj.getReside());
            pst.execute();
            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);

            }
            //   }

            System.out.println("gravou");

        } catch (SQLException e) {
            id = 0;

            System.out.println("Erro ao criar a linha" + e.getMessage());
            return id;

        } finally {
            ConnectionFactoryIsca.closeConnection(con, pst, rs);
        }
        return id;
    }
    
    public Agente buscarAgente(int codigo){
        
              Agente agente=null;
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM AGENTE where codigo='"+codigo+"'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                
            String horaChegada = rs.getString("horaChegada");
            System.out.println("aadjlasjlafdlj");
            String horaFim = rs.getString("horarioFim");
            String reside = rs.getString("Reside");
            String horaInicio = rs.getString("horarioInicio");
            String nome = rs.getString("nome");
            String placa = rs.getString("placa");
            String timeLine = rs.getString("timeLine");
            int totalKM = rs.getInt("totalKM");
            String varredura = rs.getString("varredura");
             
            agente = new Agente(codigo, nome, placa,reside, horaInicio, horaFim, horaChegada, totalKM, varredura, timeLine);
              
            } 
            
        } catch (SQLException ex) {
            agente = null;
            throw new RuntimeException("erro no select");
        } finally {
            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return agente;
    }
}

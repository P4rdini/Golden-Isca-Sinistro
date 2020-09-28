package DAO;

import Model.Isca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rafa_
 */
public class IscaDAO implements Persistencia<Isca> {
    /*
     public String InverterData(String resp) {

     String dia = "", mes = "", ano = "", str = "";

     for (int i = 0; i < resp.length(); i++) {
     if (resp.charAt(i) == '/') {

     } else {
     str += resp.charAt(i);
     }
     }
     for (int i = 0; i < 2; i++) {
     dia += String.valueOf(str.charAt(i));
     }
     for (int i = 2; i < 4; i++) {
     mes += String.valueOf(str.charAt(i));
     }
     for (int i = 4; i < 8; i++) {
     ano += String.valueOf(str.charAt(i));
     }

     return ano.toString() + "/" + mes.toString() + "/" + dia.toString();

     }

     public String DataOriginal(String resp) {
     String dia = "", mes = "", ano = "", str = "";

     for (int i = 0; i < resp.length(); i++) {
     if (resp.charAt(i) == '/') {

     } else {
     str += resp.charAt(i);
     }
     }
     for (int i = 0; i < 4; i++) {
     ano += String.valueOf(str.charAt(i));
     }
     for (int i = 4; i < 6; i++) {
     mes += String.valueOf(str.charAt(i));
     }
     for (int i = 6; i < 8; i++) {
     dia += String.valueOf(str.charAt(i));
     }

     return dia.toString() + "/" + mes.toString() + "/" + ano.toString() ;

     }
     */

    @Override
    public int create(Isca obj) {
        int id = 0;
        Connection con = ConnectionFactoryIsca.getConnection();
        System.out.println("conectado");
        PreparedStatement pst = null;
        PreparedStatement pstTeste = null;
        ResultSet rs = null;
        String sql = "INSERT INTO ISCA(ID,iccid,CLIENTE,status,operadora,tipo,dataCriacao)VALUES(?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            Calendar calendario = new GregorianCalendar();
            Date date = new Date();
            System.out.println();

            //  for(int i=0;i<obj.lista.size();i++){
            pst.setInt(1, obj.getID());
            pst.setString(2, obj.getIccid());
            pst.setString(3, obj.getCliente());
            pst.setBoolean(4, false);
            pst.setString(5, obj.getOperadora());
            pst.setString(6, obj.getTipo());
            pst.setString(7, Isca.modeloData(date));
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

    public boolean Alterar(Isca obj) {
        Connection con = ConnectionFactoryIsca.getConnection();
        System.out.println("conectado");
        PreparedStatement pst = null;
        PreparedStatement pstTeste = null;
        ResultSet rs = null;
        String sql = "update ISCA set iccid = ?,CLIENTE = ?,status =?,operadora =?,tipo =? ,dataAtivacao = ? where id =" + obj.getID();
        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, obj.getIccid());
            pst.setString(2, obj.getCliente());
            pst.setBoolean(3, obj.isStatus());
            pst.setString(4, obj.getOperadora());
            pst.setString(5, obj.getTipo());
            pst.setString(6, obj.getDataAtivacao());
            pst.executeUpdate();

            System.out.println("gravou alteracao");

        } catch (SQLException e) {

            System.out.println("Erro ao criar a linha" + e.getMessage());
            return false;

        } finally {
            ConnectionFactoryIsca.closeConnection(con, pst, rs);
        }
        return true;
    }

    public boolean Desativar(int id) {
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update ISCA set status= false ,dataAtivacao =null where id =" + id;
        try {
            ps = con.prepareStatement(sql);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("nao foi possivel Desativar");
            return false;
        } finally {
            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return true;
    }

    @Override
    public boolean update(Isca obj) {
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update ISCA set status= true ,dataAtivacao = ? where id = ?";
        String sql2 = "update ISCA set status= true ,dataAtivacao = ?,cliente = ? where id = ?";
        try {
            if (Isca.getLista().get(0).getCliente() != null) {
                ps = con.prepareStatement(sql2);
                for (int i = 0; i < Isca.getLista().size(); i++) {
                    ps.setString(1, Isca.getLista().get(i).getDataAtivacao());
                    ps.setString(2, Isca.getLista().get(i).getCliente());
                    ps.setInt(3, Isca.getLista().get(i).getID());
                    ps.executeUpdate();

                }
            } else {

                ps = con.prepareStatement(sql);
                for (int i = 0; i < Isca.getLista().size(); i++) {
                    ps.setString(1, Isca.getLista().get(i).getDataAtivacao());
                    ps.setInt(2, Isca.getLista().get(i).getID());
                    ps.executeUpdate();

                }
            }
        } catch (SQLException e) {
            System.out.println("nao foi possivel alterar os dados");
            return false;
        } finally {
            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return true;
    }

    public boolean delete(int id) {
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement pst = null;
        String sql = "delete from ISCA where id =" + id;
        try {
            pst = con.prepareStatement(sql);

            pst.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n" + e.getSQLState());
            return false;
        } finally {
            ConnectionFactoryIsca.closeConnection(con, pst);
        }
        return true;
    }

    @Override
    public List<Isca> read() {
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ISCA ORDER BY dataAtivacao";
        ArrayList<Isca> lista = new ArrayList<Isca>();
        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                boolean status = rs.getBoolean("status");
                int id = rs.getInt("id");
                String iccid = rs.getString("ICCID");
                String cliente = rs.getString("cliente");
                String data;
                if (rs.getString("dataAtivacao") != null) {
                    data = rs.getString("dataAtivacao");
                } else {
                    data = null;
                }

                String operadora = rs.getString("OPERADORA");
                String tipo = rs.getString("TIPO");
                lista.add(new Isca(status, id, iccid, cliente, data, operadora, tipo));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("erro no select");
        } finally {
            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return lista;
    }

    public List<Isca> findByCodigo(String coluna, String r) {
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ISCA WHERE " + coluna + " LIKE '%" + r + "%' order by dataAtivacao desc";
        String sql2 = "SELECT * FROM ISCA WHERE id LIKE '" + r + "' order by dataAtivacao desc";
        System.out.println(sql);
        ArrayList<Isca> lista = new ArrayList<Isca>();
        try {
            if (coluna.equals("ExatoID")) {
                pst = con.prepareStatement(sql2);
            } else {
                pst = con.prepareStatement(sql);
            }
            rs = pst.executeQuery();

            if (rs == null) {
                JOptionPane.showMessageDialog(null, "Nao foi encontrado");
            }
            if (coluna.equals("DataAtivacao")) {
                while (rs.next()) {
                    Isca isca = new Isca();

                    isca.setStatus(rs.getBoolean("status"));
                    isca.setID(rs.getInt("id"));
                    isca.setIccid(rs.getString("ICCID"));
                    isca.setCliente(rs.getString("cliente"));
                    isca.setDataAtivacao(rs.getString("dataAtivacao"));
                    isca.setOperadora(rs.getString("OPERADORA"));
                    isca.setTipo(rs.getString("TIPO"));
                    lista.add(isca);

                }

            } else {
                while (rs.next()) {
                    Isca isca = new Isca();

                    isca.setStatus(rs.getBoolean("status"));
                    isca.setID(rs.getInt("id"));
                    isca.setIccid(rs.getString("ICCID"));
                    isca.setCliente(rs.getString("cliente"));
                    isca.setDataAtivacao(rs.getString("dataAtivacao"));
                    isca.setOperadora(rs.getString("OPERADORA"));
                    isca.setTipo(rs.getString("TIPO"));
                    lista.add(isca);

                }
            }
        } catch (SQLException e) {
            //System.out.println(e.getErrorCode());
            System.out.println(e.getLocalizedMessage());
        } finally {
            ConnectionFactoryIsca.closeConnection(con, pst, rs);
        }
        return lista;

    }

    @Override
    public Isca findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean pesquisa(String coluna, String conteudo, String tipo) {
        boolean resp = false;
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM ISCA WHERE " + coluna + " = " + conteudo + "";
        String sql2 = "SELECT * FROM ISCA WHERE " + coluna + " LIKE '%" + conteudo + "%'";

        try {

            if (tipo.equals("contem")) {
                pst = con.prepareStatement(sql2);

                rs = pst.executeQuery();
            }
            if (tipo.equals("igual")) {
                pst = con.prepareStatement(sql);

                rs = pst.executeQuery();
            }

            while (rs.next()) {
                if (rs.getRow() == 0) {
                    resp = false;
                } else {
                    resp = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Nao foi encontrado");
            return false;
        } finally {
            ConnectionFactoryIsca.closeConnection(con, pst, rs);
        }

        return resp;
    }

    @Override
    public boolean delete(Isca obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

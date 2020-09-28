/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafa_
 */
public class UsuarioDAO {

    public int create(Usuario obj) {
        int ID = 0;
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into login (login,senha)values (?,?);";
        try {
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            System.out.println("Login:"+obj.getLogin()+"  Senha:"+obj.getSenha());
            ps.setString(1, obj.getLogin());
            ps.setString(2, obj.getSenha());
            ps.execute();
            
            rs =ps.getGeneratedKeys();

            if (rs.next()) {
                ID = rs.getInt(1);
            }

        } catch (SQLException e) {
            ID = 0;
            System.out.println("Erro em gravar novo login"+e.getLocalizedMessage());
        } finally {

            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return ID;
    }
  // Metodo que ira ler um usuario do banco de dados e retornalos 
    public Usuario read(String nome) {
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM LOGIN WHERE login = '"+ nome +"'";
        Usuario login = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            String rsLogin = rs.getString("login");
            String rsSenha = rs.getString("senha");
            login = new Usuario(rsLogin, rsSenha);

        } catch (SQLException e) {
            System.out.println("Nao temos registro desse login");
            return null;
        } finally {
            ConnectionFactoryIsca.closeConnection(con, pst, rs);

        }
        return login;
    }
    public boolean update(Usuario obj){
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "update  login set senha = ? where login =?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,obj.getSenha() );
            pst.setString(2,obj.getLogin() );
            
           
           pst.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            ConnectionFactoryIsca.closeConnection(con, pst, rs);
        }
        return true;
    }
}

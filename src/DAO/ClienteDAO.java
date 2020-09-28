/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import Model.Isca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rafa_
 */
public class ClienteDAO {

    public int create(Cliente obj) {
        int id = 0;
        Connection con = ConnectionFactoryIsca.getConnection();
        System.out.println("conectado");
        PreparedStatement pst = null;
        PreparedStatement pstTeste = null;
        ResultSet rs = null;
        String sql = "INSERT INTO CLIENTE(status,pessoa,cpfCnpj,inadimplente,nome,email,cep,endereco,UF,Cidade,bairro,complemento)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //  for(int i=0;i<obj.lista.size();i++){
            pst.setBoolean(1, obj.isStatus());
            pst.setString(2, obj.getPessoa());
            pst.setInt(3, obj.getCpfCnpj());
            pst.setBoolean(4, obj.isInadimplente());
            pst.setString(5, obj.getNome().toUpperCase());
            pst.setString(6, obj.getEmail());
            pst.setString(7, obj.getCep());
            pst.setString(8, obj.getEndereco());
            pst.setString(9, obj.getUF());
            pst.setString(10, obj.getCidade());
            pst.setString(11, obj.getBairro());
            pst.setString(12, obj.getComplemento());

            pst.execute();
            rs = pst.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);

            }
            System.out.println("gravou");

        } catch (SQLException e) {
            
            if(e.getMessage().equals("[SQLITE_CONSTRAINT_UNIQUE]  A UNIQUE constraint failed (UNIQUE constraint failed: CLIENTE.nome)")){
                id = -1;
            }else if (e.getMessage().equals("[SQLITE_CONSTRAINT_UNIQUE]  A UNIQUE constraint failed (UNIQUE constraint failed: CLIENTE.cpfCnpj)")){
                id = -2;
            }else{
                id = 0;
            }
            
            System.out.println("Erro ao criar a linha" + e.getMessage());
            return id;

        } finally {
            ConnectionFactoryIsca.closeConnection(con, pst, rs);
        }
        return id;
    }
    
    public ArrayList<String> nomeCliente(){
        Connection con = ConnectionFactoryIsca.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT nome FROM CLIENTE ORDER BY nome";
        ArrayList<String> lista = new ArrayList<String>();
        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
               lista.add(rs.getString("nome").toUpperCase());
            }
        } catch (SQLException ex) {
            throw new RuntimeException("erro no select");
        } finally {
            ConnectionFactoryIsca.closeConnection(con, ps, rs);
        }
        return lista;
    }
    private String capitalize(final String line) {
   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
}
  
}

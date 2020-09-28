/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.UsuarioDAO;

/**
 *
 * @author rafa_
 */
public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private int ID;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    public Usuario(){
      
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getID() {
        return ID;
    }

    public Usuario pesquisar(String nome) {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.read(nome);
    }
    
    public boolean CriarUsuario(){
        UsuarioDAO dao = new UsuarioDAO();
        this.ID =dao.create(this);
        if (ID != 0){
            return true;
        }else return false;
    }
    public boolean update(){
        UsuarioDAO dao = new UsuarioDAO();
        return dao.update(this);
    }
}

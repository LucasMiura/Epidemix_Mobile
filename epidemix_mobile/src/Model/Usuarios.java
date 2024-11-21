/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Conexao;
import java.sql.ResultSet;

/**
 *
 * @author Ericp
 */
public class Usuarios {
    private String login;
    private String senha;
    private int fkid_tipo;
    Conexao con = new Conexao();

    public Usuarios() {
        this("","",0);
    }

    public Usuarios(String login, String senha, int fkid_tipo) {
        this.login = login;
        this.senha = senha;
        this.fkid_tipo = fkid_tipo;
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

    public int getFkid_tipo() {
        return fkid_tipo;
    }

    public void setFkid_tipo(int fkid_tipo) {
        this.fkid_tipo = fkid_tipo;
    }
    
      public ResultSet logar()
    {
        ResultSet tabela;
        tabela = null;
        
         String sql = "select * from usuarios where email= '" + getLogin()+ "' and senha= '" + getSenha() + "' " ;
          tabela= con.RetornarResultset(sql);  
          return tabela;
    }   
      
}

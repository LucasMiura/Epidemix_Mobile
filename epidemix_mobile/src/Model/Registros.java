/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Conexao;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

/**
 *
 * @author Ericp
 */
public class Registros {
  //  private LocalDate data;
  //  private LocalTime hora;
    private int fkid_Usuario;
    private int fkid_Endereco;
    private int nivel;
    private String cep;
    private String logradouro;
    private String numero;
    private String Bairro;
    private String cidade;
    private String uf;
    
    
    private double Latitude;
    private double Longitude;
    private String valLat;
    private String valLon;
    
    
    Conexao con = new Conexao(); 

    public Registros() {
        this(0,0,0,"","","","","","",0.0000000,0.0000000,"","");
    }

    public Registros(int fkid_Usuario, int fkid_Endereco, int nivel, String cep, String logradouro, String numero, String Bairro, String cidade, String uf, double Latitude, double Longitude, String valLat, String valLon) {
        this.fkid_Usuario = fkid_Usuario;
        this.fkid_Endereco = fkid_Endereco;
        this.nivel = nivel;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.Bairro = Bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.valLat = valLat;
        this.valLon = valLon;
    }

    
    
    //LocalDate data, LocalTime hora

    public Registros(int fkid_Usuario, int fkid_Endereco, int nivel, String cep, String logradouro, String numero, String Bairro, String cidade, String uf, double Latitude, double Longitude) {
        this.fkid_Usuario = fkid_Usuario;
        this.fkid_Endereco = fkid_Endereco;
        this.nivel = nivel;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.Bairro = Bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
    }

    public String getValLat() {
        return valLat;
    }

    public void setValLat(String valLat) {
        this.valLat = valLat;
    }

    public String getValLon() {
        return valLon;
    }


    public void setValLon(String valLon) {
        this.valLon = valLon;
    }
    /*
    this.data = data;
    this.hora = hora;
     */
/*
    
    public LocalDate getData() {
    return data;
    }
    public void setData(LocalDate data) {
    this.data = data;
    }
    public LocalTime getHora() {
    return hora;
    }
    public void setHora(LocalTime hora) {
    this.hora = hora;
    }
     */
    public int getFkid_Usuario() {
        return fkid_Usuario;
    }

    public void setFkid_Usuario(int fkid_Usuario) {
        this.fkid_Usuario = fkid_Usuario;
    }

    public int getFkid_Endereco() {
        return fkid_Endereco;
    }

    public void setFkid_Endereco(int fkid_Endereco) {
        this.fkid_Endereco = fkid_Endereco;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
       public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }
    
    public ResultSet VerificaUltimoId(){
     ResultSet tabela;
        String sql2 = "SELECT MAX(id_endereco) from enderecos;";
    tabela =  con.RetornarResultset(sql2);
     return tabela;
    }
    
    public void ColetarFkId(){
     String sql =  "Insert into registros(data,hora,nivel,id_usuario,id_endereco)values"+
             "(curdate(),curtime(),'"+this.getNivel()+"','3','"+ this.getFkid_Endereco()+"'); ";
    con.executeSQL(sql);
    
    }
    
       public void cadastrarRegistros(){           
      String sql= "Insert into enderecos(logradouro,numero,bairro,cidade,estado,cep, latitude, longitude)values"+
                "('"+ this.getLogradouro()+"','"+ this.getNumero()+"','"+this.getBairro()+"','"+this.getCidade()+"','"+ this.getUf()+"','"+ this.getCep()+"','"+ this.getLatitude()+"','"+ this.getLongitude()+"');";
            // +
      
        con.executeSQL(sql);
      String sql2 = "SELECT id_endereco from enderecos LAST_INSERT_ID();";
      //
        JOptionPane.showMessageDialog(null, "Registrado realizado com sucesso");     
    }
    
       public ResultSet verificarFk()
    {
        ResultSet tabela;
        tabela = null;
        
         String sql = "SELECT id_endereco from enderecos ORDER BY id DESC LIMIT 1" ;
          tabela= con.RetornarResultset(sql);  
          return tabela;
    }   
  public Registros(double latitude, double longitude) {
        this.Latitude = latitude;
        this.Longitude = longitude;
    }
        public List<Localizacao> carregarLocalizacoes() {
        List<Localizacao> localizacoes = new ArrayList<>();

        // Configuração da conexão
        

      
            String consulta = "SELECT latitude, longitude FROM enderecos"; // Nome da tabela e colunas
            try (ResultSet rs = con.RetornarResultset(consulta)) {

                // Carrega cada linha do resultado como um objeto Localizacao
                while (rs.next()) {
                    double latitude = rs.getDouble("latitude");
                    double longitude = rs.getDouble("longitude");
                    localizacoes.add(new Localizacao(latitude, longitude));
                }
            }
         catch (SQLException e) {
            e.printStackTrace();
        }

            
        return localizacoes;
    }
        
public ResultSet rotas(){
   ResultSet tabela;
        tabela = null;
        
         String sql = "SELECT nivel from registros";
          tabela= con.RetornarResultset(sql);  
          return tabela;
}
      
}

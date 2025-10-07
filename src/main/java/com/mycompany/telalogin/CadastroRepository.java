
package com.mycompany.telalogin;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class CadastroRepository {
    //conexao com o banco
    private final String URL = "jdbc:mysql://localhost:3306/projetoFATEC?useSSL=false&serverTimezone=UTC"; 
    private final String USER = "root"; 
    private final String PASS = ""; 
    
    public void testarConexao(){
    try (Connection conn = DriverManager.getConnection(URL, USER,PASS)){
        System.out.println("CONEXÃO COM O BANCO DE DADOS REALIZADA COM SUCESSO!");
    }catch (SQLException e){
        System.out.println("ERRO AO CONECTAR COM O BANCO DE DADOS.");
        e.printStackTrace();
        }  
    }
       
    //
    public boolean consultaEmail(String email){
        String sql = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
        
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sql)){
            
             stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean consultaSenha(String email, String senha){
        String sql = "SELECT senha FROM usuarios WHERE email = ?";
    
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
             stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaDoBanco = rs.getString("senha");
                return senhaDoBanco.equals(senha);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean inserirCadastro(String emailCAD, String senhaCAD,String nascimentoCAD){
        
        String sql = "INSERT INTO usuarios (email, senha, nascimento) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {  
                stmt.setString(1, emailCAD);
                stmt.setString(2, senhaCAD);
                
            try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date nascimentoUtil = formatoEntrada.parse(nascimentoCAD);
            java.sql.Date nascimentoSQL = new java.sql.Date(nascimentoUtil.getTime());

            stmt.setDate(3, nascimentoSQL);
            } catch (ParseException e) {
                System.out.println("Erro ao converter data de nascimento: " + nascimentoCAD);
                e.printStackTrace();
                return false;
            }
                
             int linhasAfetadas = stmt.executeUpdate();
             return linhasAfetadas > 0;
        } catch (SQLException e) {
        e.printStackTrace();
        }
    return false;
    }   
}




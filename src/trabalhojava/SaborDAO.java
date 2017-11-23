/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandre
 */
public class SaborDAO {
    
        public List<String> listaSabores(long tipoSabor) throws SQLException {
            
        List<String> sabor = new ArrayList<String>();    
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql= "select saborNome from sabores where tipoSabor = ?";
        try{
            connection = new ConnectionFactory().getConnection();
            connection.createStatement();
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1,tipoSabor);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                sabor.add(rs.getString("saborNome"));
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }   
        return sabor;
    }
        
    public List<Sabor> listar() throws SQLException {
            
        List<Sabor> sabores = new ArrayList<Sabor>();    
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql= "select saborId, tipoSabor, nomeSabor, precoSabor from sabores";
        try{
            connection = new ConnectionFactory().getConnection();
            connection.createStatement();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Sabor sabor = new Sabor();
                sabor.setNomeSabor(rs.getString("nomeSabor"));
                sabor.setPrecoSabor(rs.getFloat("precoSabor"));
                sabor.setSaborID(rs.getLong("saborId"));
                sabor.setTipoSabor(rs.getLong("tipoSabor"));
                
                sabores.add(sabor);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }   
        return sabores;
    }
        
    public float precoSabor(String tipoSabor) throws SQLException{
        Connection connection = null;
        PreparedStatement stmt = null;
        float precoSabor;
        String sql = "select precoSabor from sabores where tipoSabor = ?";
        try{
            connection = new ConnectionFactory().getConnection();
            connection.createStatement();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1,tipoSabor);
            ResultSet rs = stmt.executeQuery();
            precoSabor = rs.getLong("precoSabor");
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }   
        return precoSabor;
    }    
    
    public void cadastrar(Sabor sabor, String tipo) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            final String sql = "INSERT INTO sabores VALUES (?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStmt.setLong(1, sabor.getSaborID());
            preparedStmt.setString(2, sabor.getNomeSabor());
            preparedStmt.setString(3, tipo);

            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        
    public void AtualizaPrecoSabor(float precoSabor,String tipo){
    
        try {
            Connection conn = new ConnectionFactory().getConnection();
            final String sql = "UPDATE sabores set precoSabor = ? where tipo = ? ";

            PreparedStatement preparedStmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStmt.setFloat(1, precoSabor);
            preparedStmt.setString(2, tipo);

            preparedStmt.executeUpdate();
            preparedStmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void remover(Long id) {
        Connection conn = new ConnectionFactory().getConnection();
        String sql = "delete from sabores"
                + " where saborId = " + id;
        PreparedStatement preparedStmt;
        try {
            preparedStmt = conn.prepareStatement(sql);
            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

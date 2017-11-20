/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jean
 */
public class TipoDAO {
    
    private final String stmUpdateSimples = "UPDATE tipo_pizza SET preco = ? where id_tipoPizza = 1";
    private final String stmUpdateEspecial = "UPDATE tipo_pizza SET preco = ? where id_tipoPizza = 2";
    private final String stmUpdatePremium = "UPDATE tipo_pizza SET preco = ? where id_tipoPizza = 3";
    
    
    public void atualizarSimples(double precoSimples){

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(stmUpdateSimples);
            
            pstmt.setDouble(1, precoSimples);
            pstmt.executeUpdate();

            con.commit();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o preço Simples. Origem=" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            }
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            }
        }
    }
    
    public void atualizarPremium(double precoPremium){

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(stmUpdatePremium);
            
            pstmt.setDouble(1, precoPremium);
            pstmt.executeUpdate();

            con.commit();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o preço Premium. Origem=" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            }
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            }
        }
    }
    
    public void atualizarEspecial(double precoEspecial){

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = new ConnectionFactory().getConnection();
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(stmUpdateEspecial);
            
            pstmt.setDouble(1, precoEspecial);
            pstmt.executeUpdate();

            con.commit();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o preço Especial. Origem=" + ex.getMessage());
        } finally {
            try {
                pstmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            }
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            }
        }
    }
}

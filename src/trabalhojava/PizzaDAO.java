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
import java.sql.Statement;

/**
 *
 * @author alexandre
 */
public class PizzaDAO {
    
  public void addPizzaAoPedido(Pizza pizza) throws IOException, SQLException {
        Long id;
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql= "insert into pizza (pedidoid, saborid1, saborid2, forma, formaDimensao) values(?, ?, ?, ?, ?)";
        try{
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, pizza.getPedidoid());
            stmt.setLong(2, pizza.getSaborid1());
            stmt.setLong(3, pizza.getSaborid2());
            stmt.setString(4, pizza.getForma());
            stmt.setDouble(5, pizza.getFormaDimensao());
            stmt.execute();

            try (ResultSet pk = stmt.getGeneratedKeys()) {
                if (pk.next()) {
                    pizza.setPizzaid(pk.getLong(1));
                }
                else {
                    throw new SQLException("A criaÃ§Ã£o do contato falhou, ID nÃ£o obtida.");
                }
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }
    }
    
    public void selectPizza(Pizza pizza) throws IOException, SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql= "select pedidoid, saborid1, saborid2, forma, formaDimensao from pizza where pizzaid = ?";
        try{
            connection = new ConnectionFactory().getConnection();
            connection.createStatement();
            stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, pizza.getPizzaid());
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            pizza.setPedidoid(rs.getLong("pedidoid")); 
            pizza.setSaborid1(rs.getLong("saborid1"));
            pizza.setSaborid2(rs.getLong("saborid2"));
            pizza.setForma(rs.getString("forma"));
            pizza.setFormaDimensao(rs.getDouble("formaDimensao"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }
    }
    
    public void alteraPizza(Pizza pizza)  throws IOException, SQLException {
        Connection connection = null;
        PreparedStatement stmt = null;
        String sql= "update pizza set pedidoid = ?, saborid1 = ?, saborid2 = ?, forma = ?, formaDimensao = ? where pizzaid = ?";
        try{
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, pizza.getPedidoid());
            stmt.setLong(2, pizza.getSaborid1());
            stmt.setLong(3, pizza.getSaborid2());
            stmt.setString(4, pizza.getForma());
            stmt.setDouble(5, pizza.getFormaDimensao());
            stmt.setLong(6, pizza.getPizzaid());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }
    }
    
    public void removePizza(Pizza pizza)  throws IOException, SQLException {
       Connection connection = null;
        PreparedStatement stmt = null;
        String sql= "delete from pizza where pizzaid = ?";
        try{
            connection = new ConnectionFactory().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setLong(1, pizza.getPizzaid());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }
    }
    
}

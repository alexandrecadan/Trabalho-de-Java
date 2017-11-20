package trabalhojava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAO {

    public List<Pedido> pesquisar(int id) {
        String sql = "select * from pedido WHERE id = ? order by id";

        List<Pedido> pedidos = new ArrayList<Pedido>();
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement pStm;
        try {
            pStm = conn.prepareStatement(sql);

            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                Pedido lista = new Pedido(rs.getInt(id));
                lista.setId(rs.getInt("id"));
                pedidos.add(lista);
            }
            //não sei se precisa fechar a conexão aqui
            pStm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public void cadastrar(Pedido pedido) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            final String sql = "INSERT INTO pedido VALUES (NULL, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, pedido.getId());
            preparedStmt.setInt(2, pedido.getIdCliente());
            preparedStmt.setInt(3, pedido.getIdPizza());
            preparedStmt.setDouble(4, pedido.getValorTotal());
            preparedStmt.setObject(5, pedido.getStatusEnum());
            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Pedido pedido) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            final String sql = "UPDATE pedido SET idCliente = ?, idPizza = ?, valorTotal = ?, status = ? where id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, pedido.getId());
            preparedStmt.setInt(2, pedido.getIdCliente());
            preparedStmt.setInt(3, pedido.getIdPizza());
            preparedStmt.setDouble(4, pedido.getValorTotal());
            preparedStmt.setObject(5, pedido.getStatusEnum());
            preparedStmt.executeUpdate();
            conn.commit();
            preparedStmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remover(int id) {
        Connection conn = new ConnectionFactory().getConnection();
        String sql = "delete from pedido"
                + " where id = " + id;
        PreparedStatement preparedStmt;
        try {
            preparedStmt = conn.prepareStatement(sql);
            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

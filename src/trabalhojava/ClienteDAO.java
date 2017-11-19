package trabalhojava;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    
   public List<Cliente> pesquisar(String nome){
        String sql = "select * from cliente WHERE lower(nome) like concat('%', ?, '%') or lower(sobrenome) like concat('%', ?, '%') order by nome";
		
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement pStm;
        try
        {
            pStm = conn.prepareStatement(sql);
            pStm.setString(1, nome.toLowerCase());
            pStm.setString(2, nome.toLowerCase());
            ResultSet rs = pStm.executeQuery();
        
            while (rs.next()) {
                Cliente cliente = criarCliente(rs);
                clientes.add(cliente);
            }
                        
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return clientes;
    }
    
    public Cliente pesquisarPorId(int id){
        String sql = "select * from cliente WHERE id=?";
		
        Cliente cliente = new Cliente(1, "","","","");
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement pStm;
        try
        {
            pStm = conn.prepareStatement(sql);
            pStm.setInt(1, id);
            ResultSet rs = pStm.executeQuery();
        
            if (rs.next()) {
                cliente = criarCliente(rs);
            }
                        
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public List<Cliente> pesquisarSob(String nome){
        String sql = "select * from cliente WHERE lower(sobrenome) like concat('%', ?, '%') or lower(sobrenome) like concat('%', ?, '%') order by nome";
		
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement pStm;
        try
        {
            pStm = conn.prepareStatement(sql);
            pStm.setString(1, nome.toLowerCase());
            pStm.setString(2, nome.toLowerCase());
            ResultSet rs = pStm.executeQuery();
        
            while (rs.next()) {
                Cliente cliente = criarCliente(rs);
                clientes.add(cliente);
            }
                        
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return clientes;
    }
    
    public List<Cliente> pesquisarCPF(String nome){
        String sql = "select * from cliente WHERE lower(cpf) like concat('%', ?, '%') or lower(sobrenome) like concat('%', ?, '%') order by nome";
		
        List<Cliente> clientes = new ArrayList<Cliente>();
        Connection conn = new ConnectionFactory().getConnection();
        PreparedStatement pStm;
        try
        {
            pStm = conn.prepareStatement(sql);
            pStm.setString(1, nome.toLowerCase());
            pStm.setString(2, nome.toLowerCase());
            ResultSet rs = pStm.executeQuery();
        
            while (rs.next()) {
                Cliente cliente = criarCliente(rs);
                clientes.add(cliente);
            }
                        
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return clientes;
    }
    
    private Cliente criarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setSobrenome(rs.getString("sobrenome"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setEndereco(rs.getString("endereco"));
        return cliente;
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();

        try {
            Connection conn = new ConnectionFactory().getConnection();
            final String sql = "SELECT * FROM cliente";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSobrenome(rs.getString("sobrenome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                clientes.add(cliente);
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }

    public void cadastrar(Cliente cliente) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            final String sql = "INSERT INTO cliente VALUES (NULL, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, cliente.getNome());
            preparedStmt.setString(2, cliente.getSobrenome());
            preparedStmt.setString(3, cliente.getTelefone());
            preparedStmt.setString(4, cliente.getEndereco());

            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(Cliente cliente) {
        try {
            Connection conn = new ConnectionFactory().getConnection();
            final String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, telefone = ?, endereco = ? where id = ?";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, cliente.getNome());
            preparedStmt.setString(2, cliente.getSobrenome());
            preparedStmt.setString(3, cliente.getTelefone());
            preparedStmt.setString(5, cliente.getEndereco());
            preparedStmt.setInt(6, cliente.getId());

            preparedStmt.execute();
            preparedStmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Acho que esse não tem
    public void remover(Cliente cliente) {
            
    }
    
    public void remover(int id) {
        Connection conn = new ConnectionFactory().getConnection();
        String sql = "delete from cliente"
                + " where id = " + id;
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
    
    public int possuiPedido(Cliente cliente){
        int resposta=0;
        try {
            Connection conn = new ConnectionFactory().getConnection();
            final String sql = "SELECT * FROM pedido where clienteId=?";

            System.out.println(cliente.getId());
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                resposta=1;
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resposta;
    }
    
}

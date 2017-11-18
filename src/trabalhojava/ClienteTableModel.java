/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jean
 */
public class ClienteTableModel extends AbstractTableModel {

      private static final int NUMERO_COLUNAS = 4;
    
    private static final int NOME = 0;
    private static final int SOBRENOME = 1;
    private static final int TELEFONE = 2;
    private static final int ENDERECO = 3;
    private String columnsNames[] = {"Nome", "Sobrenome", "Telefone", "Endereço"};
    private List<Cliente> clientes;
    private ClienteDAO clienteDao;
    
    public ClienteTableModel() {
        clientes = new ArrayList<Cliente>();
        clienteDao = new ClienteDAO();
        listarCliente();
    }
    
    public void atualizarCliente()
    {
        listarCliente();
        fireTableDataChanged();
    }
    
    
    public Cliente getCliente(int index)
    {
        return clientes.get(index);
    }   
    
      
    public void removerCliente(Cliente cliente)
    {
        clienteDao.remover(cliente.getId());
        atualizarCliente();
    }
    
    public void listarCliente()
    {
        clientes.clear();
        clientes = clienteDao.listar();
        fireTableDataChanged();
    }
    
    
    public void pesquisarCliente(String nome)
    {
        clientes = clienteDao.pesquisarNome(nome);
        fireTableDataChanged();
    }
    
    public void pesquisarClienteSob(String nome)
    {
        clientes = clienteDao.pesquisarSobrenome(nome);
        fireTableDataChanged();
    }
    
    public void pesquisarClienteTelefone(String nome)
    {
        clientes = clienteDao.pesquisarTelefone(nome);
        fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
       return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnsNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch(columnIndex)
        {
            case NOME:
              return cliente.getNome()+" "+cliente.getSobrenome();
            case SOBRENOME:
              return cliente.getSobrenome();
            case TELEFONE:
              return cliente.getTelefone();
            case ENDERECO:
              return cliente.getEndereco();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnsNames[column];
    }
    
}

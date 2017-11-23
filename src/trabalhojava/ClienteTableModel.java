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
    
    private static final int ID = 0;
    private static final int NOME = 1;
    private static final int SOBRENOME = 2;
    private static final int TELEFONE = 3;    

    private List<Cliente> valores;

    public ClienteTableModel() {
    }
    
    public ClienteTableModel(List<Cliente> valores) {
        this.valores = valores;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = valores.get(rowIndex); 

        if (columnIndex == ID) { 
            return cliente.getId();
        } else if (columnIndex == NOME) {
            return cliente.getNome();
        } else if (columnIndex == SOBRENOME) {
            return cliente.getSobrenome();
        } else if (columnIndex == TELEFONE) {
            return cliente.getTelefone();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) { //
        String coluna = "";
        switch (column) {
            case ID:
                coluna = "Código";
                break;
            case NOME:
                coluna = "Nome";
                break;
            case SOBRENOME:
                coluna = "Sorenome";
                break;
            case TELEFONE:
                coluna = "Telefone";
                break;
            default:
                throw new IllegalArgumentException("Coluna inválida");
        }
        return coluna;
    }

    @Override 
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == ID) {
            return Long.class;
        } else if (columnIndex == NOME) {
            return String.class;
        } else if (columnIndex == SOBRENOME) {
            return String.class;
        } else if (columnIndex == TELEFONE) {
            return String.class;
        }
        return null;
    }
    
    public Cliente get(int row) {
        return valores.get(row);   //poder editar os dados na mesma tela
    }
    
    @Override
    public int getRowCount() {
        return this.valores.size();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        //if(column==0)
            //return false;
        //return true;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    public void setListaCliente(List<Cliente> clientes) {
        this.valores = clientes;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }
    
    public void limpaTabela() {
        int indice = valores.size()-1;
        if(indice<0)
            indice=0;
        this.valores = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Cliente getCliente(int linha){
        return valores.get(linha);
    }
    
    public boolean removeCliente(Cliente customer) {
        int linha = this.valores.indexOf(customer);
        boolean result = this.valores.remove(customer);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }
    
    public void adicionaCliente(Cliente customer) {
        this.valores.add(customer);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(valores.size()-1,valores.size()-1);//update JTable
    }
    
    
}

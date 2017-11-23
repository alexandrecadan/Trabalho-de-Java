/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

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

    public ClienteTableModel(List<Cliente> valores) {
        this.valores = valores;
    }
    
    public int getColumnCount() {
        return 4;
    }   

    public int getRowCount() {
        return valores.size(); 
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
    
}

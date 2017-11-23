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
 * @author Claudia
 */
public class SaborTableModel extends AbstractTableModel{
   
    private static final int ID = 0;
    private static final int TIPO= 1;
    private static final int NOME = 2;
    private static final int PRECO = 3;    

    private List<Sabor> valores;
    
    public SaborTableModel() {
    }
    
    public SaborTableModel(List<Sabor> valores) {
        this.valores = valores;
    }  

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sabor sabor = valores.get(rowIndex); 

        if (columnIndex == ID) { 
            return sabor.getSaborID();
        } else if (columnIndex == TIPO) {
            return sabor.getTipoSabor();
        } else if (columnIndex == NOME) {
            return sabor.getNomeSabor();
        } else if (columnIndex == PRECO) {
            return sabor.getPrecoSabor();
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
            case TIPO:
                coluna = "Tipo";
                break;
            case PRECO:
                coluna = "Preço";
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
        } else if (columnIndex == TIPO) {
            return String.class;
        } else if (columnIndex == PRECO) {
            return String.class;
        }
        return null;
    }
    
    public Sabor get(int row) {
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
    
    public void setListaSabor(List<Sabor> sabores) {
        this.valores = sabores;
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

    public Sabor getSabor(int linha){
        return valores.get(linha);
    }
    
    public boolean removeSabor(Sabor sabor) {
        int linha = this.valores.indexOf(sabor);
        boolean result = this.valores.remove(sabor);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }
    
    public void adicionaSabor(Sabor sabor) {
        this.valores.add(sabor);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(valores.size()-1,valores.size()-1);//update JTable
    }
}

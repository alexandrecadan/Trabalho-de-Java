/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

/**
 *
 * @author Jean
 */
public enum Status {
    
    PRODUCAO(1), 
    EM_TRANSITO(2), 
    ENTREGUE(3);
    
    private int valor; 
    
    Status(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return valor;
    }
    
}

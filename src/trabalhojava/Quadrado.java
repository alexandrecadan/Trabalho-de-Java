/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

/**
 *
 * @author alexandre
 */
public class Quadrado extends Forma {
    
    private double lado;

    Quadrado(double lado) {
        super();
        this.lado = lado;
        Quadrado.super.setValorForma(valorForma);
    }   
}

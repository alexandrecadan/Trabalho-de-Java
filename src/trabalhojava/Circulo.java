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
public class  Circulo extends Forma {
   
    private double raio;
    
    public Circulo(double raio)
    {
        super();
        this.raio = raio;
        Circulo.super.setValorForma(valorForma);
    }
    
}

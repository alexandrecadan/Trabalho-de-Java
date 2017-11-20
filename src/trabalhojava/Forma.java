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
public abstract class Forma {
      
    private double medida;
    double valorForma;
    private Double valorTotalForma;


    public void CalculaPrecoForma(double medida, double valorForma)
    {
        this.valorTotalForma = valorForma * medida;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public double getValorForma() {
        return valorForma;
    }

    public void setValorForma(double valorForma) {
        this.valorForma = valorForma;
    }

    public Double getValorTotalForma() {
        return valorTotalForma;
    }

    public void setValorTotalForma(Double valorTotalForma) {
        this.valorTotalForma = valorTotalForma;
    }
    
}

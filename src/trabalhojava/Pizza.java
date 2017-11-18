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
public class Pizza {
   
    private Long pizzaid, pedidoid, saborid1, saborid2;
    private String forma = "";
    private Double formaDimensao;

    public Long getPizzaid() {
        return pizzaid;
    }

    public void setPizzaid(Long pizzaid) {
        this.pizzaid = pizzaid;
    }

    public Long getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(Long pedidoid) {
        this.pedidoid = pedidoid;
    }

    public Long getSaborid1() {
        return saborid1;
    }

    public void setSaborid1(Long saborid1) {
        this.saborid1 = saborid1;
    }

    public Long getSaborid2() {
        return saborid2;
    }

    public void setSaborid2(Long saborid2) {
        this.saborid2 = saborid2;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Double getFormaDimensao() {
        return formaDimensao;
    }

    public void setFormaDimensao(Double formaDimensao) {
        this.formaDimensao = formaDimensao;
    }
    
}

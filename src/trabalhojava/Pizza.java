/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import java.sql.SQLException;

/**
 *
 * @author alexandre
 */
public class Pizza {
   
    private Long pizzaid, pedidoid, saborid1, saborid2;
    private String forma;
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
    
    
    public static float CalculaPizza (int idForma, float dimensao, String tipoSabor1, String tipoSabor2,int sabor1, int sabor2) throws SQLException{
        
        float valorCalculo = 0;
        SaborDAO saborDAO = new SaborDAO();
        if (tipoSabor2.equals("")){
            valorCalculo =  saborDAO.precoSabor(tipoSabor1);
        }
        else{
            valorCalculo = saborDAO.precoSabor(tipoSabor1) / saborDAO.precoSabor(tipoSabor2);
        }
        valorCalculo = CalculaArea(idForma,dimensao) * valorCalculo;
        return valorCalculo;
    }
    
    public static float CalculaArea(int idForma,float dimensao){
        double valorPizzad = 0;
        float pi = 3.14f;
        
        if(idForma == 1){                //Circulo
            valorPizzad = (pi * (dimensao*dimensao)); 
        }
        else if(idForma == 2){          //Quadrado
            valorPizzad = (dimensao * dimensao);
        }
        else{                          //Triangulo
            valorPizzad = (((Math.sqrt(3))/4) * (dimensao * dimensao));
        }
        float f = (float)valorPizzad;  
         
        return f; 
    }
}

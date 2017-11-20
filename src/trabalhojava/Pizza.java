package trabalhojava;

import java.sql.SQLException;
import java.util.Objects;

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
    
    
    public static float CalculaPizza (int codForma, float dimensao, String tipoSabor1, String tipoSabor2,int sabor1, int sabor2) throws SQLException{
        
        float valorCalculo = 0;
        SaborDAO saborDAO = new SaborDAO();
        if (tipoSabor2.equals("")){
            valorCalculo =  saborDAO.precoSabor(tipoSabor1);
        }
        else{
            valorCalculo = saborDAO.precoSabor(tipoSabor1) / saborDAO.precoSabor(tipoSabor2);
        }
        valorCalculo = CalculaArea(codForma,dimensao) * valorCalculo;
        return valorCalculo;
    }
    
    public static float CalculaArea(int codForma,float dimensao){
        double valorPizzad = 0;
        float pi = 3.14f;
        
        if(codForma == 1){                //Circulo
            valorPizzad = (pi * (dimensao*dimensao)); 
        }
        else if(codForma == 2){          //Quadrado
            valorPizzad = (dimensao * dimensao);
        }
        else{                          //TriSangulo
            valorPizzad = (((Math.sqrt(3))/4) * (dimensao * dimensao));
        }
        float f = (float)valorPizzad;  
         
        return f; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.pizzaid);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pizza other = (Pizza) obj;
        if (!Objects.equals(this.pizzaid, other.pizzaid)) {
            return false;
        }
        return true;
    }
    
    
}

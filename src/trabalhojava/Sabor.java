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
public class Sabor {
    
    
    
    private Long saborID, tipoSabor;
    private String nomeSabor;
    private Float precoSabor;

    public Sabor(Long saborID, Long tipoSabor, String nomeSabor, Float precoSabor) {
        this.saborID = saborID;
        this.tipoSabor = tipoSabor;
        this.nomeSabor = nomeSabor;
        this.precoSabor = precoSabor;
    }
    


    public Long getSaborID() {
        return saborID;
    }

    public void setSaborID(Long saborID) {
        this.saborID = saborID;
    }

    public Long getTipoSabor() {
        return tipoSabor;
    }

    public void setTipoSabor(Long tipoSabor) {
        this.tipoSabor = tipoSabor;
    }

    public String getNomeSabor() {
        return nomeSabor;
    }

    public void setNomeSabor(String nomeSabor) {
        this.nomeSabor = nomeSabor;
    }

    public Float getPrecoSabor() {
        return precoSabor;
    }

    public void setPrecoSabor(Float precoSabor) {
        this.precoSabor = precoSabor;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author madarme
 */
public class Ficha {
    
    // alfil o peón
    private String nombreFicha;

    public Ficha() {
    }

    public Ficha(String nombreFicha) {
        this.nombreFicha = nombreFicha;
    }

    public String getNombreFicha() {
        return nombreFicha;
    }

    public void setNombreFicha(String nombreFicha) {
        this.nombreFicha = nombreFicha;
    }
    
    
}

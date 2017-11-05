/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Pojos;

/**
 *
 * @author Villa
 */
public class Integrante {
    private String usurio;
    private String equipo;

    public Integrante() {
    }

    public Integrante(String usurio, String equipo) {
        this.usurio = usurio;
        this.equipo = equipo;
    }

    /**
     * @return the usurio
     */
    public String getUsurio() {
        return usurio;
    }

    /**
     * @param usurio the usurio to set
     */
    public void setUsurio(String usurio) {
        this.usurio = usurio;
    }

    /**
     * @return the equipo
     */
    public String getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    
    
}

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
public class Inscripcion {
    private String fecha;
    private String equipo;
    private String torneo;

    public Inscripcion() {
    }

    public Inscripcion(String fecha, String equipo, String torneo) {
        this.fecha = fecha;
        this.equipo = equipo;
        this.torneo = torneo;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    /**
     * @return the torneo
     */
    public String getTorneo() {
        return torneo;
    }

    /**
     * @param torneo the torneo to set
     */
    public void setTorneo(String torneo) {
        this.torneo = torneo;
    }
    
}

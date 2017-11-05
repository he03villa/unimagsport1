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
public class ResultadosEnfrentamiento {
    private String id;
    private String fecha_inicio;
    private String equipo;
    private String torneo;
    private String equipo1;
    private String equipo2;
    private String resultado1;
    private String resultado2;
    private String descripcion;

    public ResultadosEnfrentamiento() {
    }

    public ResultadosEnfrentamiento(String fecha_inicio, String equipo, String torneo, String equipo1, String equipo2, String resultado1, String resultado2, String descripcion) {
        this.fecha_inicio = fecha_inicio;
        this.equipo = equipo;
        this.torneo = torneo;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
        this.descripcion = descripcion;
    }

    public ResultadosEnfrentamiento(String id, String fecha_inicio, String equipo, String torneo, String equipo1, String equipo2, String resultado1, String resultado2, String descripcion) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.equipo = equipo;
        this.torneo = torneo;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado1 = resultado1;
        this.resultado2 = resultado2;
        this.descripcion = descripcion;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fecha_inicio
     */
    public String getFecha_inicio() {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
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

    /**
     * @return the equipo1
     */
    public String getEquipo1() {
        return equipo1;
    }

    /**
     * @param equipo1 the equipo1 to set
     */
    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    /**
     * @return the equipo2
     */
    public String getEquipo2() {
        return equipo2;
    }

    /**
     * @param equipo2 the equipo2 to set
     */
    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    /**
     * @return the resultado1
     */
    public String getResultado1() {
        return resultado1;
    }

    /**
     * @param resultado1 the resultado1 to set
     */
    public void setResultado1(String resultado1) {
        this.resultado1 = resultado1;
    }

    /**
     * @return the resultado2
     */
    public String getResultado2() {
        return resultado2;
    }

    /**
     * @param resultado2 the resultado2 to set
     */
    public void setResultado2(String resultado2) {
        this.resultado2 = resultado2;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

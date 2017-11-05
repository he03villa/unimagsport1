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
public class Torneo {
    private String id;
    private String nombre;
    private String foto;
    private String reglas;
    private String premio;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_final;
    private String numero_equipo;
    private String deporte;

    public Torneo() {
    }

    public Torneo(String nombre, String foto, String reglas, String premio, String descripcion, String fecha_inicio, String fecha_final, String numero_equipo, String deporte) {
        this.nombre = nombre;
        this.foto = foto;
        this.reglas = reglas;
        this.premio = premio;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.numero_equipo = numero_equipo;
        this.deporte = deporte;
    }

    public Torneo(String id, String nombre, String foto, String reglas, String premio, String descripcion, String fecha_inicio, String fecha_final, String numero_equipo, String deporte) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.reglas = reglas;
        this.premio = premio;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.numero_equipo = numero_equipo;
        this.deporte = deporte;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the reglas
     */
    public String getReglas() {
        return reglas;
    }

    /**
     * @param reglas the reglas to set
     */
    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

    /**
     * @return the premio
     */
    public String getPremio() {
        return premio;
    }

    /**
     * @param premio the premio to set
     */
    public void setPremio(String premio) {
        this.premio = premio;
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
     * @return the fecha_final
     */
    public String getFecha_final() {
        return fecha_final;
    }

    /**
     * @param fecha_final the fecha_final to set
     */
    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    /**
     * @return the numero_equipo
     */
    public String getNumero_equipo() {
        return numero_equipo;
    }

    /**
     * @param numero_equipo the numero_equipo to set
     */
    public void setNumero_equipo(String numero_equipo) {
        this.numero_equipo = numero_equipo;
    }

    /**
     * @return the deporte
     */
    public String getDeporte() {
        return deporte;
    }

    /**
     * @param deporte the deporte to set
     */
    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    
}

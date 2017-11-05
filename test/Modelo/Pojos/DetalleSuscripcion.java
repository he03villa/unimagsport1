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
public class DetalleSuscripcion {
    private String id;
    private String fecha_inicio;
    private String fecha_final;
    private String cantidad;
    private String usuario;
    private String tiposuscripcion;

    public DetalleSuscripcion() {
    }

    public DetalleSuscripcion(String fecha_inicio, String fecha_final, String cantidad, String usuario, String tiposuscripcion) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.tiposuscripcion = tiposuscripcion;
    }

    public DetalleSuscripcion(String id, String fecha_inicio, String fecha_final, String cantidad, String usuario, String tiposuscripcion) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.tiposuscripcion = tiposuscripcion;
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
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the tiposuscripcion
     */
    public String getTiposuscripcion() {
        return tiposuscripcion;
    }

    /**
     * @param tiposuscripcion the tiposuscripcion to set
     */
    public void setTiposuscripcion(String tiposuscripcion) {
        this.tiposuscripcion = tiposuscripcion;
    }
    
    
}

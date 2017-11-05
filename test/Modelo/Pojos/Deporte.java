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
public class Deporte {
    private String id;
    private String nombre;
    private String descripcion;
    private String foto;
    private String tipo_deporte;

    public Deporte() {
    }

    public Deporte(String nombre, String descripcion, String foto, String tipo_deporte) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.tipo_deporte = tipo_deporte;
    }

    public Deporte(String id, String nombre, String descripcion, String foto, String tipo_deporte) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.tipo_deporte = tipo_deporte;
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
     * @return the tipo_deporte
     */
    public String getTipo_deporte() {
        return tipo_deporte;
    }

    /**
     * @param tipo_deporte the tipo_deporte to set
     */
    public void setTipo_deporte(String tipo_deporte) {
        this.tipo_deporte = tipo_deporte;
    }
    
}

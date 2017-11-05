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
public class Departamento {
    private String id;
    private String nombre;
    private String descripcion;
    private String pais;

    public Departamento() {
    }

    public Departamento(String nombre, String descripcion, String pais) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pais = pais;
    }
    
    public Departamento(String id, String nombre, String descripcion, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pais = pais;
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
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    
}

package Modelo.Pojos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Villa
 */
public class Ciudad {
    private String id;
    private String nombre;
    private String descripcion;
    private String departamento;

    public Ciudad() {
    }

    public Ciudad(String nombre, String descripcion, String departamento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.departamento = departamento;
    }

    public Ciudad(String id, String nombre, String descripcion, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.departamento = departamento;
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
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    
}

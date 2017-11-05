/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Departamento;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class DepartamentoDao {
    public static ArrayList<Departamento> Lista(){
        ArrayList<Departamento> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,descripcion,pais_id from departamento");
            while (con.getResultQuery().next()) {                
                Departamento de = new Departamento(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3),con.getResultQuery().getString(4));
                lis.add(de);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Departamento getDepartamento(String codigo){
        try {
            ArrayList<Departamento> lis = DepartamentoDao.Lista();
            for(Departamento de: lis) if(de.getId().equals(codigo)) return de;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Departamento de){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into departamento(nombre,descripcion,pais_id) values('%s','%s',%d)", de.getNombre(),de.getDescripcion(),Integer.parseInt(de.getPais())));
            if(con.getResultUpdate()>0) return "El pais se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Departamento de){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update departamento set nombre='%s', descripcion='%s', pais_id=%d where id=%d", de.getNombre(),de.getDescripcion(),Integer.parseInt(de.getId()),Integer.parseInt(de.getPais())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Departamento de){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from departamento where id=%d", Integer.parseInt(de.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El pais se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }

}

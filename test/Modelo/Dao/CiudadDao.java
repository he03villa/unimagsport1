/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Ciudad;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class CiudadDao {
    public static ArrayList<Ciudad> Lista(){
        ArrayList<Ciudad> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,descripcion,departamento_id from ciudad");
            while (con.getResultQuery().next()) {                
                Ciudad ci = new Ciudad(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3),con.getResultQuery().getString(4));
                lis.add(ci);
            }
        con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Ciudad getDepartamento(String codigo){
        try {
            ArrayList<Ciudad> lis = CiudadDao.Lista();
            for(Ciudad ci: lis) if(ci.getId().equals(codigo)) return ci;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Ciudad ci){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into ciudad(nombre,descripcion,departamento_id) values('%s','%s',%d)", ci.getNombre(),ci.getDescripcion(),Integer.parseInt(ci.getDepartamento())));
            if(con.getResultUpdate()>0) return "La ciuada se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Ciudad ci){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update ciudad set nombre='%s', descripcion='%s', departamento_id=%d where id=%d", ci.getNombre(),ci.getDescripcion(),Integer.parseInt(ci.getId()),Integer.parseInt(ci.getDepartamento())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Ciudad ci){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from ciudad where id=%d", Integer.parseInt(ci.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "La ciudad se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

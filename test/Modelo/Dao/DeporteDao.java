/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Deporte;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class DeporteDao {
    public static ArrayList<Deporte> Lista(){
        ArrayList<Deporte> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,descripcion,foto,tipo_deporte_id from deporte");
            while (con.getResultQuery().next()) {                
                Deporte po = new Deporte(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3),con.getResultQuery().getString(4),con.getResultQuery().getString(5));
                lis.add(po);
            }
        con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Deporte getDeporte(String codigo){
        try {
            ArrayList<Deporte> lis = DeporteDao.Lista();
            for(Deporte de: lis) if(de.getId().equals(codigo)) return de;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Deporte de){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into deporte(nombre,descripcion,foto,tipo_deporte_id) values('%s','%s','%s',%d)", de.getNombre(),de.getDescripcion(),de.getFoto(),Integer.parseInt(de.getTipo_deporte())));
            if(con.getResultUpdate()>0) return "La ciuada se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Deporte de){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update deporte set nombre='%s', descripcion='%s', foto='%s', tipo_deporte_id=%d where id=%d", de.getNombre(),de.getDescripcion(),de.getFoto(),Integer.parseInt(de.getTipo_deporte()),Integer.parseInt(de.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Deporte de){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from deporte where id=%d", Integer.parseInt(de.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "La ciudad se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.TipoSusucripcion;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class TipoSusucripcionDao {
    public static ArrayList<TipoSusucripcion> Lista(){
        ArrayList<TipoSusucripcion> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,descripcion from tipo_suscripcion");
            while (con.getResultQuery().next()) {                
                TipoSusucripcion ti = new TipoSusucripcion(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3));
                lis.add(ti);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static TipoSusucripcion getTipoSusucripcion(String codigo){
        try {
            ArrayList<TipoSusucripcion> lis = TipoSusucripcionDao.Lista();
            for(TipoSusucripcion ti: lis) if(ti.getId().equals(codigo)) return ti;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(TipoSusucripcion ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into tipo_suscripcion(nombre,descripcion) values('%s','%s')", ti.getNombre(),ti.getDescripcion()));
            if(con.getResultUpdate()>0) return "El tipo de suscripcion se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(TipoSusucripcion ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update tipo_suscripcion set nombre='%s', descripcion='%s' where id=%d", ti.getNombre(),ti.getDescripcion(),Integer.parseInt(ti.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(TipoSusucripcion ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from tipo_suscripcion where id=%d", Integer.parseInt(ti.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El tipo de suscripcion se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

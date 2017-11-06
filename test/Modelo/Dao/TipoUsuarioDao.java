/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.TipoUsuario;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class TipoUsuarioDao {
    public static ArrayList<TipoUsuario> Lista(){
        ArrayList<TipoUsuario> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,descripcion from tipo_usuario");
            while (con.getResultQuery().next()) {                
                TipoUsuario ti = new TipoUsuario(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3));
                lis.add(ti);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static TipoUsuario getTipoUsuario(String codigo){
        try {
            ArrayList<TipoUsuario> lis = TipoUsuarioDao.Lista();
            for(TipoUsuario ti: lis) if(ti.getId().equals(codigo)) return ti;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(TipoUsuario ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into tipo_usuario(nombre,descripcion) values('%s','%s')", ti.getNombre(),ti.getDescripcion()));
            if(con.getResultUpdate()>0) return "El tipo de usuario se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(TipoUsuario ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update tipo_usuario set nombre='%s', descripcion='%s' where id=%d", ti.getNombre(),ti.getDescripcion(),Integer.parseInt(ti.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(TipoUsuario ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from tipo_usuario where id=%d", Integer.parseInt(ti.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El tipo de usuario se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

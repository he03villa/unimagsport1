/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Equipo;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Villa
 */
public class EquipoDao {
    public static ArrayList<Equipo> Lista(){
        ArrayList<Equipo> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,fecha_creacion,foto,descripcion,usuario_id from equipo");
            while (con.getResultQuery().next()) {                
                Equipo eq = new Equipo(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3),con.getResultQuery().getString(4),con.getResultQuery().getString(5),con.getResultQuery().getString(6));
                lis.add(eq);
            }
        con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Equipo getEquipo(String codigo){
        try {
            ArrayList<Equipo> lis = EquipoDao.Lista();
            for(Equipo eq: lis) if(eq.getId().equals(codigo)) return eq;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Equipo eq){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(eq.getFecha_creacion());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into equipo(nombre,fecha_creacion,foto,descripcion,usuario_id) values('%s','%s','%s','%s',%d)", eq.getNombre(),fecha1,eq.getFoto(),eq.getDescripcion(),Integer.parseInt(eq.getUsuario())));
            if(con.getResultUpdate()>0) return "El equipo se registro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Equipo eq){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(eq.getFecha_creacion());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update equipo set nombre='%s', fecha_creacion='%s', foto='%s', usuario_id=%d, descripcion='%s' where id=%d", eq.getNombre(),fecha1, eq.getFoto(),Integer.parseInt(eq.getUsuario()), eq.getDescripcion(),Integer.parseInt(eq.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Equipo eq){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from equipo where id=%d", Integer.parseInt(eq.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El equipo se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

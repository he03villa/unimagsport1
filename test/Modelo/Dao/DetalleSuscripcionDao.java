/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.DetalleSuscripcion;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Villa
 */
public class DetalleSuscripcionDao {
    public static ArrayList<DetalleSuscripcion> Lista(){
        ArrayList<DetalleSuscripcion> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,fecha_inicio,fecha_final,cantidad,usuario_id,tipo_suscripcion_id from detalle_suscripcion");
            while (con.getResultQuery().next()) {                
                DetalleSuscripcion de = new DetalleSuscripcion(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3),con.getResultQuery().getString(4),con.getResultQuery().getString(5),con.getResultQuery().getString(6));
                lis.add(de);
            }
        con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static DetalleSuscripcion getDetalleSuscripcion(String codigo){
        try {
            ArrayList<DetalleSuscripcion> lis = DetalleSuscripcionDao.Lista();
            for(DetalleSuscripcion de: lis) if(de.getId().equals(codigo)) return de;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(DetalleSuscripcion de){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fomr2 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(de.getFecha_inicio());
            Date fe2 = (Date)fomr2.parse(de.getFecha_final());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            java.sql.Date fecha2 = new java.sql.Date(fe2.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into detalle_suscripcion(fecha_inicio,fecha_final,cantidad,usuario_id,tipo_suscripcion_id) values('%s','%s',%d,%d,%d)", fecha1,fecha2,Integer.parseInt(de.getCantidad()),Integer.parseInt(de.getUsuario()),Integer.parseInt(de.getTiposuscripcion())));
            if(con.getResultUpdate()>0) return "El detalle se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(DetalleSuscripcion de){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fomr2 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(de.getFecha_inicio());
            Date fe2 = (Date)fomr2.parse(de.getFecha_final());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            java.sql.Date fecha2 = new java.sql.Date(fe2.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update detalle_suscripcion set fecha_inicio='%s', fecha_final='%s', cantidad=%d, usuario_id=%d, tipo_suscripcion_id=%d where id=%d", fecha1,fecha2, Integer.parseInt(de.getCantidad()),Integer.parseInt(de.getUsuario()), Integer.parseInt(de.getTiposuscripcion()),Integer.parseInt(de.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(DetalleSuscripcion de){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from detalle_suscripcion where id=%d", Integer.parseInt(de.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El detalle se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Inscripcion;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Villa
 */
public class InscripcionDao {
    public static ArrayList<Inscripcion> Lista(){
        ArrayList<Inscripcion> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select equipo_id,torneo_id,fecha from inscripcion");
            while (con.getResultQuery().next()) {                
                Inscripcion in = new Inscripcion(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3));
                lis.add(in);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Inscripcion getInscripcion(String equipo,String torneo){
        try {
            ArrayList<Inscripcion> lis = InscripcionDao.Lista();
            for(Inscripcion in: lis) if(in.getEquipo().equals(equipo) || in.getTorneo().equals(torneo)) return in;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Inscripcion in){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(in.getFecha());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into inscripcion(equipo_id,torneo_id,fecha) values(%d,%d,'%s')", Integer.parseInt(in.getEquipo()),Integer.parseInt(in.getTorneo()),fecha1));
            if(con.getResultUpdate()>0) return "La inscripcion se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Inscripcion in){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(in.getFecha());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update inscripcion set equipo_id=%d, torneo_id=%d,fecha='%s' where equipo_id=%d or torneo_id=%d", Integer.parseInt(in.getEquipo()),Integer.parseInt(in.getTorneo()),fecha1,Integer.parseInt(in.getEquipo()),Integer.parseInt(in.getTorneo())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Inscripcion in){
        try {
            ConnectionMySQL con = Conexion.conexion();
            //con.ExecuteQuery(String.format("delete from inscripcion where id=%d", Integer.parseInt(pa.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "La inscripcion se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

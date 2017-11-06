/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Torneo;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Villa
 */
public class TorneoDao {
    public static ArrayList<Torneo> Lista(){
        ArrayList<Torneo> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,foto,reglas,premio,descripcion,fecha_inicio,fecha_final,numero_equipo,deporte_id from torneo");
            while (con.getResultQuery().next()) {                
                Torneo to = new Torneo(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3),con.getResultQuery().getString(4),con.getResultQuery().getString(5),con.getResultQuery().getString(6),con.getResultQuery().getString(7),con.getResultQuery().getString(8),con.getResultQuery().getString(9),con.getResultQuery().getString(10));
                lis.add(to);
            }
        con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Torneo getTorneo(String codigo){
        try {
            ArrayList<Torneo> lis = TorneoDao.Lista();
            for(Torneo to: lis) if(to.getId().equals(codigo)) return to;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Torneo to){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fomr2 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(to.getFecha_inicio());
            Date fe2 = (Date)fomr2.parse(to.getFecha_final());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            java.sql.Date fecha2 = new java.sql.Date(fe2.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into torneo(nombre,foto,reglas,premio,descripcion,fecha_inicio,fecha_final,numero_equipo,deporte_id) values('%s','%s','%s','%s','%s','%s','%s',%d,%d)", to.getNombre(),to.getFoto(),to.getReglas(),to.getPremio(),to.getDescripcion(),fecha1,fecha2,Integer.parseInt(to.getNumero_equipo()),Integer.parseInt(to.getDeporte())));
            if(con.getResultUpdate()>0) return "El torneo se registro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Torneo to){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fomr2 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(to.getFecha_inicio());
            Date fe2 = (Date)fomr2.parse(to.getFecha_final());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            java.sql.Date fecha2 = new java.sql.Date(fe2.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update torneo set nombre='%s', foto='%s', reglas='%s', premio='%s', descripcion='%s', fecha_inicio='%s', fecha_final='%s', numero_equipo=%d, deporte_id=%d where id=%d", to.getNombre(),to.getFoto(),to.getReglas(),to.getPremio(),to.getDescripcion(),fecha1,fecha2,Integer.parseInt(to.getNumero_equipo()),Integer.parseInt(to.getDeporte()),Integer.parseInt(to.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Torneo to){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from torneo where id=%d", Integer.parseInt(to.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El torneo se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

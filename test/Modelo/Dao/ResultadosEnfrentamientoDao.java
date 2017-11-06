/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.ResultadosEnfrentamiento;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Villa
 */
public class ResultadosEnfrentamientoDao {
    public static ArrayList<ResultadosEnfrentamiento> Lista(){
        ArrayList<ResultadosEnfrentamiento> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,fecha_inicio,inscripcion_equipo_id,inscripcion_torneo_id,equipo_id1,equipo_id2,resultado1,resultado2,descripcion from resultado_enfrentamiento");
            while (con.getResultQuery().next()) {                
                ResultadosEnfrentamiento re = new ResultadosEnfrentamiento(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3),con.getResultQuery().getString(4),con.getResultQuery().getString(5),con.getResultQuery().getString(6),con.getResultQuery().getString(7),con.getResultQuery().getString(8));
                lis.add(re);
            }
        con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static ResultadosEnfrentamiento getResultadosEnfrentamiento(String codigo){
        try {
            ArrayList<ResultadosEnfrentamiento> lis = ResultadosEnfrentamientoDao.Lista();
            for(ResultadosEnfrentamiento re: lis) if(re.getId().equals(codigo)) return re;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(ResultadosEnfrentamiento re){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(re.getFecha_inicio());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into resultado_enfrentamiento(fecha_inicio,inscripcion_equipo_id,inscripcion_torneo_id,equipo_id1,equipo_id2,resultado1,resultado2,descripcion) values('%s',%d,%d,%d,%d,%d,%d,'%s')", fecha1,Integer.parseInt(re.getEquipo()),Integer.parseInt(re.getTorneo()),Integer.parseInt(re.getEquipo1()),Integer.parseInt(re.getEquipo2()),Integer.parseInt(re.getResultado1()),Integer.parseInt(re.getResultado2()),re.getDescripcion()));
            if(con.getResultUpdate()>0) return "El resultado del enfrentamiento se registro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(ResultadosEnfrentamiento re){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(re.getFecha_inicio());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update resultado_enfrentamiento set fecha_inicio='%s', inscripcion_equipo_id=%d, inscripcion_torneo_id=%d, equipo_id1=%d, equipo_id2=%d, resultado1=%d, resultado2=%d, descripcion='%s' where id=%d", fecha1,Integer.parseInt(re.getEquipo()),Integer.parseInt(re.getTorneo()),Integer.parseInt(re.getEquipo1()),Integer.parseInt(re.getEquipo2()),Integer.parseInt(re.getResultado1()),Integer.parseInt(re.getResultado2()),re.getDescripcion(),Integer.parseInt(re.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(ResultadosEnfrentamiento re){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from resultado_enfrentamiento where id=%d", Integer.parseInt(re.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El resultado del enfrentamiento se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

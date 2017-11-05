/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Integrante;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class IntegranteDao {
    public static ArrayList<Integrante> Lista(){
        ArrayList<Integrante> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select usuario_id,equipo_id from integrantes");
            while (con.getResultQuery().next()) {                
                Integrante in = new Integrante(con.getResultQuery().getString(1), con.getResultQuery().getString(2));
                lis.add(in);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Integrante getInscripcion(String equipo,String usuario){
        try {
            ArrayList<Integrante> lis = IntegranteDao.Lista();
            for(Integrante in: lis) if(in.getEquipo().equals(equipo) || in.getUsurio().equals(usuario)) return in;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Integrante in){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into integrantes(equipo_id,usuario_id) values(%d,%d)", Integer.parseInt(in.getEquipo()),Integer.parseInt(in.getUsurio())));
            if(con.getResultUpdate()>0) return "El integrante se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Integrante in){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update integrantes set equipo_id=%d, usuario_id=%d where equipo_id=%d or usuario_id=%d", Integer.parseInt(in.getEquipo()),Integer.parseInt(in.getUsurio()),Integer.parseInt(in.getEquipo()),Integer.parseInt(in.getUsurio())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Integrante in){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from inscripcion where equipo_id=%d and usuario_id=%d", Integer.parseInt(in.getEquipo()),Integer.parseInt(in.getUsurio())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "La inscripcion se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

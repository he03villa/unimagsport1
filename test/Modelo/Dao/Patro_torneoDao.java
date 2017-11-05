/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Patro_torneo;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class Patro_torneoDao {
    public static ArrayList<Patro_torneo> Lista(){
        ArrayList<Patro_torneo> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select torneo_id,patrosinador_id from patro_torneo");
            while (con.getResultQuery().next()) {                
                Patro_torneo in = new Patro_torneo(con.getResultQuery().getString(1), con.getResultQuery().getString(2));
                lis.add(in);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Patro_torneo getPatro_torneo(String torneo,String patrocinador){
        try {
            ArrayList<Patro_torneo> lis = Patro_torneoDao.Lista();
            for(Patro_torneo pa: lis) if(pa.getPatrocinador().equals(patrocinador) || pa.getTorneo().equals(torneo)) return pa;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Patro_torneo pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into patro_torneo(torneo_id,patrosinador_id) values(%d,%d)", Integer.parseInt(pa.getTorneo()),Integer.parseInt(pa.getPatrocinador())));
            if(con.getResultUpdate()>0) return "El integrante se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Patro_torneo pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update patro_torneo set torneo_id=%d, patrosinador_id=%d where torneo_id=%d or patrosinador_id=%d", Integer.parseInt(pa.getTorneo()),Integer.parseInt(pa.getPatrocinador()),Integer.parseInt(pa.getTorneo()),Integer.parseInt(pa.getPatrocinador())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Patro_torneo pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from patro_torneo where torneo_id=%d and patrosinador_id=%d", Integer.parseInt(pa.getTorneo()),Integer.parseInt(pa.getPatrocinador())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "La inscripcion se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Patrocinador;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class PatrocinadorDao {
    public static ArrayList<Patrocinador> Lista(){
        ArrayList<Patrocinador> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,descripcion from patrosinadores");
            while (con.getResultQuery().next()) {                
                Patrocinador pa = new Patrocinador(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3));
                lis.add(pa);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Patrocinador getPatrocinador(String codigo){
        try {
            ArrayList<Patrocinador> lis = PatrocinadorDao.Lista();
            for(Patrocinador pa: lis) if(pa.getId().equals(codigo)) return pa;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Patrocinador pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into patrosinadores(nombre,descripcion) values('%s','%s')", pa.getNombre(),pa.getDescripcion()));
            if(con.getResultUpdate()>0) return "El patrosinadores se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Patrocinador pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update patrosinadores set nombre='%s', descripcion='%s' where id=%d", pa.getNombre(),pa.getDescripcion(),Integer.parseInt(pa.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Patrocinador pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from patrosinadores where id=%d", Integer.parseInt(pa.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El patrosinadores se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

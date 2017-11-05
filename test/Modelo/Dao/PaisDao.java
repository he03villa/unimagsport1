/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Pais;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class PaisDao {
    public static ArrayList<Pais> Lista(){
        ArrayList<Pais> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,descripcion from pais");
            while (con.getResultQuery().next()) {                
                Pais pa = new Pais(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3));
                lis.add(pa);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Pais getPais(String codigo){
        try {
            ArrayList<Pais> lis = PaisDao.Lista();
            for(Pais pa: lis) if(pa.getId().equals(codigo)) return pa;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Pais pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into pais(nombre,descripcion) values('%s','%s')", pa.getNombre(),pa.getDescripcion()));
            if(con.getResultUpdate()>0) return "El pais se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Pais pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update pais set nombre='%s', descripcion='%s' where id=%d", pa.getNombre(),pa.getDescripcion(),Integer.parseInt(pa.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Pais pa){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from pais where id=%d", Integer.parseInt(pa.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El pais se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

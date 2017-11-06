/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.TipoDocumento;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.util.ArrayList;

/**
 *
 * @author Villa
 */
public class TipoDocumentoDao {
    public static ArrayList<TipoDocumento> Lista(){
        ArrayList<TipoDocumento> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,descripcion from tipo_documento");
            while (con.getResultQuery().next()) {                
                TipoDocumento ti = new TipoDocumento(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3));
                lis.add(ti);
            }
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static TipoDocumento getTipoDocumento(String codigo){
        try {
            ArrayList<TipoDocumento> lis = TipoDocumentoDao.Lista();
            for(TipoDocumento ti: lis) if(ti.getId().equals(codigo)) return ti;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(TipoDocumento ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into tipo_documento(nombre,descripcion) values('%s','%s')", ti.getNombre(),ti.getDescripcion()));
            if(con.getResultUpdate()>0) return "El tipo de documento se regitro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(TipoDocumento ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update tipo_documento set nombre='%s', descripcion='%s' where id=%d", ti.getNombre(),ti.getDescripcion(),Integer.parseInt(ti.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(TipoDocumento ti){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from tipo_documento where id=%d", Integer.parseInt(ti.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El tipo de documento se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import Modelo.Pojos.Usuario;
import SIGTools.ConnectionBD.ConnectionMySQL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Villa
 */
public class UsuarioDao {
    public static ArrayList<Usuario> Lista(){
        ArrayList<Usuario> lis = new ArrayList<>();
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery("select id,nombre,apellido,fecha_nacimiento,telefono,identificacion,correo,password,foto,ciudad_id,tipo_usuario_id,tipo_documento_id from usuario");
            while (con.getResultQuery().next()) {                
                Usuario us = new Usuario(con.getResultQuery().getString(1), con.getResultQuery().getString(2), con.getResultQuery().getString(3),con.getResultQuery().getString(4),con.getResultQuery().getString(5),con.getResultQuery().getString(6),con.getResultQuery().getString(7),con.getResultQuery().getString(8),con.getResultQuery().getString(9),con.getResultQuery().getString(10),con.getResultQuery().getString(11),con.getResultQuery().getString(12));
                lis.add(us);
            }
        con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lis;
    }
    
    public static Usuario getUsuario(String codigo){
        try {
            ArrayList<Usuario> lis = UsuarioDao.Lista();
            for(Usuario us: lis) if(us.getIdentificacion().equals(codigo)) return us;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String Insertar(Usuario us){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(us.getFecha_nacimiento());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("insert into usuario(nombre,apellido,fecha_nacimiento,telefono,identificacion,correo,password,foto,ciudad_id,tipo_usuario_id,tipo_documento_id) values('%s','%s','%s','%s','%s','%s','%s','%s',%d,%d,%d)", us.getNombre(),us.getApellido(),fecha1,us.getTelefono(),us.getIdentificacion(),us.getCorreo(),us.getPassword(),us.getFoto(),Integer.parseInt(us.getCiudad()),Integer.parseInt(us.getTipo_usuario()),Integer.parseInt(us.getTipo_documento())));
            if(con.getResultUpdate()>0) return "El usuario se registro exitosamente";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Actualizar(Usuario us){
        try {
            SimpleDateFormat fomr1 = new SimpleDateFormat("yyyy-MM-dd");
            Date fe1 = (Date)fomr1.parse(us.getFecha_nacimiento());
            java.sql.Date fecha1 = new java.sql.Date(fe1.getTime());
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("update usuario set nombre='%s', apellido='%s', fecha_nacimiento='%s', telefono='%s', identificacion='%s', correo='%s', password='%s', foto='%s', ciudad_id=%d, tipo_usuario_id=%d,tipo_documento_id=%d where id=%d", us.getNombre(),us.getApellido(),fecha1,us.getTelefono(),us.getIdentificacion(),us.getCorreo(),us.getPassword(),us.getFoto(),Integer.parseInt(us.getCiudad()),Integer.parseInt(us.getTipo_usuario()),Integer.parseInt(us.getTipo_documento()),Integer.parseInt(us.getId())));
            if(con.getResultUpdate()>0) return "Los datos se actualizaron";
            con.closeDb();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "error_1";
    }
    
    public static String Eliminar(Usuario us){
        try {
            ConnectionMySQL con = Conexion.conexion();
            con.ExecuteQuery(String.format("delete from usuario where id=%d", Integer.parseInt(us.getId())));
            con.closeDb();
            if(con.getResultUpdate()==1) return "El usuario se elimino correctamente";
        } catch (Exception e) {
        }
        return "error_1";
    }
}

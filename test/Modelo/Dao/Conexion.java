/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Dao;

import SIGTools.ConnectionBD.ConnectionMySQL;
/**
 *
 * @author Villa
 */
public class Conexion {
    public static ConnectionMySQL conexion(){
        ConnectionMySQL con=null;
        try {
            con = new ConnectionMySQL("server", "user", "pwd");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
    
/**
 *
 * @author aC-Ma_000
 */
public class AdministradorBD {
    
    
    public ResultSet misAnuncios(){
        ResultSet rs=null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query= "SELECT * FROM VentasPrueba";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet marcas(){
        
            ResultSet rs=null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query = "SELECT * FROM marcas";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet modelo(String marca){
        
            ResultSet rs = null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query = "SELECT * FROM modelos WHERE marca = '"+ marca+"'";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return rs;
    }
    
    public void agregaAnuncio(String titulo,String url, String marca, String modelo, String fechaI, String fechaF, String descripcion){
        Connection con;
        con = ConexionBD.GetConnection();
        
    }
}

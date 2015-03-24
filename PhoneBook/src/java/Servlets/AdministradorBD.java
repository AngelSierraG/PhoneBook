/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
            
            String query= "select idAnuncio,urlImage, titulo, precio, fechainicio, fechafinal from anuncios";
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
    
    public void agregaAnuncio(String url,String titulo,String marca, String modelo, String precio, String fechaI, String fechaF, String descripcion){
        try {
            ResultSet rs = null;
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query="INSERT INTO ventasprueba (url,Tanuncio,marca,modelo,Precio,FechaI,FechaF,Desccripcion) VALUES(?,?,?,?,?,?,?,?)";
            
            PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, url);
                    ps.setString(2, titulo);
                    ps.setString(3, marca);
                    ps.setString(4, modelo);
                    ps.setString(5, precio);
                    ps.setString(6, fechaI);
                    ps.setString(7, fechaF);
                    ps.setString(8, descripcion);
                    ps.executeUpdate(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

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
    
    
    public ResultSet misPublicaciones(){
        ResultSet rs=null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query= "select idpublicacion,urlImage, titulo, precio, fechainicio, fechafinal from publicaciones";
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
            
            String query = "SELECT idmarca, nombremarca FROM marcas";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet modelo(String idmarca){
        
            ResultSet rs = null;
            int id = Integer.parseInt(idmarca);
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query = "SELECT idmodelo,NombreModelo FROM modelos WHERE Marcas_idMarca = '"+ id +"'";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return rs;
    }
    
    public void agregaAnuncio(String url,String titulo, String modelo, String precio, String fechaI, String fechaF, String descripcion){
        try {
            ResultSet rs = null;
            Connection con;
            con = ConexionBD.GetConnection();
            String usuarii="Usuario";
            
            String query="INSERT INTO anuncios (Titulo,FechaInicio,FechaFinal,Precio,Descripcion,urlImage,Usuario,Modelos_idModelo) VALUES(?,?,?,?,?,?,?,?)";
            
            PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, titulo);
                    ps.setString(2, fechaI);
                    ps.setString(3, fechaF);
                    ps.setInt(4, Integer.parseInt(precio));
                    ps.setString(5, descripcion);
                    ps.setString(6, url);
                    ps.setString(7, usuarii);
                    ps.setInt(8, Integer.parseInt(modelo));
                    ps.executeUpdate(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     

    }
    
    public int NumeroAnuncios(){
        int totalAnuncios=0;
         try {
            
            Connection con;
            con = ConexionBD.GetConnection();
             
            String query = "SELECT Count(idAnuncio) as \"contador\" FROM anuncios";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                totalAnuncios = rs.getInt("contador");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         return totalAnuncios;
     }
    
    public ResultSet editarAnuncio(String idanuncio){
            
            int id = Integer.parseInt(idanuncio);
        
            ResultSet rs = null;
        try {
            
            Connection con;
            con = ConexionBD.GetConnection();
            String query = "select titulo, FechaInicio, FechaFinal, Precio, Descripcion, anuncios.urlImage, nombremodelo, nombremarca from anuncios"
                    + " inner join modelos on modelos_idmodelo = idmodelo inner join marcas on idmarca = marcas_idmarca where idanuncio ="+id;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
       
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rs;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

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
    
    public void agregaPublicacion(String url,String titulo, String modelo, String precio, String fechaI, String fechaF, String descripcion){
        try {
            ResultSet rs = null;
            Connection con;
            con = ConexionBD.GetConnection();
            String usuarii="Usuario";
            
            String query="INSERT INTO publicaciones (Titulo,FechaInicio,FechaFinal,Precio,Descripcion,urlImage,Usuario,Modelos_idModelo) VALUES(?,?,?,?,?,?,?,?)";
            
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
    
    public int NumeroPublicaciones(){
        int totalPublicaciones=0;
         try {
            
            Connection con;
            con = ConexionBD.GetConnection();
             
            String query = "SELECT Count(idPublicacion) as \"contador\" FROM publicaciones";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                totalPublicaciones = rs.getInt("contador");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         return totalPublicaciones;
     }
    
    public ResultSet Publicacion_a_editar(String idanuncio){
            
            int id = Integer.parseInt(idanuncio);
        
            ResultSet rs = null;
        try {
            
            Connection con;
            con = ConexionBD.GetConnection();
            String query = "select titulo, FechaInicio, FechaFinal, Precio, Descripcion, publicaciones.urlImage, nombremodelo, nombremarca from publicaciones"
                    + " inner join modelos on modelos_idmodelo = idmodelo inner join marcas on idmarca = marcas_idmarca where idpublicacion ="+id;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
       
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rs;
    }
    
    public void editarPublicacion(String id,String url,String titulo,String sel_modelo,String precio,String fechaI,String fechaF,String descripcion){
         try {
            ResultSet rs = null;
            Connection con;
            con = ConexionBD.GetConnection();
            String usuarii="Usuario";
            
            String query="UPDATE publicaciones SET titulo=?,FechaInicio=?, FechaFinal=?"
                    + ", Precio=?, Descripcion=?, urlImage=?, Modelos_idModelo=? WHERE idPublicacion=?";
            
            PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, titulo);
                    ps.setString(2, fechaI);
                    ps.setString(3, fechaF);
                    ps.setInt(4, Integer.parseInt(precio));
                    ps.setString(5, descripcion);
                    ps.setString(6, url);
                    ps.setInt(7, Integer.parseInt(sel_modelo));
                    ps.setInt(8, Integer.parseInt(id));
                    ps.executeUpdate(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPublicacion(int id){
        try {
            ResultSet rs=null;
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query = "DELETE FROM publicaciones WHERE idpublicacion =?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet marcas_Imagen(){
         ResultSet rs=null;
        try {
            Connection con;
            
            con = ConexionBD.GetConnection();
            String query = "SELECT * FROM  marcas";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    //inicia comprador
    public ResultSet Ver_Anuncio(){
        
            ResultSet rs = null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query = "SELECT * FROM anuncios";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return rs;
    }
    
     public ResultSet Ver_info(String idAnuncio){
        
            ResultSet rs = null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query = "SELECT * FROM anuncios WHERE idAnuncio ='"+ idAnuncio+"'";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return rs;
    }
    
}

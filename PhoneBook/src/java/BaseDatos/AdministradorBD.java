/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import java.sql.Connection;
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
    
    //Inicia Registro
    public void agregarUsuario(String nickname, String pass, String nombre, String apellido, String estado, String ciudad, String direccion, String telefono){
        try {
            ResultSet rs = null;
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query="INSERT INTO usuarios (Password,NickName,Nombre,Apellido,Estado,Ciudad,Direccion,Telefono) VALUES(?,?,?,?,?,?,?,?)";
            
            PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, pass);
                    ps.setString(2, nickname);
                    ps.setString(3, nombre);
                    ps.setString(4, apellido);
                    ps.setString(5, estado);
                    ps.setString(6, ciudad);
                    ps.setString(7, direccion);
                    ps.setString(8, telefono);
                    ps.executeUpdate(); 
                   
                    ps.close();
                    con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ResultSet Login(String nickname, String pass){
         ResultSet rs=null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query= "SELECT nickname, password FROM usuarios WHERE nickname = '"+nickname+"' AND password='"+pass+"'";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    } 
        
    //Fin Registro
    
    ////Inicia Vendedor
    public ResultSet misPublicaciones(String usuario){
        ResultSet rs=null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query= "select idpublicacion,urlImage, titulo, precio, fechainicio, fechafinal from publicaciones where usuario='"+usuario+"'";
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
    
    public void agregaPublicacion(String url,String usuario,String titulo, String modelo, String precio, String fechaI, String fechaF, String descripcion){
        try {
            ResultSet rs = null;
            Connection con;
            con = ConexionBD.GetConnection();
           
            
            String query="INSERT INTO publicaciones (Titulo,FechaInicio,FechaFinal,Precio,Descripcion,urlImage,Usuario,Modelos_idModelo) VALUES(?,?,?,?,?,?,?,?)";
            
            PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, titulo);
                    ps.setString(2, fechaI);
                    ps.setString(3, fechaF);
                    ps.setInt(4, Integer.parseInt(precio));
                    ps.setString(5, descripcion);
                    ps.setString(6, url);
                    ps.setString(7, usuario);
                    ps.setInt(8, Integer.parseInt(modelo));
                    ps.executeUpdate(); 
                   
                    ps.close();
                    con.close();
            
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
            rs.close();
            con.close();
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
                    
                    ps.close();
                    con.close();
            
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
            
            preparedStmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ///Fin vendedor
    // Inicia Administrador
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
    
    public String getUltimoId(){
    String id = null; 
    try {
            Connection con;
            ResultSet rs = null;  
            con = ConexionBD.GetConnection();
            String query = "SELECT count(`idMarca`) as contador FROM `marcas` ";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next()){
            id=""+rs.getString("contador");  
            
            int id2 = Integer.parseInt(id) +1;
            id= ""+id2;
            
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    return id; 
    
    }
    
    public void insertMarca(String nombreMarca, String urlImage){
          try {
            
            Connection con;
            
            con = ConexionBD.GetConnection();
            
            
            
            String query="INSERT INTO `phonebook`.`marcas` ( `NombreMarca`, `urlImage`) VALUES ( ?, ?)";
                  PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, nombreMarca);
                    ps.setString(2, urlImage);
                   
                    ps.executeUpdate();
                    ps.close();
                    con.close();
                
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public ResultSet thisMarca(String idMarca){
    ResultSet rs = null; 
    
     try {
            Connection con;
            
            con = ConexionBD.GetConnection();
            String query = "SELECT * FROM  marcas where idMarca = "+idMarca+"";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    return rs; 
    }
    public void editarMarca(String idMarca, String nombreMarca, String urlImage){
    try {
            
            Connection con;
            
            con = ConexionBD.GetConnection();
            
            
            
            String query="UPDATE  `phonebook`.`marcas` SET  `NombreMarca` =  ?,`urlImage`=? WHERE  `marcas`.`idMarca` =?;";
                  PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, nombreMarca);
                    ps.setString(2, urlImage);
                    ps.setInt(3, Integer.parseInt(idMarca));
                    ps.executeUpdate();
            ps.close();
            con.close();
                
           con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Marlon
    public void crearModelo(String nombreModelo, int precioNuevo, String sistemaO, int sel_marca, int sel_camara, String sel_resolucion, String sel_memoria){
         try {
            ResultSet rs = null;
            Connection con;
            con = ConexionBD.GetConnection();
            String usuarii="Usuario";
            
            String query="INSERT INTO modelos (NombreModelo,PrecioNuevo,SisOperativo,Marcas_idMarca,Camara,ResolucionC,MemoriaInterna) VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, nombreModelo);
                    ps.setInt(2, precioNuevo);
                    ps.setString(3, sistemaO);
                    ps.setInt(4, sel_marca);
                    ps.setInt(5, sel_camara);
                    ps.setString(6, sel_resolucion);
                    ps.setString(7, sel_memoria);
                    ps.executeUpdate(); 
                    
                    ps.close();
                    con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    }
    public ResultSet listaModelos(){
         ResultSet rs=null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query= "select idModelo, NombreModelo from modelos";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void eliminarModelos(int id){
      try {
            ResultSet rs=null;
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query = "DELETE FROM modelos WHERE idmodelo =?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            
            preparedStmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
    public ResultSet Modelo_a_editar(String idmodelo){
            
            int id = Integer.parseInt(idmodelo);
        
            ResultSet rs = null;
        try {
            
            Connection con;
            con = ConexionBD.GetConnection();
            String query = "SELECT idmodelo, nombremodelo, precionuevo, sisoperativo, nombremarca, camara, resolucionC, memoriainterna from modelos"
                    + " inner join marcas on marcas_idmarca = idmarca where idmodelo ="+id;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
       
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rs;
    }
    public void editarModelo(int id,String nombreModelo,int precioNuevo,String sistemaO,int sel_marca,int sel_camara,String resolucion,String memoria){
         try {
            ResultSet rs = null;
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query="UPDATE modelos SET NombreModelo=?,PrecioNuevo=?, SisOperativo=?"
                    + ", Marcas_idMarca=?, Camara=?, ResolucionC=?, MemoriaInterna=? WHERE idModelo=?";
            
            PreparedStatement  ps = con.prepareStatement(query);
                    ps.setString(1, nombreModelo);
                    ps.setInt(2, precioNuevo);
                    ps.setString(3, sistemaO);
                    ps.setInt(4, sel_marca);
                    ps.setInt(5, sel_camara);
                    ps.setString(6, resolucion);
                    ps.setString(7, memoria);
                    ps.setInt(8, id);
                    ps.executeUpdate(); 
                    
                    ps.close();
                    con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// Fin administrador
    
    
    //inicia comprador
    public ResultSet Ver_Publicacion(){
        
            ResultSet rs = null;
        try {
            Connection con;
            con = ConexionBD.GetConnection();
            
            String query = "SELECT * FROM publicaciones";
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return rs;
    }
    
     public ResultSet Ver_info(String idPublicacion){
        
           int id = Integer.parseInt(idPublicacion);
        
            ResultSet rs = null;
        try {
            
             Connection con;
            con = ConexionBD.GetConnection();
            String query = "select titulo, Precio,Usuario, PrecioNuevo,Descripcion, SisOperativo,Camara,ResolucionC,MemoriaInterna, publicaciones.urlImage, nombremodelo, nombremarca from publicaciones"
                    + " inner join modelos on modelos_idmodelo = idmodelo inner join marcas on idmarca = marcas_idmarca where idpublicacion ="+id;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
       
       
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rs;
    }
    
    
}

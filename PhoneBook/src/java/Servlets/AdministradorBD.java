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
            
            while (rs.next()){
                int id = rs.getInt("id");
                String imagen = rs.getString("Imagen");
                String Tanuncio = rs.getString("Tanuncio");
                int Precio = rs.getInt("Precio");
                Date FechaI = rs.getDate("FechaI");
                Date FechaF = rs.getDate("FechaF");

                System.out.format("%s, %s, %s, %s, %s, %s\n", id, imagen, Tanuncio, Precio, FechaI, FechaF);    
            }
            st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}

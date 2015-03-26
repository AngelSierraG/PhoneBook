/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comprador;

import BaseDatos.AdministradorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dago
 */
public class Usuario_general {
    
     public String listar(){
        
        AdministradorBD admi =new AdministradorBD();
        ResultSet rs = admi.Listar_publicacion();
        String String_publicaciones="";
         
            try {
                
            String_publicaciones="<table class=\"tablesorter\" cellspacing=\"1\" cellpadding=\"1\" id=\"reservations\" > \n" +
"			<thead> \n" +
"				<tr> \n" +
"   					\n" +

"    				<th>Imagen</th>\n" +
                    
"    				<th>Titulo del Anuncio</th> \n" +
"    				<th>Precio</th> \n" +


"                    <th></th> \n" +
"				</tr> \n" +
"			</thead>     \n" +
"            <tbody> ";    
                while (rs.next()){
                     int id = rs.getInt("idPublicacion");
                    String imagen = rs.getString("urlImage");
                    String Tpublicacion = rs.getString("titulo");
                    int Precio = rs.getInt("precio");
        
                   
                    String_publicaciones = String_publicaciones + "<tr> \n" +

"   					<td><input width=\"50px\" height=\"50px\" type=\"image\"  src=\"BDImagenes_Usuarios/"+imagen+"\" title=\"MinImg\"></td>\n" +
"    				<td>"+Tpublicacion+"</td> \n" +
                            
"    				<td>"+Precio+"</td> \n" +



"				</tr> ";
                        }
                 rs.close();
                String_publicaciones = String_publicaciones + "</tbody> \n" +
"			</table>";
                
            } catch (SQLException ex) {
                Logger.getLogger(Usuario_general.class.getName()).log(Level.SEVERE, null, ex);
            }
            return String_publicaciones;
    }
    
    
}

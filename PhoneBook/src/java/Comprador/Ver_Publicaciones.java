/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comprador;

import BaseDatos.AdministradorBD;
import Servlets.Ver_Publicacion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dago
 */
public class Ver_Publicaciones {
    
     public String listar_publicaciones(){
        
        AdministradorBD admi =new AdministradorBD();
        ResultSet rs = admi.Ver_Publicacion();
        String String_publicaciones="";
         
            try {
                
            String_publicaciones="<table class=\"tablesorter\" cellspacing=\"1\" cellpadding=\"1\" id=\"reservations\" > \n" +
"			<thead> \n" +
"				<tr> \n" +
"   					\n" +
"    				<th>ID</th> \n" +
"    				<th>Imagen</th>\n" +
"    				<th>Titulo del Anuncio</th> \n" +
"    				<th>Precio</th> \n" +
"    				<th>Fecha Inicio</th>\n" +
"                    <th>Fecha Final</th>  \n" +
"                    <th></th> \n" +
"				</tr> \n" +
"			</thead>     \n" +
"            <tbody> ";    
                while (rs.next()){
                    int id = rs.getInt("idPublicacion");
                    String imagen = rs.getString("urlImage");
                    String Tpublicacion = rs.getString("titulo");
                    int Precio = rs.getInt("precio");
                    Date FechaI = rs.getDate("fechainicio");
                    Date FechaF = rs.getDate("fechafinal");
                    String_publicaciones = String_publicaciones + "<tr> \n" +
"   					<td>"+id+"</td> \n" +
"   					<td><input width=\"50px\" height=\"50px\" type=\"image\" src=\"BDImagenes_Usuarios/"+imagen+"\" title=\"MinImg\"></td>\n" +
"    				<td>"+Tpublicacion+"</td> \n" +
"    				<td>"+Precio+"</td> \n" +
"    				<td>"+FechaI+"</td> \n" +
"                    <td>"+FechaF+"</td> \n" +
"    				<td><input type=\"image\" src=\"images/icn_edit.png\" onclick=\"redireccion("+id+");\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" onclick=\"eliminar_publicacion("+id+");\" title=\"Trash\"></td> \n" +
"				</tr> ";
                        }
                 rs.close();
                String_publicaciones = String_publicaciones + "</tbody> \n" +
"			</table>";
                
            } catch (SQLException ex) {
                Logger.getLogger(Ver_Publicacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return String_publicaciones;
    }
    
     
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author aC-Ma_000
 */
public class GetAnuncios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        AdministradorBD admi =new AdministradorBD();
        ResultSet rs = admi.misAnuncios();
         String String_anuncios="";
         
            try {
                
            String_anuncios="<table class=\"tablesorter\" cellspacing=\"1\" cellpadding=\"1\" id=\"reservations\" > \n" +
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
                    int id = rs.getInt("idAnuncio");
                    String imagen = rs.getString("urlImage");
                    String Tanuncio = rs.getString("titulo");
                    int Precio = rs.getInt("precio");
                    Date FechaI = rs.getDate("fechainicio");
                    Date FechaF = rs.getDate("fechafinal");
                    String_anuncios = String_anuncios + "<tr> \n" +
"   					<td>"+id+"</td> \n" +
"   					<td><input width=\"50px\" height=\"50px\" type=\"image\" src=\"BDImagenes_Usuarios/"+imagen+"\" title=\"MinImg\"></td>\n" +
"    				<td>"+Tanuncio+"</td> \n" +
"    				<td>"+Precio+"</td> \n" +
"    				<td>"+FechaI+"</td> \n" +
"                    <td>"+FechaF+"</td> \n" +
"    				<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n" +
"				</tr> ";
                        }
                 rs.close();
                String_anuncios = String_anuncios + "</tbody> \n" +
"			</table>";
                
            } catch (SQLException ex) {
                Logger.getLogger(GetAnuncios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            out.print(String_anuncios);
            out.flush();
            out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

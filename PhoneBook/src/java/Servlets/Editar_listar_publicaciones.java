/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import BaseDatos.AdministradorBD;
import Vendedor.Crear_Publicaciones;
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
public class Editar_listar_publicaciones extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Crear_Publicaciones CP = new Crear_Publicaciones();
        CP.editar_publicacion(request, response);
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
     Crear_Publicaciones CP = new Crear_Publicaciones();
               String String_publicaciones = CP.listar_publicaciones();
            
            out.print(String_publicaciones);
            out.flush();
            out.close();
    }
}

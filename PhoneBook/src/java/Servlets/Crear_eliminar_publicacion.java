/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Vendedor.Crear_Publicaciones;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aC-Ma_000
 */
public class Crear_eliminar_publicacion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Crear_Publicaciones CP = new Crear_Publicaciones();
       String ruta = getServletContext().getRealPath("")
                + File.separator + "BDImagenes_Usuarios";
        CP.crear_publicacion(request, response, ruta);
        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
        Crear_Publicaciones CP = new Crear_Publicaciones();
        CP.eliminar_publicacion(id);
        
        request.setAttribute("message", "Publicacion eliminada exitosamente.");
         request.getRequestDispatcher("/interfaz_Vendedor.jsp").forward(request, response);
    }
}

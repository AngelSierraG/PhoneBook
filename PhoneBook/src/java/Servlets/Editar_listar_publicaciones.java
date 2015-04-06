/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Vendedor.Crear_Publicaciones;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author aC-Ma_000
 */
public class Editar_listar_publicaciones extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Crear_Publicaciones CP = new Crear_Publicaciones();
         String ruta = getServletContext().getRealPath("")
                + File.separator + "BDImagenes_Usuarios";
        CP.editar_publicacion(request, response,ruta);
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
              HttpSession session = request.getSession();
              String user = (String)session.getAttribute("sesion_usuario");
                Crear_Publicaciones CP = new Crear_Publicaciones();
               String String_publicaciones = CP.listar_publicaciones(user);
            
            out.print(String_publicaciones);
            out.flush();
            out.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Administrador.GestorMarcas;
import Vendedor.Crear_Publicaciones;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aC-Ma_000
 */
public class Editar_Eliminar_Marcas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
        GestorMarcas GM = new GestorMarcas();
        GM.eliminar_marca(id);
        
         request.setAttribute("message", "Publicacion eliminada exitosamente.");
         request.getRequestDispatcher("/Gestor_Marcas_Lista_Marcas.jsp").forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String ruta = getServletContext().getRealPath("")
                + File.separator + "images/Marcas";
               GestorMarcas GM = new GestorMarcas();
               GM.editarMarcas(request, response,ruta);
    }

    
}

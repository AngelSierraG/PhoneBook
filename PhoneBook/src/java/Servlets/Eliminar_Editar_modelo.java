/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Administrador.GestorModelos;
import Vendedor.Crear_Publicaciones;
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
public class Eliminar_Editar_modelo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
        GestorModelos GM = new GestorModelos();
        GM.eliminarModelo(id);
        request.setAttribute("message", "Modelo eliminado exitosamente.");
         request.getRequestDispatcher("/Gestor_Modelos_Lista_Modelos.jsp").forward(request, response);    
        
    }

    
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorModelos GM = new GestorModelos();
        GM.editarModelo(request, response);
    }

   
}

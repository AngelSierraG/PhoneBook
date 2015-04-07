/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Chat.Usuario;
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
public class closeSession extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String USER = (String)session.getAttribute("sesion_usuario");
        Usuario user = new Usuario();
        user.deleteUsuario(USER);
         request.getSession().invalidate();
         response.sendRedirect(request.getContextPath() + "/interfaz_user_general.jsp");
    }

}

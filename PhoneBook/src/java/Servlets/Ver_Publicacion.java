/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Comprador.Ver_Publicaciones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dago
 */
public class Ver_Publicacion extends  HttpServlet {
 
    
    
   
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
     Ver_Publicaciones CP = new Ver_Publicaciones();
               String String_publicaciones = CP.listar_publicaciones();
            
            out.print(String_publicaciones);
            out.flush();
            out.close();
    }
}

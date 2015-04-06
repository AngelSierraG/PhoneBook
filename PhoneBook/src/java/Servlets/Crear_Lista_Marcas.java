/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Administrador.GestorMarcas;
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
public class Crear_Lista_Marcas extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        GestorMarcas GM =new GestorMarcas();
            String string_marcas = GM.listaMarcas();
            out.print(string_marcas);
            out.flush();
            out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        GestorMarcas GM = new GestorMarcas();
        String ruta = getServletContext().getRealPath("")
                + File.separator + "/images/Marcas";
        GM.crearMarcas(request, response, ruta);
    }

}

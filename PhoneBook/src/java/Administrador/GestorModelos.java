/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Administrador;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aC-Ma_000
 */
public class GestorModelos {
    public void crearModelo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
        
        String nombreModelo = new String(request.getParameter("nombreModelo").getBytes("ISO-8859-1"), "UTF-8");
        String precioNuevo = new String(request.getParameter("precioNuevo").getBytes("ISO-8859-1"), "UTF-8");
        String sistemaO = new String(request.getParameter("sistemaO").getBytes("ISO-8859-1"), "UTF-8");
        String sel_marca = new String(request.getParameter("sel_marca").getBytes("ISO-8859-1"), "UTF-8");
        String sel_camara = new String(request.getParameter("sel_camara").getBytes("ISO-8859-1"), "UTF-8");
        String sel_resolucion = new String(request.getParameter("sel_resolucion").getBytes("ISO-8859-1"), "UTF-8");
        String sel_memoria = new String(request.getParameter("sel_memoria").getBytes("ISO-8859-1"), "UTF-8");
        
        
    }
    public void editarModelo(){
        
    }
    public void eliminarModelo(){
        
    }
    public void listarModelo(){
        
    }
    
}

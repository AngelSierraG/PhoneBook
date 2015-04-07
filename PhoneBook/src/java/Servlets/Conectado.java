/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Chat.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aC-Ma_000
 */
@WebServlet(name = "Conectado", urlPatterns = {"/Conectado.do"})
public class Conectado extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String USER = (String)session.getAttribute("sesion_usuario");
        String user = new String(request.getParameter("user").getBytes("ISO-8859-1"), "UTF-8");
        Usuario Usuarios = new Usuario();
        ArrayList usuarios = Usuarios.getUsuarios();
        
        
        int con=0;
        for(int i=0; i< usuarios.size(); i++){
                if(usuarios.get(i).equals(user)){
                    con++;
                }
        }
        
        String string_botones="";
        if(con==0){
            string_botones=" <button onclick=\"mailsome1()\">Enviar Correo</button>\n";
        }else{
            if(!USER.equals(user)){
            string_botones=" <button onclick=\"mailsome1()\">Enviar Correo</button>\n" +
"                                            <button onclick=\"iniciarChat('"+USER+"','"+user+"')\" >Iniciar Chat</button>";
            }else{
            string_botones=" <button onclick=\"mailsome1()\">Enviar Correo</button>\n";
            }
            }
       
        out.print(string_botones);
            out.flush();
            out.close();
    }
}

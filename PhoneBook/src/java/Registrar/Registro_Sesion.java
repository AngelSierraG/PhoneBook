package Registrar;

import BaseDatos.AdministradorBD;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aC-Ma_000
 */
public class Registro_Sesion {
    
    public void agregarUsuario(HttpServletRequest request,HttpServletResponse response){
        try {
            
            String nickname = new String(request.getParameter("emailRegistro").getBytes("ISO-8859-1"), "UTF-8");
            String pass = new String(request.getParameter("passRegistro").getBytes("ISO-8859-1"), "UTF-8");
            String nombre = new String(request.getParameter("nombre").getBytes("ISO-8859-1"), "UTF-8");
            String apellido = new String(request.getParameter("apellido").getBytes("ISO-8859-1"), "UTF-8");
            String estado = new String(request.getParameter("estado").getBytes("ISO-8859-1"), "UTF-8");
            String ciudad = new String(request.getParameter("ciudad").getBytes("ISO-8859-1"), "UTF-8");
            String direccion = new String(request.getParameter("direccion").getBytes("ISO-8859-1"), "UTF-8");
            String telefono = new String(request.getParameter("telefono").getBytes("ISO-8859-1"), "UTF-8");
            
            AdministradorBD admi = new AdministradorBD();
            admi.agregarUsuario(nickname, pass, nombre, apellido, estado, ciudad, direccion, telefono);
            
            request.setAttribute("message", "El usuario \""+nickname+"\" fue agregado exitosamente.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Registro_Sesion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Registro_Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

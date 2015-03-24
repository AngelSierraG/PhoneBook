/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author aC-Ma_000
 */
public class GetModelos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void todoModelos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String idmarca = new String(request.getParameter("idmarca").getBytes("ISO-8859-1"), "UTF-8");
        AdministradorBD admi =new AdministradorBD();
        ResultSet rs = admi.modelo(idmarca);
         String String_modelos="";
         
            try {
                
            String_modelos="<option value='0'>Selecciona un modelo</option>";    
                while (rs.next()){
                    int idmodelo = rs.getInt("idmodelo");
                    String modelo = rs.getString("NombreModelo");
                  
                        String_modelos = String_modelos + "<option value='"+idmodelo+"'>"+modelo+"</option>";
                        }
                 rs.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(GetModelos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            out.print(String_modelos);
            out.flush();
            out.close();
    }
    
    
    protected void modeloSelec(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String idmarca = new String(request.getParameter("idmarca").getBytes("ISO-8859-1"), "UTF-8");
        String modelo_sel = new String(request.getParameter("modelo").getBytes("ISO-8859-1"), "UTF-8");
        
        System.out.print("modelo_sel: "+modelo_sel + "idmarca: "+idmarca);
        
        AdministradorBD admi =new AdministradorBD();
        ResultSet rs = admi.modelo(idmarca);
         String String_sel_modelo="";
         
            try {
                
            String_sel_modelo="<option value='0'>Selecciona un modelo</option>";    
                while (rs.next()){
                    int idmodelo = rs.getInt("idmodelo");
                    String modelo = rs.getString("NombreModelo");
                        if(!modelo.equals(modelo_sel)){
                        String_sel_modelo = String_sel_modelo + "<option value='"+idmodelo+"'>"+modelo+"</option>";
                        }else{
                          String_sel_modelo = String_sel_modelo + "<option value='"+idmodelo+"' selected=\"selected\">"+modelo+"</option>";  
                        }
                        }
                 rs.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(GetModelos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            out.print(String_sel_modelo);
            out.flush();
            out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        todoModelos(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        modeloSelec(request, response);
    }

}

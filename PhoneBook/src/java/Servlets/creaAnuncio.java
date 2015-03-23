/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author aC-Ma_000
 */
public class creaAnuncio extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "C:\\Users\\aC-Ma_000\\Documents\\PhoneBook\\PhoneBook\\web\\BDImagenes";
  
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              String titulo="",sel_marca="",sel_modelo="",fechaI="",fechaF="",descripcion="";
        
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }else{
                        if("titulo".equals(item.getFieldName())){
                            titulo = item.getString();
                        }
                        if("sel_marca".equals(item.getFieldName())){
                            sel_marca = item.getString();
                        }
                        if("sel_modelo".equals(item.getFieldName())){
                            sel_modelo = item.getString();
                        }
                        if("fechaI".equals(item.getFieldName())){
                            fechaI = item.getString();
                        }
                        if("fechaF".equals(item.getFieldName())){
                            fechaF = item.getString();
                        }
                        if("descripcion".equals(item.getFieldName())){
                            descripcion = item.getString();
                        }
                    }
                }
                
      
               //File uploaded successfully
               request.setAttribute("message", "Publicacion \""+titulo+"\" Exitosa.");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/interfaz_Vendedor.jsp").forward(request, response);
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

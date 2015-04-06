/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vendedor;

import Servlets.Editar_listar_publicaciones;
import BaseDatos.AdministradorBD;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author aC-Ma_000
 */
public class Crear_Publicaciones {
//    
//    String UPLOAD_DIRECTORY = "BDImagenes_Usuarios";
   
    public String listar_publicaciones(String usuario){
        
        AdministradorBD admi =new AdministradorBD();
        ResultSet rs = admi.misPublicaciones(usuario);
        String String_publicaciones="";
         
            try {
                
            String_publicaciones="<table class=\"tablesorter\" cellspacing=\"1\" cellpadding=\"1\" id=\"reservations\" > \n" +
"			<thead> \n" +
"				<tr> \n" +
"   					\n" +
"    				<th>Imagen</th>\n" +
"    				<th>Titulo de la Publicacion</th> \n" +
"    				<th>Precio</th> \n" +
"    				<th>Fecha Inicio</th>\n" +
"                    <th>Fecha Final</th>  \n" +
"                    <th></th> \n" +
"				</tr> \n" +
"			</thead>     \n" +
"            <tbody> ";    
                while (rs.next()){
                    int id = rs.getInt("idPublicacion");
                    String imagen = rs.getString("urlImage");
                    String Tpublicacion = rs.getString("titulo");
                    String Precio = "$ "+ rs.getString("precio");
                    Date FechaI = rs.getDate("fechainicio");
                    Date FechaF = rs.getDate("fechafinal");
                    String_publicaciones = String_publicaciones + "<tr> \n" +
"   					<td><input width=\"50px\" height=\"50px\" type=\"image\" src=\"BDImagenes_Usuarios/"+imagen+"\" title=\"MinImg\"></td>\n" +
"    				<td>"+Tpublicacion+"</td> \n" +
"    				<td>"+Precio+"</td> \n" +
"    				<td>"+FechaI+"</td> \n" +
"                    <td>"+FechaF+"</td> \n" +
"    				<td><input type=\"image\" src=\"images/icn_edit.png\" onclick=\"redireccion("+id+");\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" onclick=\"eliminar_publicacion("+id+");\" title=\"Trash\"></td> \n" +
"				</tr> ";
                        }
                 rs.close();
                String_publicaciones = String_publicaciones + "</tbody> \n" +
"			</table>";
                
            } catch (SQLException ex) {
                Logger.getLogger(Editar_listar_publicaciones.class.getName()).log(Level.SEVERE, null, ex);
            }
            return String_publicaciones;
    }
    
    public void crear_publicacion(HttpServletRequest request,HttpServletResponse response,String ruta) throws ServletException, IOException{
        
         
        String url="",usuario="",titulo="",precio="",sel_modelo="",fechaI="",fechaF="",descripcion="";
        
              AdministradorBD admi = new AdministradorBD();
             
              
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        
                        String name = "Img_"+admi.NumeroPublicaciones()+".jpg";
                        item.write( new File(ruta + File.separator + name));
                        url = name;    
                    }else{
                      if("usuario".equals(item.getFieldName())){
                            usuario = item.getString();
                        }
                        if("titulo".equals(item.getFieldName())){
                            titulo = item.getString();
                        }
                        if("precio".equals(item.getFieldName())){
                            precio = item.getString();
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
                
               
               admi.agregaPublicacion(url,usuario, titulo, sel_modelo, precio, fechaI, fechaF, descripcion);
      
               //File uploaded successfully
               request.setAttribute("message", "Publicacion \""+titulo+"\" creada exitosamente.");
               request.getRequestDispatcher("/interfaz_Vendedor.jsp").forward(request, response);
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
     
    }
    
    public void editar_publicacion(HttpServletRequest request,HttpServletResponse response,String ruta){
       
       String id="",url="",titulo="",precio="",sel_modelo="",fechaI="",fechaF="",descripcion="",Aux="",name="";
        
       System.out.println("Sii llego.....");
       
              AdministradorBD admi = new AdministradorBD();
              Calendar calendario = new GregorianCalendar();
              int seg = calendario.get(Calendar.SECOND);
              
        if(ServletFileUpload.isMultipartContent(request)){
            
            try {
                
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
               for(FileItem item : multiparts){
                   System.out.println("Legaaaaaaa");
                    if(item.isFormField()){
                        if("titulo".equals(item.getFieldName())){
                            titulo = item.getString();
                        }
                        if("precio".equals(item.getFieldName())){
                            precio = item.getString();
                        }
                        if("id".equals(item.getFieldName())){
                            id = item.getString();
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
                        if("Aux".equals(item.getFieldName())){
                            Aux = item.getString();
                        }
                    }
                }
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                         name = "Img_"+id+seg+".jpg";
                         item.write( new File(ruta + File.separator + name));
                          url=name;
                    }
                }
                
               admi.editarPublicacion(id,url, titulo, sel_modelo, precio, fechaI, fechaF, descripcion);

               request.setAttribute("message", "Publicacion \""+titulo+"\" editada exitosamente.");
               request.getRequestDispatcher("/interfaz_Vendedor.jsp").forward(request, response); 
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload url: "+url+" aux:"+Aux );
        }
         
    }
    
    public void eliminar_publicacion(String id){
            
            int ID = Integer.parseInt(id);
            AdministradorBD admi =new AdministradorBD();
            admi.eliminarPublicacion(ID);
    }
}

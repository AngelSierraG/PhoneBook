/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import BaseDatos.AdministradorBD;
import java.io.File;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Angel Sierra
 */
public class GestorMarcas {
//    Connection conexion =  new ConexionBD().GetConnection();
    
    public String listaMarcas(){
        String listaMarca = null;
//        Statement stmt=null;
        ResultSet rst=null;
        try{
        //conectándose a la base de datos
     
//        stmt = conexion.createStatement();
//            rst = stmt.executeQuery("SELECT * FROM  `marcas` ");
            AdministradorBD admi = new AdministradorBD();
            rst = admi.marcas_Imagen();
            //out.println(value);
            
            listaMarca = "<table class=\"tablesorter\" cellspacing=\"1\" cellpadding=\"1\" id=\"reservations\" ><thead><tr><th>ID</th><th>Imagen</th><th>Nombre Marca</th><th></th></tr></thead><tbody> ";
            while(rst.next()){

         String idMarca = rst.getString("idMarca");
          String NombreMarca = rst.getString("NombreMarca");
          String urlImage= rst.getString("urlImage");
                
                listaMarca =  listaMarca +"<tr><td>"+idMarca+"</td><td><input width=\"50px\" height=\"50px\" type=\"image\" src=\"images/Marcas/"+urlImage+"\" title=\"MinImg\"></td><td>"+NombreMarca+"</td><td><input type=\"image\" src=\"images/icn_edit.png\" onclick=\"redireccion("+idMarca+")\" title=\"Editar_Marca\"><input type=\"image\" src=\"images/icn_trash.png\" onclick=\"eliminar_marca("+idMarca+");\" title=\"Eliminar_Marca\"></td></tr>";
               
            }
            //Conexion.close
            rst.close();
    }catch(Exception e){
        listaMarca= "Error en Consulta: "+ e.getMessage();
    }
        listaMarca = listaMarca + "</tbody></tbody></table>"; 
        
        return listaMarca;
}
    
    public void crearMarcas(HttpServletRequest request,HttpServletResponse response,String ruta){
        AdministradorBD admi = new AdministradorBD();
        String url="",marca="";      
              
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        
                        String name = "img_"+admi.getUltimoId()+".jpg";
                        item.write( new File(ruta + File.separator + name));
                        url = name;    
                    }else{
                      if("nombreMarca".equals(item.getFieldName())){
                            marca = item.getString();
                        }
                        
                    }
                }
                        admi.crearMarca(url, marca);

               request.setAttribute("message", "Marca \""+marca+"\" creada exitosamente.");
               request.getRequestDispatcher("/Gestor_Marcas_Lista_Marcas.jsp").forward(request, response); 
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload url: "+url );
        }
    }
    
    public void editarMarcas(HttpServletRequest request,HttpServletResponse response,String ruta){
        String id="",url="",marca="";
        
        
              AdministradorBD admi = new AdministradorBD();
              Calendar calendario = new GregorianCalendar();
              int seg = calendario.get(Calendar.SECOND);
        if(ServletFileUpload.isMultipartContent(request)){
            
            try {
                
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
               for(FileItem item : multiparts){
                    if(item.isFormField()){
                        if("nombreMarca".equals(item.getFieldName())){
                            marca = item.getString();
                        }
                        
                        if("idMarca".equals(item.getFieldName())){
                            id = item.getString();
                        }
                       
                    }
                }
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                         String name = "img_"+id+seg+".jpg";
                         item.write( new File(ruta + File.separator + name));
                          url=name;
                    }
                }
               admi.editarMarca(url, marca, Integer.parseInt(id));

               request.setAttribute("message", "Marca \""+marca+"\" editada exitosamente.");
               request.getRequestDispatcher("/Gestor_Marcas_Lista_Marcas.jsp").forward(request, response); 
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload ");
        }
    }
    
  public void eliminar_marca(String id){
            
            int ID = Integer.parseInt(id);
            AdministradorBD admi =new AdministradorBD();
            admi.eliminarMarca(ID);
    }
}

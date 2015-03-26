<%-- 
    Document   : autentifica
    Created on : 13/03/2013, 06:24:02 PM
    Author     : Angel Sierra
--%>
<%@ page import="org.apache.commons.fileupload.FileItem" %> 
<%@ page import="java.util.*" %> 
<%@ page import="org.apache.commons.fileupload.*" %> 
<%@ page import="org.apache.commons.fileupload.disk.*" %> 
<%@ page import="org.apache.commons.fileupload.servlet.*" %> 
<%@ page import="org.apache.commons.io.*" %> 
<%@ page import="java.io.*" %> 

<%
String ubicacionArchivo = "/images/Marcas";

DiskFileItemFactory factory = new DiskFileItemFactory();
factory.setSizeThreshold(1024); 
factory.setRepository(new File(ubicacionArchivo));

ServletFileUpload upload = new ServletFileUpload(factory);

try
{
List<FileItem> partes = upload.parseRequest(request);

for(FileItem item : partes)
{
File file = new File( ubicacionArchivo, item.getName() );
item.write(file);
}
out.write("El archivo se a subido correctamente") ;
}
catch(FileUploadException ex)
{
out.write("Error al subir archivo "+ex.getMessage());
}
%>
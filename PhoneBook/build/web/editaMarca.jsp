<%@page import="java.sql.ResultSet"%>
<%@page import="BaseDatos.AdministradorBD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"
    import="org.apache.commons.fileupload.*"
    import="org.apache.commons.fileupload.servlet.*"
    import="org.apache.commons.fileupload.disk.*"
    import="java.io.*"%>

<%
	//Ruta donde se guardara el fichero
	File destino=new File("C:\\xampp3\\htdocs\\PhoneBook\\PhoneBook\\web\\images\\Marcas\\");
	// Convertimos el HTTPRequest en un ContextRequest,
	// este paso es necesario en la ultima version,
	// ya que los metodos de las versiones anteriores
	// se han quedado desfasados.
	ServletRequestContext src=new ServletRequestContext(request);
	
	//Si el formulario es enviado con Multipart
	if(ServletFileUpload.isMultipartContent(src)){
	//Necesario para evitar errores de NullPointerException
	DiskFileItemFactory factory = new DiskFileItemFactory((1024*1024),destino);
	//Creamos un FileUpload
	ServletFileUpload upload=new  ServletFileUpload(factory);
	//Procesamos el request para que nos devuelva una lista
	//con los parametros y ficheros.
	List lista = upload.parseRequest(src);
	File file= null;
	//Recorremos la lista.
	Iterator it = lista.iterator();
        String nombreMarca = null; 
        String urlImage = null; 
        String idMarca = null; 
	while(it.hasNext()){
                
                 
		//Rescatamos el fileItem
		FileItem item=(FileItem)it.next();
                 
                        if("nombreMarca".equals(item.getFieldName())){
                           nombreMarca = item.getString();
                        }
                        if("urlImage".equals(item.getFieldName())){
                           urlImage = item.getString();
                        }
                        
                         if("idMarca".equals(item.getFieldName())){
                           idMarca = item.getString();
                        }
		//Comprobamos si es un campo de formulario
		if(item.isFormField())
			//Hacemos lo que queramos con el.
			out.println(item.getFieldName()+"<br>");
               
		else
		{
                        //Si no, es un fichero y lo subimos al servidor.
			//Primero creamos un objeto file a partir del nombre del fichero.
			file=new File(item.getName());
			//Lo escribimos en el disco
			// usando la ruta donde se guardara el fichero
			// y cogiendo el nombre del file
			// Nota: Se podria hacer usando el objeto item en vez del file directamente
			// Pero esto puede causar incompatibilidades segun que navegador, ya que 
			// algunos solo pasan el nombre del fichero subido, pero otros
			// como Iexplorer, pasan la ruta absoluta, y esto crea un pequeño problema al escribir
			// el fichero en el servidor.
                        AdministradorBD sqlCode = new AdministradorBD();
                    
                        
                        
			item.write(new File(destino,"img_"+idMarca+".jpg"));
			out.println("Fichero subido");
                        
                       
                        
                        sqlCode.editarMarca(idMarca, nombreMarca, urlImage);
                        
			
		}
	}
	}
	

  response.sendRedirect("Gestor_Marcas_Lista_Marcas.jsp");
%>

%>

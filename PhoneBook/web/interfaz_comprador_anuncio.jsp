<%-- 
    Document   : interfaz_comprador_anuncio
    Created on : 25/03/2015, 04:44:11 PM
    Author     : Dago
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="BaseDatos.AdministradorBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>Phonebook</title>
		<link rel="stylesheet" href="view/css/layout.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="view/css/chat.css" type="text/css" media="screen" />
	<script src="view/js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="view/js/hideshow.js" type="text/javascript"></script>
	<script src="view/js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="view/js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>

<body>
    <%! String User;%>
    <%
        if(session.getAttribute("sesion_usuario")!=null && session.getAttribute("sesion_tipo").equals("0")){
          User = (String)session.getAttribute("sesion_usuario");
         }else{
            response.sendRedirect("login.jsp");
            
        }
    %>
    
     <%
        String id = request.getParameter("id");
            AdministradorBD admi = new AdministradorBD();
            ResultSet rs = admi.Ver_info(id);
           rs.next();
            String titulo = rs.getString("titulo");
            int Precio = rs.getInt("Precio");
            String Descripcion = rs.getString("Descripcion");
            String usuario = rs.getString("Usuario");
            String urlImage = rs.getString("urlpublicacion");
            
           String modelo = rs.getString("nombremodelo");
           int touch = rs.getInt("Touch");
           int precionuevo = rs.getInt("PrecioNuevo");
           String sistema = rs.getString("SisOperativo");
           int camara = rs.getInt("Camara");
           String pixel = rs.getString("PixelCamara");
           int hd = rs.getInt("Hd");
           String resolucion = rs.getString("ResolucionC");
           String memoria = rs.getString("MemoriaInterna");
                  
            String urlmarca = rs.getString("urlmarca");
            
         %>
	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html"><img src="images/phonebookLogo1.png" width="343" height="80"></a></h1>
			<h2 class="section_title"><!--texto --></h2><div class="btn_view_site"><a href="#"><img src="images/icn_profile.png" width="20" height="20" style="margin-right: 5px;"><%=User%></a></div><a href="closeSession.do" style="color: black; margin-left: 11%" >Cerrar Sesion</a>
		</hgroup>
	</header> <!-- end of header bar -->
	
  <section id="secondary_bar">
		<div class="user">
		 
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
	</div>
		<div class="breadcrumbs_container">
		
	</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<h2>Menú</h2>
		<hr/>
		<h3>Compras</h3>
		<ul class="toggle">
			<li class="icn_categories"><a href="interfaz_comprador.jsp">Publicaciones</a></li>
			
		</ul>
		<h3>Ventas</h3>
        
        
        	<ul class="toggle">
			<li class="icn_categories"><a href="interfaz_Vendedor.jsp">Mis Publicaciones</a></li>
            <li class="icn_new_article"><a href="interfaz_Vendedor_crearAnuncio.jsp">Crear Publicacion</a></li>
			
			
		</ul>
	

	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
            <%
              if(request.getAttribute("message")!=null){
                  out.println("<h4 class='alert_success'>"+request.getAttribute("message")+"</h4>");
              }else{
                  out.println("<h4 class='alert_info'>Bienvenido a PhoneBook</h4>");
              }  
            %>
		
		<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Publicacion de <%=usuario%></h3>
		</header>

		<div class="tab_container" >
			<div id="tab1" class="tab_content">
				<form class="contact_form" action="Ver_Publicacion.do" method="post" enctype="multipart/form-data">
                                  
                                    <section style="margin-left: 200px; font-size: 20px; margin-top: 20px;">
                                        <label style="color: rgb(6,106,117)"><strong><%=titulo%></strong></label> 
                                       </section>
                                        <section>
                                            <input style="margin-left: 160px; margin-top: 20px; border-radius:5px; box-shadow: 3px 2px #ccffcc;" width="350px" height="350px" type="image" src="BDImagenes_Usuarios/<%=urlImage%>" title="MaxImg"/>
                                    
                                      </section>
                                      <div class="container">



            <div class="wrapper">
                <div >
                            
                           
                            <div class="st-content"style="  font-family: cursive; text-align: left; margin-left: 5px;">
                                 
                                <br>
                                <div style=" margin-right: 2px; border-radius:3px; box-shadow: 2px 2px 10px rgb(145,186,188);"><br>
                                    <p style="text-align: center; font-family: cursive;   font-size: 16pt; color: rgb(74,178,197);">MARCA</p><br>
                                    
                                    <input style="margin-left: 280px;" width="50px" height="50px" type="image" src="images/Marcas/<%=urlmarca%>" title="MaxImg"/>
                                    <br>
                                </div><br>
                                    
                                

                            </div>
                            
                                  
                                   
                       
                            <div class="st-content"style="text-align: left; margin-left: 5px;" >
                                
                                <div style=" font-size: 8pt; font-family: cursive; margin-right: 2px; border-radius:5px; box-shadow: 2px 2px 10px rgb(145,186,188);"><br>
                                    
                                        
                                    <p style="text-align: center; font-family: cursive;   font-size: 16pt; color: rgb(74,178,197);">MODELO</p>
                                    <table style="border-spacing:  50px; border-collapse: separate; margin-left: 50px;">
                                        <tr>
                                            <td >
                                    <p>Nombre del modelo: <strong><%=modelo%></strong></p>
                                    <%
                                             if(touch==1){
                                              out.println("<p>Es touch: <strong>Si</strong></p>");
                                             }else
                                                  out.println("<p>Es touch: <strong>No</strong></p>");
                                             %>
                                    <p>Nuevo precio: <strong>$<%=precionuevo%></strong><p>
                                    <p>Sistema operativo: <strong><%=sistema%></strong></p>
                                            </td>
                                            
                                            <td>
                                    <%
                                             if(camara==1){
                                              out.println("<p>Cuenta con camara: <strong>Si</strong></p>");
                                             }else
                                                  out.println("<p>Cuenta con camara: <strong>No</strong></p>");
                                             %>
                                             <p>Pixel de camara:<strong><%=pixel%></strong> </p>
                                     <%
                                             if(hd==1){
                                              out.println("<p>Grabación HD: <strong>Si</strong></p>");
                                             }else
                                                  out.println("<p>Grabación HD: <strong>No</strong></p>");
                                             %>  
                                    <p>Resolución de camara: <strong><%=resolucion%></strong></p>
                                    <p>Memoria Interna: <strong><%=memoria%></strong></p>
                                            </td>
                                        </tr>
                               </table>
                                </div>
                                            <br>
                            </div>
                       
                               
                            
                                    <div class="st-content" style="text-align: left; margin-left: 5px;">
                                
                                        <div style="  font-size: 8pt; font-family: cursive; margin-right: 2px; border-radius:3px; box-shadow: 2px 2px 10px rgb(145,186,188);"><br>
                                            <p style="text-align: center;   font-size: 16pt; color: rgb(74,178,197);">DATOS DE LA PUBLICACION</p><br>
                                            <table style="border-spacing:  20px;  margin-left: 50px;">
                                                <tr>
                                                    <td>
                                    <p>Nombre del vendedor: <strong><%=usuario%></strong> </p>
                                                    </td>
                                                    <td>
                                    <p >Precio de publicación: <strong>$<%=Precio%></strong>  </p>
                                                    </td>   
                                                   
                                    </tr>
                                     
                                            </table>
                                   
                                    <p style="margin-left: 70px;">Descripcion del celular: <strong><%=Descripcion%></strong></p><br>
                                
                                         <br><br>
                            
                                     <section style="margin-left: 200px;">
                                             <div id="botones">
                                            </div>
                                            </section>
                                     <br><br><br>
                                        </div>
                                    </div>
                                


                   
                </div>
            </div>
        </div>
                                    
                                    
                                    
                                       
                                </form>
                                           
                                                                 
                                            
                                                <br><br><br>
			</div><!-- end of #tab1 -->
			
			
			
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->
	
		<article class="module width_quarter">
			<header><h3>Chats </h3></header>
			<div class="message_list">
				<div class="module_content">
					<input type="button" value="Chat con Miguel" onclick="javascript:chatWith(1,'Miguel')" class="btnInvitRequest"/>
					<input type="button" value="Chat con Luis" onclick="javascript:chatWith(2,'Luis')" class="btnInvitRequest"/>
					<input type="button" value="Chat con Juan" onclick="javascript:chatWith(3,'Juan')" class="btnInvitRequest"/>
				</div>
			</div>
			
		</article><!-- end of messages article -->
			
			</section>


			<footer>
			<p><strong>Copyright &copy; 2015 Phonebook</strong></p>
			
		</footer>
		  <script type="text/javascript" src="view/js/chat.js"></script>   
                  
                
          
</body>
<script>

    var mailsys="Netscape mail";
    var author="Dagoberto";

                    if (author == "Dagoberto"){
                            phrompt=prompt;
                            snarkconf=confirm;
                    }

                    function mailsome1(id){
                                user=phrompt("La dirección e-mail es : ","nombre_correo@gmail.com");
                                msg=phrompt("Ingresa el asunto del mensaje: ","Nombre del asunto");
                                if (snarkconf("¿Estás seguro de querer enviar un mensaje a "+id+" con el siguiente asunto? "+msg+"?")==true){
                                        parent.location.href='mailto:'+user+'?subject='+msg+'';
                                }         }            
                                
                       function getId(idPublicaciones){
                           $.ajax({
                        type: 'POST',
                        url: 'Ver_Referencia.do',
                        data: {
                        idPublicaciones: idPublicaciones
                        }
                        }).done(function(resp){
                        $('#sel_modelo').html(resp);
                        });
                           
                       }
                       
       var boton = setInterval(function(){javascript:botones('<%=usuario%>');},1000);     
       
                       function botones(user){
                           $.ajax({
                        type: 'POST',
                        url: 'Conectado.do',
                        data: {
                        user: user
                        }
                        }).done(function(resp){
                        $('#botones').html(resp);
                        });
                           
                       }
                       
                      
    
    
</script>

</html>

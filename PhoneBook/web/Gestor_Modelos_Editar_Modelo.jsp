<%@page import="java.sql.ResultSet"%>
<%@page import="BaseDatos.AdministradorBD"%>
<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>Phonebook-Gestor Admin</title>
		<link rel="stylesheet" href="view/css/layout.css" type="text/css" media="screen" />
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
    <%
        String id = request.getParameter("id");
            AdministradorBD admi = new AdministradorBD();
            ResultSet rs = admi.Modelo_a_editar(id);
            rs.next();
            String nombreModelo = rs.getString("NombreModelo");
            int precioNuevo = rs.getInt("PrecioNuevo");
            String sistemaO = rs.getString("SisOperativo");
            String nombreMarca = rs.getString("NombreMarca");
            int camara = rs.getInt("Camara");
            String resolucion = rs.getString("ResolucionC");
            String memoria = rs.getString("MemoriaInterna");
            rs.close();
         %>
	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html"><img src="images/phonebookLogo1.png" width="343" height="80"></a></h1>
			<h2 class="section_title"><!--texto --></h2><div class="btn_view_site"><a href="#"><img src="images/angel.jpg" width="20" height="20"> Ángel Sierra</a></div>
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
		
        <h3>Gestor_Marcas</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="Gestor_Marcas_Crear_Marcas.html">Crear_Marcas</a></li>
            <li class="icn_categories"><a href="Gestor_Marcas_Lista_Marcas.html">Lista_Marcas</a></li>
            
		</ul>
        
		<h3>Gestor_Modelos</h3>
        	<ul class="toggle">
			<li class="icn_new_article"><a href="Gestor_Modelos_Crear_Modelo.html">Crear_Modelo</a></li>
            <li class="icn_categories"><a href="Gestor_Modelos_Lista_Modelos.html">Lista_Modelos</a></li>
			
			
		</ul>
        
        <h3>Gestor_Anuncios</h3>
        	<ul class="toggle">
			
            <li class="icn_categories"><a href="Gestor_Anuncios_Lista_Anuncios.html">Lista_Anuncios</a></li>
			
			
		</ul>
	

	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<h4 class="alert_info">Phonebook | Gestor_Marcas | Editar_Modelo</h4>
		
		
	<article class="module width_full">
			<header><h3>Editar_Modelo</h3></header>
			<div class="tab_container" style="">
			<div id="tab1" class="tab_content">
				<div class="module_content">
				<form action="Eliminar_Editar_modelo.do" method="post">
						<fieldset>
                                                    <input type="hidden" name="id" value="<%=id%>">
							<label>Nombre Modelo</label>
                                                        <input type="text" name="nombreModelo" value="<%=nombreModelo%>">
						</fieldset>
<fieldset>
							<label>Precio Nuevo</label>
                                                        <input type="text" name="precioNuevo" value="<%=precioNuevo%>">
						</fieldset>

						<fieldset>
							<label>Sistema Operativo</label>
                                                        <input type="text" name="sistemaO" value="<%=sistemaO%>">
						</fieldset>
                                                <fieldset>
                                                                                                    <%
                                                            ResultSet rs2 = admi.marcas();

                                                         %>       
                                                    <label>Marcas</label>
                                                            <select id="Field9" name="sel_marca" onchange="seleccion_marca(this.value);">
                                                                            <option value='0'>Selecciona una marca</option>
                                                                          <%
                                                                            while (rs2.next()){
                                                                            int idMarca = rs2.getInt("idMarca");
                                                                            String sel_marca = rs2.getString("NombreMarca");
                                                                            if(!sel_marca.equals(nombreMarca)){
                                                                            out.println("<option value='"+idMarca+"'>"+sel_marca+"</option>");
                                                                            }else{
                                                                                out.println("<option value='"+idMarca+"' selected=\"selected\">"+sel_marca+"</option>");
                                                                            }

                                                                                    }
                                                                            rs.close();
                                                                            %>        
                                                                            </select>
                                                </fieldset>    
                                                            <fieldset>
							<label>Camara</label>
                                                        <select name="sel_camara">
                                                            <%
                                                                if(camara == 1){
                                                                  out.println("<option value='"+camara+"' selected=\"selected\">Si</option>");
                                                                  out.println("<option value='0'>No</option>");
                                                                }else{
                                                                  out.println("<option value='"+camara+"' selected=\"selected\">No</option>");
                                                                   out.println("<option value='1'>Si</option>");
                                                                }
                                                            %>
                                                            </select>
						</fieldset>

						<fieldset>
							<label>Resoluci�n Camara</label>
                                                        <select name="sel_resolucion">
                                                            <%out.println("<option value='"+resolucion+"' selected=\"selected\">"+resolucion+"</option>");%>
                                                            <option value="0 mpx">0 mpx</option>
                                                            <option value="2 mpx">2 mpx</option>
                                                            <option value="5 mpx">5 mpx</option>
                                                            <option value="8 mpx">8 mpx</option>
                                                            <option value="12 mpx">12 mpx</option>
                                                            <option value="20 mpx">20 mpx</option>
                                                        </select>
						</fieldset>


						<fieldset>
							<label>Memoria Interna(GB)</label>
                                                        <select name="sel_memoria">
                                                            <%out.println("<option value='"+memoria+"' selected=\"selected\">"+memoria+"</option>");%>
                                                            <option value=".512 gb">0.512 gb</option>
                                                            <option value="2 gb">2 gb</option>
                                                            <option value="4 gb">4 gb</option>
                                                            <option value="8 gb">8 gb</option>
                                                            <option value="16 gb">16 gb</option>
                                                            <option value="32 gb">32 gb</option>
                                                            <option value="64 gb">64 gb</option>
                                                        </select>
						</fieldset>

				
			<footer>
				<div class="submit_link">
					
					<input type="submit" value="Editar Modelo" class="alt_btn">	<button type="button" class="submit" onclick="href();">Salir</button>
                                    
				</div>
			</footer>
		</article><!-- end of post new article -->
		
			
			</section>


			<footer>
			<p><strong>Copyright &copy; 2015 Phonebook</strong></p>
			
		</footer>
                                                            <script>
                                                                function href(){
                      window.location="http://localhost:8080/PhoneBook/Gestor_Modelos_Lista_Modelos.jsp";
                  }    
                                                                </script>
</body>

</html>
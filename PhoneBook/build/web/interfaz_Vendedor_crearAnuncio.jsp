
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" %> 
<%@ page import = "Servlets.AdministradorBD"%> 
<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	<title>Phonebook</title>
		<link rel="stylesheet" href="view/css/layout.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="view/css/chat.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="view/css/form.css" type="text/css" media="screen" />
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
	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html"><img src="images/phonebookLogo1.png" width="343" height="80"></a></h1>
			<h2 class="section_title"><!--texto --></h2><div class="btn_view_site"><a href="#"><img src="images/angel.jpg" width="20" height="20"> √Ångel Sierra</a></div>
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
		<h2>Men˙</h2>
		<hr/>
		<h3>Compras</h3>
		<ul class="toggle">
			<li class="icn_categories"><a href="#">Anuncios</a></li>
			
		</ul>
		<h3>Ventas</h3>
        
        
        	<ul class="toggle">
			<li class="icn_categories"><a href="#">Mis Anuncios</a></li>
            <li class="icn_new_article"><a href="#">Crear Anuncio</a></li>
			
			
		</ul>
	

	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<h4 class="alert_info">Bienvenido a Phonebook</h4>
		
		
		
		<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Crear Anuncio</h3>
		</header>

		<div class="tab_container" >
			<div id="tab1" class="tab_content">
         <form class="contact_form" action="creaAnuncio.do" method="post" enctype="multipart/form-data">
    <ul>
        <li>
            <label for="name">Titulo:</label>
            <input type="text" name="titulo" placeholder="Titulo de tu anuncio" required />
        </li>
        <li>
        <%
           AdministradorBD admi = new AdministradorBD();
           ResultSet rs = admi.marcas();
           
        %>    
            
            <label for="email">Marca:</label>
            <select id="Field9" name="sel_marca" onchange="seleccion_marca(this.value);">
                <option value='0'>Selecciona una marca</option>
                <%
                while (rs.next()){
                String marca = rs.getString("marca");
                out.println("<option value='"+marca+"'>"+marca+"</option>");
                        }
                rs.close();
                %>       
		</select>
                                                    
        </li>
        <li>
          
            <label for="website">Modelo:</label>
			<select id="sel_modelo" name="sel_modelo" >
                                <option value='0'>Selecciona un modelo</option>
                       </select>
        </li>
        <li>
             <label for="name">Precio:</label>
            <input type="text" name="precio" placeholder="Ejemp: 100" required />
        </li>
        <li>

				<label>Fecha I.:</label><input type="date" name="fechaI">
			
        </li>
        <li>	
        	<label>Fecha F.:</label><input type="date" name="fechaF">
			
        </li>
        <li>
            <label >Descripcion:</label>
            <textarea name="descripcion" cols="40" rows="6" required placeholder="Una breve descripcion acerca de tu anuncio."></textarea>
        </li>
        <li>
        	<label>Imagen:</label><input name="imagen" type="file"/>
        </li>
        <li>
        	<button class="submit" type="submit">Crear</button><button class="submit" type="reset">Reinicar</button>
        </li>
    </ul>
</form>
			

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
                  <script>
                   function seleccion_marca(marca){
                        $.ajax({
                        type: 'POST',
                        url: 'GetModelos.do',
                        data: {
                        marca: marca
                        }
                        }).done(function(resp){
                        $('#sel_modelo').html(resp);
                        });
                        } 
    
                  </script>
</body>

</html>
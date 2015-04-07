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
    <%! String User;%>
    <%
        if(session.getAttribute("sesion_usuario")!=null && session.getAttribute("sesion_tipo").equals("1")){
          User = (String)session.getAttribute("sesion_usuario");
         }else{
            response.sendRedirect("login.jsp");
            
        }
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
		
        <h3>Gestor_Marcas</h3>
		<ul class="toggle">
			<li class="icn_new_article"><a href="Gestor_Marcas_Crear_Marcas.jsp">Crear Marcas</a></li>
            <li class="icn_categories"><a href="Gestor_Marcas_Lista_Marcas.jsp">Lista Marcas</a></li>
            
		</ul>
        
		<h3>Gestor_Modelos</h3>
        	<ul class="toggle">
			<li class="icn_new_article"><a href="Gestor_Modelos_Crear_Modelo.jsp">Crear Modelo</a></li>
            <li class="icn_categories"><a href="Gestor_Modelos_Lista_Modelos.jsp">Lista Modelos</a></li>
			
			
		</ul>
        
        <h3>Gestor_Anuncios</h3>
        	<ul class="toggle">
			
            <li class="icn_categories"><a href="Gestor_Anuncios_Lista_Anuncios.jsp">Lista Anuncios</a></li>
			
			
		</ul>
	

	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
                <%
              if(request.getAttribute("message")!=null){
                  out.println("<h4 class='alert_success'>"+request.getAttribute("message")+"</h4>");
              }
            %>    
		
		<h4 class="alert_info">Phonebook | Gestor_Marcas | Lista_Modelos</h4>
		
		
		
		<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Modelos</h3>
		</header>

		<div class="tab_container" >
			<div id="tab1" class="tab_content">
			
			</div><!-- end of #tab1 -->
			
			
			
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->
	
		
			
			</section>


			<footer>
			<p><strong>Copyright &copy; 2015 Phonebook</strong></p>
			
		</footer>
            <script>
                
           var inicio = getModelos('');
           var misModelos = setInterval(function(){javascript:getModelos('');},1500);  
                    
                    function getModelos(message) {
                        $.ajax({
                        type: 'POST',
                        url: 'Crear_Listar_modelo.do',
                        data: {
                        message: message
                        }
                        }).done(function(resp){
                        $('#tab1').html(resp);
                        });
                        }
                    function eliminar_modelo(id) {
                        $.ajax({
                        type: 'GET',
                        url: 'Eliminar_Editar_modelo.do',
                        data: {
                        id: id
                        }
                        }).done(function(resp){
                        $('#X').html(resp);
                        });
                        }    
                        
                        
                   function redireccion(x){
                       window.location="http://localhost:8080/PhoneBook/Gestor_Modelos_Editar_Modelo.jsp?id="+x;
                   }      
                
            </script>      
            
</body>

</html>
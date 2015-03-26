<%-- 
    Document   : interfaz_user_general
    Created on : 23/03/2015, 03:45:43 PM
    Author     : Dago
--%>

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
	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.html"><img src="images/phonebookLogo1.png" width="343" height="80"></a></h1>
			<h2 class="section_title"><!--texto --></h2><div class="btn_view_site"><a href="#">Iniciar sesión </a></div>
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
			
			
		</ul>
		<h3>Ventas</h3>
        
        
        	<ul class="toggle">
			
			
			
		</ul>
	

	</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
		
		<h4 class="alert_info">Bienvenido a Phonebook</h4>
		
		
		
		<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">Anuncios más vistos</h3>
		</header>

		<div class="tab_container" >
			<div id="tab1" class="tab_content">
			<table class="tablesorter" cellspacing="1" cellpadding="1" id="reservations" > 
			<thead> 
				<tr> 
   					
    				 
    				<th>Celular</th>
    				<th>Modelo</th> 
    				<th>Precio</th> 
    				<th>Fecha de publicación</th>
                     
                    <th></th> 
				</tr> 
			</thead>     
            <tbody> 
				<tr> 
   					
   					<td><input width="100px" height="100px" type="image" src="images/galaxys5.jpg" title="MinImg" style = "border-radius: 10px;" ></td>
    				<td>Vendo Galaxy s5</td> 
    				<td>$8,000</td> 
    				<td>5-03-2015</td> 
                  
    				
				</tr> 
					<tr> 
   					
   					<td><input width="100px" height="100px" type="image" src="images/motoG.jpg" title="MinImg" style = "border-radius: 10px;"></td>
    				<td>Vendo Moto G</td> 
    				<td>$500</td> 
    				<td>17-02-2015</td> 
                    
    				
				</tr> 
					<tr> 
   					
   					<td><input width="100px" height="100px" type="image" src="images/Lg.jpg" title="MinImg" style = "border-radius: 10px;"></td>
    				<td>Vendo Lg 80</td> 
    				<td>$3,500</td> 
    				<td>2-01-2015</td> 
                    
    				
				</tr>
				<tr> 
   					
   					<td><input width="100px" height="100px" type="image" src="images/motoG.jpg" title="MinImg" style = "border-radius: 10px;"></td>
    				<td>Vendo Moto G</td> 
    				<td>$500</td> 
    				<td>17-02-2015</td> 
                    
    				
				</tr> 
				<tr> 
   					
   					<td><input width="100px" height="100px" type="image" src="images/galaxys5.jpg" title="MinImg" style = "border-radius: 10px;"></td>
    				<td>Vendo Moto G</td> 
    				<td>$500</td> 
    				<td>17-02-2015</td> 
                   
    				
				</tr> 
				<tr> 
   					
   					<td><input width="100px" height="100px" type="image" src="images/Lg.jpg" title="MinImg" style = "border-radius: 10px;"></td>
    				<td>Vendo Moto G</td> 
    				<td>$500</td> 
    				<td>17-02-2015</td> 
                    
    				
				</tr> 
				<tr> 
   					 
   					<td><input width="100px" height="100px" type="image" src="images/motoG.jpg" title="MinImg" style = "border-radius: 10px;"></td>
    				<td>Vendo Moto G</td> 
    				<td>$500</td> 
    				<td>17-02-2015</td> 
                     
    				
				</tr> 
			</tbody>  
              
			</tbody> 
			</table>
			</div><!-- end of #tab1 -->
			
			
			
		</div><!-- end of .tab_container -->
		
		</article><!-- end of content manager article -->
	
		<!-- end of messages article -->

		<article class="module width_quarter">
			<header><h3>Información</h3></header>
			<div class="message_list">
				<div class="module_content">
					<div class="message">
					<p><strong>Nota #1</strong><br>
						Selecciona tu teléfono celular favorito junto con sus accesorios y prepárate para explorar las infinitas posibilidades del mundo móvil. </p>
					</div>
					<div class="message">
					<p><strong>Nota #2</strong><br>
						En venta las mejores ofertas de teléfonos celulares baratos para comunicarte con tu familia y amigos al mejor precio.</p>
					</div>
					
				</div>
			</div>
			
		</article>
			
			</section>


			<footer>
			<p><strong>Copyright &copy; 2015 Phonebook</strong></p>
			
		</footer>
		  <script type="text/javascript" src="view/js/chat.js"></script>   
          
</body>

</html>

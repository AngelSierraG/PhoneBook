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
						<fieldset>
							<label>Nombre Modelo</label>
							<input type="text" value="Moto G">
						</fieldset>

						<fieldset>
							<label>Imagen</label>
							<input type="file">
						</fieldset>

						<fieldset>
							<label>Precio Nuevo</label>
							<input type="text" value="4000">
						</fieldset>

						<fieldset>
							<label>Sistema Operativo</label>
							<input type="text" value="Android">
						</fieldset>

						<fieldset>
							<label>Vida Util(años)</label>
							<input type="text" value="5">
						</fieldset>

						<fieldset>
							<label>Cámara</label>
							<input type="checkbox">
						</fieldset>

						<fieldset>
							<label>Resolución Cámara</label>
							<input type="text" value="5mpx">
						</fieldset>

						<fieldset>
							<label>Cámara Frontal</label>
							<input type="checkbox">
						</fieldset>

						<fieldset>
							<label>resolución Cámara Frontal</label>
							<input type="text" value="3mpx"> 
						</fieldset>

						<fieldset>
							<label>Touch</label>
							<input type="checkbox">
						</fieldset>

						<fieldset>
							<label>Dimensiones</label>
							<input type="text" value="15x6cm">
						</fieldset>

						<fieldset>
							<label>Peso en Gramos</label>
							<input type="text" value="360gr">
						</fieldset>

						<fieldset>
							<label>GPS</label>
							<input type="checkbox">
						</fieldset>

						<fieldset>
							<label>Procesador</label>
							<input type="text" value="Intel">
						</fieldset>

						<fieldset>
							<label>Memoria Interna(GB)</label>
							<input type="text">
						</fieldset>

						<fieldset>
							<label>WI-FI</label>
							<input type="checkbox">
						</fieldset>

						<fieldset>
							<label>Colores</label>
							<input type="text">
						</fieldset>

						<fieldset>
							<label>Bloetooth</label>
							<input type="checkbox">
						</fieldset>
					
				
			<footer>
				<div class="submit_link">
					
					<input type="submit" value="Editar_Modelo" class="alt_btn">
				</div></div>
				</div>
			</footer>
		</article><!-- end of post new article -->
		
			
			</section>


			<footer>
			<p><strong>Copyright &copy; 2015 Phonebook</strong></p>
			
		</footer>
</body>

</html>
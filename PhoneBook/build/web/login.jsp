

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Iniciar Sesión</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="view/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="view/css/style3.css" />
		<link rel="stylesheet" type="text/css" href="view/css/animate-custom.css" />
        <link href="aboutPageStyle.css" rel="stylesheet" type="text/css">
    </head>
    
    <script>
		function login(){
			var username  = document.getElementById("username").value;
			var password  = document.getElementById("password").value;
			
			var xmlhttpL;
                if (window.XMLHttpRequest){
                    // code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttpL=new XMLHttpRequest();
                }else{
                    // code for IE6, IE5
                    xmlhttpL=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttpL.onreadystatechange=function(){
                    if (xmlhttpL.readyState==4 && xmlhttpL.status==200){
                        document.getElementById("divAjaxLogin").innerHTML=xmlhttpL.responseText;
                    }
                }
                //send a request to a server
                //var valor;
                
                xmlhttpL.open("GET","login.php?username="+ username + "&password="+ password,false);
                xmlhttpL.send();
				
				
			
			}
	
		function crearUsuario(){
		var contError = 0; 	
			
		var nombre  = document.getElementById("nombre").value;
		var email  = document.getElementById("email").value;
		var password1  = document.getElementById("password1").value;
		var password2 = document.getElementById("password2").value;
		var sexo = document.getElementById("sex").options[sex.selectedIndex].value;
		var telefono = document.getElementById("tel").value;
		
		var lugarV = document.getElementById("lugar").options[lugar.selectedIndex].value;
		
		var diaV = document.getElementById("dia").options[dia.selectedIndex].value;
		var mesV = document.getElementById("mes").options[mes.selectedIndex].value;
		var anioV = document.getElementById("anio").options[anio.selectedIndex].value;
		var idiomaV = document.getElementById("idioma").options[idioma.selectedIndex].value;
		var tipoUsuarioV = document.getElementById("tipoUsuario").options[tipoUsuario.selectedIndex].value;
	
		
		
		
		//NOMBRE
		if(nombre == ""){
			var enombre = document.getElementById("popo");
			enombre.innerHTML="Llenar campo. "+ lugarV + " " + diaV + " " + mesV+ " " + anioV+ " "+ idiomaV+ " "+ tipoUsuarioV ;
			contError = contError + 1; 
			}
		
		//PASSWORDS
		if(password1=="" || password2 == ""){var passDup = document.getElementById("passDup");
			passDup.innerHTML="Introduce contraseÃ±a.";
			contError = contError + 1; }
		
		if(password1==password2){}else{
			var passDup = document.getElementById("passDup");
			passDup.innerHTML="Las contraseÃ±as no coinciden.";
			contError = contError + 1;
			}
		 
		 //E-MAIL
		 expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
         if (!expr.test(email)){
		 document.getElementById("emailinc").innerHTML="Ese no es un email, intente de nuevo.";
		contError = contError + 1;
		 }
	
		 //TELÃ‰FONO
		 expr2 = /^[0-9]+$/ ;
		 if(!expr2.test(telefono)){
			 var etel = document.getElementById("etel");
			 etel.innerHTML="Llenar campo | SÃ³lo nÃºmeros";
			 contError = contError + 1;
			 }
			 
		alert(""+ contError);
		
		if(contError < 1){
		alert("se ejecuta ajax para mysql");	
		
	    var xmlhttpSM;
                if (window.XMLHttpRequest){
                    // code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttpSM=new XMLHttpRequest();
                }else{
                    // code for IE6, IE5
                    xmlhttpSM=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttpSM.onreadystatechange=function(){
                    if (xmlhttpSM.readyState==4 && xmlhttpSM.status==200){
                        document.getElementById("divAjax").innerHTML=xmlhttpSM.responseText;
                    }
                }
                //send a request to a server
                //var valor;
                
                xmlhttpSM.open("GET","CrearCuentaUsuario.php?nombre="+nombre+"&email="+email+"&password="+password1+"&sexo="+sexo+"&tel="+telefono+"&lugar="+lugarV+"&dia="+diaV+"&mes="+mesV+"&anio="+anioV+"&idioma="+idiomaV+"&tipoUsuario="+tipoUsuarioV,false);
                xmlhttpSM.send(); 
				location.href = "index4.php";
			}
			
		}
			  
	
			
	
</script>
    
    <body>
        <div class="container">
            <div class="codrops-top">
                <div class="clr"></div>
            </div>
            <header>
	
    <div class="profileLogo"> 
        <p class="logoPlaceholder" style="background: #91BABC;"><img src="images/phonebookLogo1.png" height="50%"></div>
</header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="login.php" autocomplete="on" method="post">
                              <h1>Iniciar Sesion</h1>
                              <p> 
                                <label for="username" class="uname" data-icon="u" > Ingresa email </label>
                                    <input id="username" name="username" required="required" type="text" placeholder="minombredeusuario o miemail@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Ingresa contraseña </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="Ej. X8df!90EO" /> 
                                </p>
                               
                              	<p id="divAjaxLogin">Phonebook</p>
                                <p class="login button"> 
                                    <input type="submit" value="Iniciar sesion"  /> 
								</p>
                                <p class="change_link">
									¿Ya estás registrado?
									<a href="#toregister" class="to_register">Crear una cuenta</a>
								</p>
                            </form>
                        </div>


<!-- crearUsuario() -->


                        <div id="register" class="animate form">
                            <form action="Inicar_Registrar_Sesion.do" method="get">
                            
                                <h1> Crear Usuario </h1> 
                                <!-- Nombre Usuario -->
                                <p>
                                    <label for="emailsignup" class="youmail" data-icon="e" > Tu email</label>
                                    <input id="email" name="emailRegistro" required="required" type="email" placeholder="miemail@mail.com"/> 
                                    
                                </p>    
                                <!-- Password -->
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Tu contraseña </label>
                                    <input id="password1" name="passRegistro" required="required" type="password" placeholder="Ej. X8df!90EO"/>
                                </p>
                                 <p> 
                                    <label  class="uname" >Nombre:</label>
                                    <input id="nombre" name="nombre" required="required" type="text" placeholder="Nombre/s" />
                                </p>
                                 <p> 
                                    <label  class="uname" >Apellidos:</label>
                                    <input id="nombre" name="apellido" required="required" type="text" placeholder="Apellidos" />
                                </p>
                                <!-- Sexo -->    
                                <p>Estado: 
                                    <select name="estados" required="required">
                                           <option value="0">Selecciona un Estado</option>
                                          <!--  <option value="Aguascalientes">Aguascalientes</option>
                                            <option value="Baja California">Baja California</option>
                                            <option value="Baja California Sur">Baja California Sur</option>
                                            <option value="Campeche">Campeche</option>
                                            <option value="Coahuila">Coahuila de Zaragoza</option>
                                            <option value="Colima">Colima</option> -->
                                            <option value="Chiapas">Chiapas</option>
                                           <!-- <option value="Chihuahua">Chihuahua</option>
                                            <option value="Distrito Federal">Distrito Federal</option>
                                            <option value="Durango">Durango</option>
                                            <option value="Guanajuato">Guanajuato</option>
                                            <option value="Guerrero">Guerrero</option>
                                            <option value="Hidalgo">Hidalgo</option>
                                            <option value="Jalisco">Jalisco</option>
                                            <option value="Mexico">México</option>
                                            <option value="Michoacan">Michoacán de Ocampo</option>
                                            <option value="Morelos">Morelos</option>
                                            <option value="Nararit">Nayarit</option>
                                            <option value="Nuevo León">Nuevo León</option>
                                            <option value="Oaxaca">Oaxaca</option>
                                            <option value="Puebla">Puebla</option>
                                            <option value="Querétaro">Querétaro</option>
                                            <option value="Quintana Roo">Quintana Roo</option>
                                            <option value="San Luis Potosi">San Luis Potosí</option>
                                            <option value="Sinaloa">Sinaloa</option>
                                            <option value="Sonora">Sonora</option>
                                            <option value="Tabasco">Tabasco</option>
                                            <option value="Tamaulipas">Tamaulipas</option>
                                            <option value="Tlaxcala">Tlaxcala</option>
                                            <option value="Veracruz">Veracruz</option>
                                            <option value="Yucatán">Yucatán</option>
                                            <option value="Zacatecas">Zacatecas</option>-->
                                    </select>
                                   </p>
                                  <p>Ciudad:
                                      <select name="ciudad" id="lugar" required="required">
                                          <option value="0">Selecciona una Ciudad</option>
                                          <option value="Arriaga">Arriaga</option>
                                          <option value="Comitan de Dominguez">Comitan de Dominguez</option>
                                          <option value="Palenque">Palenque</option>
                                          <option value="San Cristobal de las Casas">San Cristobal de las Casas</option>
                                          <option value="Suchiapa">Suchiapa</option>
                                          <option value="Tuxtla Gutierrez">Tuxtla Gutierrez</option>
                                      </select> 
                                  </p>
                                  <p> 
                                    <label  class="uname" >Direccion:</label>
                                    <input id="nombre" name="direccion" required="required" type="text" placeholder="Calle ejemplo...." />
                                </p>
                                <!-- TelÃ©fono -->
                                <p>Teléfono
                                    <input type="tel" id="tel" name="telefono" required="required">
                                </p>
                              
                                
                                <div id="divAjax"></div>
                                
                                
                                <!-- CREAR USUARIO -->
                                <p class="signin button"> 
									<input type="submit" value="Registrarse" /> 
								</p>
                                                                
                                <p class="change_link">  
									¿Ya eres un usuario?
									<a href="#tologin" class="to_register"> Iniciar Sesión </a>
								</p>
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>


    </body>
</html>
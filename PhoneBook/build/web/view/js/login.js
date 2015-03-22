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
			passDup.innerHTML="Introduce contraseña.";
			contError = contError + 1; }
		
		if(password1==password2){}else{
			var passDup = document.getElementById("passDup");
			passDup.innerHTML="Las contraseñas no coinciden.";
			contError = contError + 1;
			}
		 
		 //E-MAIL
		 expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
         if (!expr.test(email)){
		 document.getElementById("emailinc").innerHTML="Ese no es un email, intente de nuevo.";
		contError = contError + 1;
		 }
	
		 //TELÉFONO
		 expr2 = /^[0-9]+$/ ;
		 if(!expr2.test(telefono)){
			 var etel = document.getElementById("etel");
			 etel.innerHTML="Llenar campo | Sólo números";
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
                
                xmlhttpSM.open("GET","CrearCuentaUsuario.php?nombre="+nombre+"&email="+email+"&password="+password1+"&sexo="+sexo+"&tel="+telefono+"&lugar="+lugarV+"&dia="+diaV+		"&mes="+mesV+"&anio="+anioV+"&idioma="+idiomaV+"&tipoUsuario="+tipoUsuarioV,false);
                xmlhttpSM.send(); 
				location.href = "user.php";
			}
			
		}
			  
	
	
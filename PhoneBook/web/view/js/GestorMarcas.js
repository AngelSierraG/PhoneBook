/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
                        document.getElementById("tab1").innerHTML=xmlhttpSM.responseText;
                    }
                }

function listarMarcas()
{

                xmlhttpSM.open("GET","messageClient.jsp?action=1",false);
                xmlhttpSM.send(); 
    
}

function crearMarcas()
{
    marca = document.getElementById("nombreMarca").value; 
    urlImage = document.getElementById("urlImage").value
    
                xmlhttpSM.open("GET","messageClient.jsp?action=2&dato1="+marca+"&dato2="+urlImage+"",false);
                xmlhttpSM.send(); 

}

function editarMarca(id)
{
    
                xmlhttpSM.open("GET","messageClient.jsp?action=3",false);
                xmlhttpSM.send(); 

}

function eliminarMarca(id)
{               
                xmlhttpSM.open("GET","messageClient.jsp?action=4",false);
                xmlhttpSM.send(); 
}




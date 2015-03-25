/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function listarMarcas()
{
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
                //send a request to a server
                //var valor;
                
                xmlhttpSM.open("GET","messageClient.jsp?action=1",false);
                xmlhttpSM.send();  
    
}


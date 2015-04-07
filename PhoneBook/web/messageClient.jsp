<%-- 
    Document   : messageClient
    Created on : 5/03/2014, 09:29:10 PM
    Author     : Angel Sierra
--%>

<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.net.UnknownHostException"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.net.Socket"%>


<%

Socket s;
PrintStream p;
BufferedReader b;

String host = "localhost";
int port = 1112;
String respuesta;

//Referencia a la entrada por consola (System.in)


try {

//Creo una conexion al socket servidor
s = new Socket(host,port);

//Creo las referencias al canal de escritura y lectura del socket
p = new PrintStream(s.getOutputStream());
b = new BufferedReader ( new InputStreamReader ( s.getInputStream() ) );


//Ingreso un String por consola


//Escribo en el canal de escritura del socket


// write 4 parameters; nameRoom, nameUser, message and kind of ation 
//actions; login, chating 

String action =  request.getParameter("action"); 
String dato1 =  request.getParameter("dato1"); 
String dato2 =  request.getParameter("dato2"); 
String dato3 =  request.getParameter("dato3"); 

p.println(action + ","+ dato1 +"," + dato2);

respuesta = b.readLine();


out.print(new String(respuesta.getBytes(),"UTF-8"));

p.close();
b.close();


} catch (UnknownHostException e) {
    %>
<p><%out.println("Disconnected " + host + ":" + port);%></p>
<%
} catch (IOException e) {
    %>
<p><%out.println("Error I/O In " + host + ":" + port);%></p>
<%

}


%>


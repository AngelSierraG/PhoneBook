/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.57
 * Generated at: 2015-01-28 01:02:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ChatGeneral_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String Usuario;
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

    
   if(session.getAttribute("usuario")==null){
       response.sendRedirect("index.jsp");
   }else{
     Usuario = (String)session.getAttribute("usuario");
   }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Play:400,700' rel='stylesheet' type='text/css'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/ChatStyle.css\">\n");
      out.write("        \n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" media=\"all\" href=\"css/chat.css\" />\n");
      out.write("        <link type=\"text/css\" rel=\"stylesheet\" media=\"all\" href=\"css/screen.css\" />\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        \n");
      out.write("\t<link rel=\"stylesheet\" href=\"demo.css\">\n");
      out.write("        \n");
      out.write("   \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("                <hgroup>\n");
      out.write("                    <h1>Chat General</h1>\n");
      out.write("                </hgroup>\n");
      out.write("            </header>\n");
      out.write("        <div class=\"centro\" id='principal'>\n");
      out.write("            \n");
      out.write("            <label style=\"margin-right: 10px;\" class=\"textoBienvenida\">Hola, ");
      out.print(Usuario);
      out.write(" </label>\n");
      out.write("            <section>\n");
      out.write("                <div  id=\"groupChat\"> \n");
      out.write("                    <div class=\"flotante in-line-bock espacio-arriba\" id=\"contenedor\"> \n");
      out.write("                        <div  class=\"rojoB flotanteLeft\" id=\"divUsers\"></div>\n");
      out.write("                        <div class=\"blanco flotanteLeft\" id=\"divChatG\"></div>\n");
      out.write("                        <div class=\"blanco flotanteLeft\" id=\"divInvitaciones\"></div>\n");
      out.write("                    </div>\n");
      out.write("                    <form>\n");
      out.write("                        <p><button id=\"button1\" onclick=\"crearSelectorChat()\" type=\"button\" class=\"btn btn-danger btnInv\" data-type=\"zoomin\" >Crear Chat Privado</button>\n");
      out.write("                            <input class=\"tamanoMensaje\" type=\"text\" name=\"OutMensaje\" /><input type=\"submit\" value=\"Enviar\"></p>\n");
      out.write("                </form>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </section>\n");
      out.write("            \n");
      out.write("                \n");
      out.write("        </div>  \n");
      out.write("          \n");
      out.write("            <!-- Fin de fb chat-->\n");
      out.write("            <!-- Codigo para abir ventana flotante-->\n");
      out.write("            <div class=\"overlay-container\">\n");
      out.write("\t\t<div class=\"window-container zoomin\">\n");
      out.write("\t\t\t <form class=\"PotentialMates\" action=\"crearConversacion.do\" method=\"post\">\n");
      out.write("                         <div class=\"TopSelect\">select users</div>\n");
      out.write("                         <div id=\"areaUsuarios\" class=\"AreaMates\"></div>\n");
      out.write("                         <center> <input type=\"text\" name=\"namechat\" class=\"TextTopic\" placeholder=\"Chat Name\" required=\"true\"/></center>\n");
      out.write("                         <input type=\"submit\" class=\"BtnMates\"  value=\"submit\"/>\n");
      out.write("                         <input type=\"reset\" class=\"BtnMates\"  value=\"reset\"/>\n");
      out.write("                        <span class=\"close\">Cerrar</span>\n");
      out.write("        </form>\n");
      out.write("\t\t</div>\n");
      out.write("            </div>    \n");
      out.write("           \n");
      out.write("            <script>!window.jQuery && document.write(unescape('%3Cscript src=\"jquery-1.7.1.min.js\"%3E%3C/script%3E'))</script>\n");
      out.write("            <script type=\"text/javascript\" src=\"demo.js\"></script>\n");
      out.write("\t<!-- Fin codigo ventana flotante --->\n");
      out.write("        \n");
      out.write("            <script type=\"text/javascript\" src=\"js/chat.js\"></script>   \n");
      out.write("            \n");
      out.write("            <!-- Codigo del Chat -->\n");
      out.write("            <script>\n");
      out.write("                        var myVar = setInterval(function(){getUsuarios('');},1000);\n");
      out.write("          \n");
      out.write("                        function getUsuarios(message) {\n");
      out.write("                        $.ajax({\n");
      out.write("                        type: 'POST',\n");
      out.write("                        url: 'GetUsuarios.do',\n");
      out.write("                        data: {\n");
      out.write("                        message: message\n");
      out.write("                        }\n");
      out.write("                        }).done(function(resp){\n");
      out.write("                        $('#divUsers').html(resp);\n");
      out.write("                        });\n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                        var myVar1 = setInterval(function(){getChats('');},1000);\n");
      out.write("          \n");
      out.write("                        function getChats(message) {\n");
      out.write("                        $.ajax({\n");
      out.write("                        type: 'POST',\n");
      out.write("                        url: 'Invitaciones.do',\n");
      out.write("                        data: {\n");
      out.write("                        message: message\n");
      out.write("                        }\n");
      out.write("                        }).done(function(resp){\n");
      out.write("                        $('#divInvitaciones').html(resp);\n");
      out.write("                        });\n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        function crearSelectorChat(message){\n");
      out.write("                           $.ajax({\n");
      out.write("                            type:'POST',\n");
      out.write("                            url:'crearSelectorChat.do',\n");
      out.write("                            data:{\n");
      out.write("                                message: message\n");
      out.write("                            }\n");
      out.write("                            }).done(function(resp){\n");
      out.write("                            $('#areaUsuarios').html(resp);   \n");
      out.write("                           }); \n");
      out.write("                        }\n");
      out.write("                    </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

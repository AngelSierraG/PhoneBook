/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.57
 * Generated at: 2015-01-25 22:28:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class e_002dlobby_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    ");

    String User="";
    /*
    if(session.getAttribute("USER") == null){
		//No esta iniciada
        response.sendRedirect("index.jsp");
    }else{
		//Esta iniciada;
     User = (String)session.getAttribute("USER"); 
    }
   */
    
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/chats.css\"> \n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <title>");
      out.print(User);
      out.write("</title>\n");
      out.write("        \n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("        <div class=\"PrincipalContainer\">\n");
      out.write("            \n");
      out.write("            <div class=\"OptionsContainer\">\n");
      out.write("                <div class=\"TitleOption\">\n");
      out.write("                    e-lobby\n");
      out.write("                </div>\n");
      out.write("                <div class=\"Links\">\n");
      out.write("                <br><br><br><br><br>\n");
      out.write("                <a href=\"createchat.jsp\" class=\"OptionLink\" >Create Chatroom</a><br><br>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"Chats\">\n");
      out.write("                    Invitations for ");
      out.print(User);
      out.write("\n");
      out.write("                    <div id=\"Invitations\">\n");
      out.write("                        <br><a href=\"\" class=\"OptionLink\">NO CHATS</a> \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"PartnersContainer\">\n");
      out.write("                <div class=\"TitlePartners\">\n");
      out.write("                    All Partners\n");
      out.write("                </div>\n");
      out.write("                <div id=\"AllPartners\">\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("                    <script>\n");
      out.write("                        var myVar = setInterval(function(){getUsers('');},1000);\n");
      out.write("          \n");
      out.write("                        function getUsers(message) {\n");
      out.write("                        $.ajax({\n");
      out.write("                        type: 'POST',\n");
      out.write("                        url: 'GetUsers',\n");
      out.write("                        data: {\n");
      out.write("                        message: message\n");
      out.write("                        }\n");
      out.write("                        }).done(function(resp){\n");
      out.write("                        $('#AllPartners').html(resp);\n");
      out.write("                        });\n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                        var myVar1 = setInterval(function(){getChats('');},10000);\n");
      out.write("          \n");
      out.write("                        function getChats(message) {\n");
      out.write("                        $.ajax({\n");
      out.write("                        type: 'POST',\n");
      out.write("                        url: 'Invitations',\n");
      out.write("                        data: {\n");
      out.write("                        message: message\n");
      out.write("                        }\n");
      out.write("                        }).done(function(resp){\n");
      out.write("                        $('#Invitations').html(resp);\n");
      out.write("                        });\n");
      out.write("                        }\n");
      out.write("                         \n");
      out.write("                        function sendChat(numberChat) {\n");
      out.write("                        $.ajax({\n");
      out.write("                        type: 'POST',\n");
      out.write("                        url: 'NewChat',\n");
      out.write("                        data: {\n");
      out.write("                        numberChat: numberChat\n");
      out.write("                        }\n");
      out.write("                        }).done(function(resp){\n");
      out.write("                        $('#h').html(resp);\n");
      out.write("                        });\n");
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

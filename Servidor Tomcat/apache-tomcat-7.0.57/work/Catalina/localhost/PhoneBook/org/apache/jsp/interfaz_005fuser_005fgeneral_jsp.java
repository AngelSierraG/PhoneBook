/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.57
 * Generated at: 2015-03-26 11:20:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class interfaz_005fuser_005fgeneral_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\"/>\r\n");
      out.write("\t<title>Phonebook</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"view/css/layout.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"view/css/chat.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("\t<script src=\"view/js/jquery-1.5.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"view/js/hideshow.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script src=\"view/js/jquery.tablesorter.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"view/js/jquery.equalHeight.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("    \t{ \r\n");
      out.write("      \t  $(\".tablesorter\").tablesorter(); \r\n");
      out.write("   \t } \r\n");
      out.write("\t);\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\r\n");
      out.write("\t//When page loads...\r\n");
      out.write("\t$(\".tab_content\").hide(); //Hide all content\r\n");
      out.write("\t$(\"ul.tabs li:first\").addClass(\"active\").show(); //Activate first tab\r\n");
      out.write("\t$(\".tab_content:first\").show(); //Show first tab content\r\n");
      out.write("\r\n");
      out.write("\t//On Click Event\r\n");
      out.write("\t$(\"ul.tabs li\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"ul.tabs li\").removeClass(\"active\"); //Remove any \"active\" class\r\n");
      out.write("\t\t$(this).addClass(\"active\"); //Add \"active\" class to selected tab\r\n");
      out.write("\t\t$(\".tab_content\").hide(); //Hide all tab content\r\n");
      out.write("\r\n");
      out.write("\t\tvar activeTab = $(this).find(\"a\").attr(\"href\"); //Find the href attribute value to identify the active tab + content\r\n");
      out.write("\t\t$(activeTab).fadeIn(); //Fade in the active ID content\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("    </script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    $(function(){\r\n");
      out.write("        $('.column').equalHeight();\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<header id=\"header\">\r\n");
      out.write("\t\t<hgroup>\r\n");
      out.write("\t\t\t<h1 class=\"site_title\"><img src=\"images/phonebookLogo1.png\" width=\"343\" height=\"80\"></h1>\r\n");
      out.write("\t\t\t<h2 class=\"section_title\"><!--texto --></h2><div class=\"btn_view_site\"><a href=\"http://localhost:8080/PhoneBook/login.jsp\">Iniciar sesión o Registrarse </a></div>\r\n");
      out.write("\t\t</hgroup>\r\n");
      out.write("\t</header> <!-- end of header bar -->\r\n");
      out.write("\t\r\n");
      out.write("  <section id=\"secondary_bar\">\r\n");
      out.write("\t\t<div class=\"user\">\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t\t<!-- <a class=\"logout_user\" href=\"#\" title=\"Logout\">Logout</a> -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t<div class=\"breadcrumbs_container\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</section><!-- end of secondary bar -->\r\n");
      out.write("\t\r\n");
      out.write("\t<aside id=\"sidebar\" class=\"column\">\r\n");
      out.write("\t\t<h2>Menú</h2>\r\n");
      out.write("\t\t<hr/>\r\n");
      out.write("\t\t<h3>Compras</h3>\r\n");
      out.write("\t\t<ul class=\"toggle\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<h3>Ventas</h3>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \t<ul class=\"toggle\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t</aside><!-- end of sidebar -->\r\n");
      out.write("\t\r\n");
      out.write("\t<section id=\"main\" class=\"column\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<h4 class=\"alert_info\">Bienvenido a Phonebook</h4>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<article class=\"module width_3_quarter\">\r\n");
      out.write("\t\t<header><h3 class=\"tabs_involved\">Anuncios más vistos</h3>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"tab_container\" >\r\n");
      out.write("\t\t\t<div id=\"tab1\" class=\"tab_content\">\r\n");
      out.write("\t\t\t<table class=\"tablesorter\" cellspacing=\"1\" cellpadding=\"1\" id=\"reservations\" > \r\n");
      out.write("\t\t\t<thead> \r\n");
      out.write("\t\t\t\t<tr> \r\n");
      out.write("   \t\t\t\t\t\r\n");
      out.write("    \t\t\t\t \r\n");
      out.write("    \t\t\t\t<th>Celular</th>\r\n");
      out.write("    \t\t\t\t<th>Modelo</th> \r\n");
      out.write("    \t\t\t\t<th>Precio</th> \r\n");
      out.write("    \t\t\t\t<th>Fecha de publicación</th>\r\n");
      out.write("                     \r\n");
      out.write("                    <th></th> \r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t\t\t</thead>     \r\n");
      out.write("            <tbody> \r\n");
      out.write("\t\t\t\t<tr> \r\n");
      out.write("   \t\t\t\t\t\r\n");
      out.write("   \t\t\t\t\t<td><input width=\"100px\" height=\"100px\" type=\"image\" src=\"images/galaxys5.jpg\" title=\"MinImg\" style = \"border-radius: 10px;\" ></td>\r\n");
      out.write("    \t\t\t\t<td>Vendo Galaxy s5</td> \r\n");
      out.write("    \t\t\t\t<td>$8,000</td> \r\n");
      out.write("    \t\t\t\t<td>5-03-2015</td> \r\n");
      out.write("                  \r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t\t<tr> \r\n");
      out.write("   \t\t\t\t\t\r\n");
      out.write("   \t\t\t\t\t<td><input width=\"100px\" height=\"100px\" type=\"image\" src=\"images/motoG.jpg\" title=\"MinImg\" style = \"border-radius: 10px;\"></td>\r\n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \r\n");
      out.write("    \t\t\t\t<td>$500</td> \r\n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \r\n");
      out.write("                    \r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t\t<tr> \r\n");
      out.write("   \t\t\t\t\t\r\n");
      out.write("   \t\t\t\t\t<td><input width=\"100px\" height=\"100px\" type=\"image\" src=\"images/Lg.jpg\" title=\"MinImg\" style = \"border-radius: 10px;\"></td>\r\n");
      out.write("    \t\t\t\t<td>Vendo Lg 80</td> \r\n");
      out.write("    \t\t\t\t<td>$3,500</td> \r\n");
      out.write("    \t\t\t\t<td>2-01-2015</td> \r\n");
      out.write("                    \r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr> \r\n");
      out.write("   \t\t\t\t\t\r\n");
      out.write("   \t\t\t\t\t<td><input width=\"100px\" height=\"100px\" type=\"image\" src=\"images/motoG.jpg\" title=\"MinImg\" style = \"border-radius: 10px;\"></td>\r\n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \r\n");
      out.write("    \t\t\t\t<td>$500</td> \r\n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \r\n");
      out.write("                    \r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t<tr> \r\n");
      out.write("   \t\t\t\t\t\r\n");
      out.write("   \t\t\t\t\t<td><input width=\"100px\" height=\"100px\" type=\"image\" src=\"images/galaxys5.jpg\" title=\"MinImg\" style = \"border-radius: 10px;\"></td>\r\n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \r\n");
      out.write("    \t\t\t\t<td>$500</td> \r\n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \r\n");
      out.write("                   \r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t<tr> \r\n");
      out.write("   \t\t\t\t\t\r\n");
      out.write("   \t\t\t\t\t<td><input width=\"100px\" height=\"100px\" type=\"image\" src=\"images/Lg.jpg\" title=\"MinImg\" style = \"border-radius: 10px;\"></td>\r\n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \r\n");
      out.write("    \t\t\t\t<td>$500</td> \r\n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \r\n");
      out.write("                    \r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t\t\t\t<tr> \r\n");
      out.write("   \t\t\t\t\t \r\n");
      out.write("   \t\t\t\t\t<td><input width=\"100px\" height=\"100px\" type=\"image\" src=\"images/motoG.jpg\" title=\"MinImg\" style = \"border-radius: 10px;\"></td>\r\n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \r\n");
      out.write("    \t\t\t\t<td>$500</td> \r\n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \r\n");
      out.write("                     \r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("\t\t\t\t</tr> \r\n");
      out.write("\t\t\t</tbody>  \r\n");
      out.write("              \r\n");
      out.write("\t\t\t</tbody> \r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</div><!-- end of #tab1 -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div><!-- end of .tab_container -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</article><!-- end of content manager article -->\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- end of messages article -->\r\n");
      out.write("\r\n");
      out.write("\t\t<article class=\"module width_quarter\">\r\n");
      out.write("\t\t\t<header><h3>Información</h3></header>\r\n");
      out.write("\t\t\t<div class=\"message_list\">\r\n");
      out.write("\t\t\t\t<div class=\"module_content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"message\">\r\n");
      out.write("\t\t\t\t\t<p><strong>Nota #1</strong><br>\r\n");
      out.write("\t\t\t\t\t\tSelecciona tu teléfono celular favorito junto con sus accesorios y prepárate para explorar las infinitas posibilidades del mundo móvil. </p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"message\">\r\n");
      out.write("\t\t\t\t\t<p><strong>Nota #2</strong><br>\r\n");
      out.write("\t\t\t\t\t\tEn venta las mejores ofertas de teléfonos celulares baratos para comunicarte con tu familia y amigos al mejor precio.</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<footer>\r\n");
      out.write("\t\t\t<p><strong>Copyright &copy; 2015 Phonebook</strong></p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t\t  <script type=\"text/javascript\" src=\"view/js/chat.js\"></script>   \r\n");
      out.write("          \r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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

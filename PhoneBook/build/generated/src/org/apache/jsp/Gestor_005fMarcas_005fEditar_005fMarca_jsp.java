package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import BaseDatos.AdministradorBD;

public final class Gestor_005fMarcas_005fEditar_005fMarca_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");

String  idMarca = request.getParameter("idMarca"); 
AdministradorBD sqlCode =  new AdministradorBD();
ResultSet rs = sqlCode.thisMarca(idMarca); 
String nombreMarca = ""; 
String urlImage = ""; 
if(rs.next()){
nombreMarca = rs.getString("nombreMarca");
urlImage = rs.getString("urlImage"); 
}

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\"/>\r\n");
      out.write("\t<title>Phonebook-Gestor Admin</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"view/css/layout.css\" type=\"text/css\" media=\"screen\" />\r\n");
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
      out.write("\t\t\t<h1 class=\"site_title\"><a href=\"index.html\"><img src=\"images/phonebookLogo1.png\" width=\"343\" height=\"80\"></a></h1>\r\n");
      out.write("\t\t\t<h2 class=\"section_title\"><!--texto --></h2><div class=\"btn_view_site\"><a href=\"#\"><img src=\"images/angel.jpg\" width=\"20\" height=\"20\"> Ãngel Sierra</a></div>\r\n");
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
      out.write("\t\t<h2>MenÃº</h2>\r\n");
      out.write("\t\t<hr/>\r\n");
      out.write("\t\t\r\n");
      out.write("        <h3>Gestor_Marcas</h3>\r\n");
      out.write("\t\t<ul class=\"toggle\">\r\n");
      out.write("\t\t\t<li class=\"icn_new_article\"><a href=\"Gestor_Marcas_Crear_Marcas.html\">Crear_Marcas</a></li>\r\n");
      out.write("            <li class=\"icn_categories\"><a href=\"Gestor_Marcas_Lista_Marcas.html\">Lista_Marcas</a></li>\r\n");
      out.write("            \r\n");
      out.write("\t\t</ul>\r\n");
      out.write("        \r\n");
      out.write("\t\t<h3>Gestor_Modelos</h3>\r\n");
      out.write("        \t<ul class=\"toggle\">\r\n");
      out.write("\t\t\t<li class=\"icn_new_article\"><a href=\"Gestor_Modelos_Crear_Modelo.html\">Crear_Modelo</a></li>\r\n");
      out.write("            <li class=\"icn_categories\"><a href=\"Gestor_Modelos_Lista_Modelos.html\">Lista_Modelos</a></li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("        \r\n");
      out.write("        <h3>Gestor_Anuncios</h3>\r\n");
      out.write("        \t<ul class=\"toggle\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("            <li class=\"icn_categories\"><a href=\"Gestor_Anuncios_Lista_Anuncios.html\">Lista_Anuncios</a></li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t</aside><!-- end of sidebar -->\r\n");
      out.write("\t\r\n");
      out.write("\t<section id=\"main\" class=\"column\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<h4 class=\"alert_info\">Phonebook | Gestor_Marcas | Editar_Marcas</h4>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t<article class=\"module width_full\">\r\n");
      out.write("\t\t\t<header><h3>Editar_Marca</h3></header>\r\n");
      out.write("                        <form action=\"editaMarca.jsp\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t\t<div class=\"module_content\">\r\n");
      out.write("\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t<label>Nombre Marca</label>\r\n");
      out.write("                                                        <input type=\"text\" value=\"");
 out.println(nombreMarca); 
      out.write("\" name=\"nombreMarca\" required=\"\">\r\n");
      out.write("\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<fieldset>\r\n");
      out.write("                                                    <img src=\"images/Marcas/");
out.println(urlImage);
      out.write("\" width=\"150\" height=\"150\" />\r\n");
      out.write("                                                    <input type=\"text\" value=\"");
 out.println(urlImage); 
      out.write("\" name=\"urlImage\" style=\"visibility: hidden;\">\r\n");
      out.write("                                                     <input type=\"text\" value=\"");
 out.println(idMarca); 
      out.write("\" name=\"idMarca\" style=\"visibility: hidden;\">\r\n");
      out.write("                                                    <input type=\"file\" name=\"fichero\" required=\"Actualiza Imagen\">\r\n");
      out.write("\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<footer>\r\n");
      out.write("\t\t\t\t<div class=\"submit_link\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Editar_Marca\" class=\"alt_btn\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("                            </form>\r\n");
      out.write("\t\t\t</footer>\r\n");
      out.write("\t\t</article><!-- end of post new article -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<footer>\r\n");
      out.write("\t\t\t<p><strong>Copyright &copy; 2015 Phonebook</strong></p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

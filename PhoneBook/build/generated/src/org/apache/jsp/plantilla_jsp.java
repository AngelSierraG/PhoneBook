package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class plantilla_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\"/>\n");
      out.write("\t<title>Phonebook</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"view/css/layout.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("\t<script src=\"view/js/jquery-1.5.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"view/js/hideshow.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"view/js/jquery.tablesorter.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"view/js/jquery.equalHeight.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function() \n");
      out.write("    \t{ \n");
      out.write("      \t  $(\".tablesorter\").tablesorter(); \n");
      out.write("   \t } \n");
      out.write("\t);\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\n");
      out.write("\t//When page loads...\n");
      out.write("\t$(\".tab_content\").hide(); //Hide all content\n");
      out.write("\t$(\"ul.tabs li:first\").addClass(\"active\").show(); //Activate first tab\n");
      out.write("\t$(\".tab_content:first\").show(); //Show first tab content\n");
      out.write("\n");
      out.write("\t//On Click Event\n");
      out.write("\t$(\"ul.tabs li\").click(function() {\n");
      out.write("\n");
      out.write("\t\t$(\"ul.tabs li\").removeClass(\"active\"); //Remove any \"active\" class\n");
      out.write("\t\t$(this).addClass(\"active\"); //Add \"active\" class to selected tab\n");
      out.write("\t\t$(\".tab_content\").hide(); //Hide all tab content\n");
      out.write("\n");
      out.write("\t\tvar activeTab = $(this).find(\"a\").attr(\"href\"); //Find the href attribute value to identify the active tab + content\n");
      out.write("\t\t$(activeTab).fadeIn(); //Fade in the active ID content\n");
      out.write("\t\treturn false;\n");
      out.write("\t});\n");
      out.write("\n");
      out.write("});\n");
      out.write("    </script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    $(function(){\n");
      out.write("        $('.column').equalHeight();\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<header id=\"header\">\n");
      out.write("\t\t<hgroup>\n");
      out.write("\t\t\t<h1 class=\"site_title\"><a href=\"index.html\"><img src=\"images/phonebookLogo1.png\" width=\"343\" height=\"80\"></a></h1>\n");
      out.write("\t\t\t<h2 class=\"section_title\"><!--texto --></h2><div class=\"btn_view_site\"><a href=\"#\"><img src=\"images/angel.jpg\" width=\"20\" height=\"20\"> Ángel Sierra</a></div>\n");
      out.write("\t\t</hgroup>\n");
      out.write("\t</header> <!-- end of header bar -->\n");
      out.write("\t\n");
      out.write("  <section id=\"secondary_bar\">\n");
      out.write("\t\t<div class=\"user\">\n");
      out.write("\t\t \n");
      out.write("\t\t\t<!-- <a class=\"logout_user\" href=\"#\" title=\"Logout\">Logout</a> -->\n");
      out.write("\t</div>\n");
      out.write("\t\t<div class=\"breadcrumbs_container\">\n");
      out.write("\t\t\t<article class=\"breadcrumbs\"><a href=\"../inde3.html\">Mensajes</a> </article> <article class=\"breadcrumbs\"><a href=\"../inde3.html\">Marcas</a> </article> <article class=\"breadcrumbs\"><a href=\"../inde3.html\">Modelos</a> </article> <article class=\"breadcrumbs\"><a href=\"../inde3.html\">Anuncios</a> </article><article class=\"breadcrumbs\"><a href=\"../inde3.html\">Inicio</a> </article> \n");
      out.write("\t</div>\n");
      out.write("\t</section><!-- end of secondary bar -->\n");
      out.write("\t\n");
      out.write("\t<aside id=\"sidebar\" class=\"column\">\n");
      out.write("\t\t<form class=\"quick_search\">\n");
      out.write("\t\t\t<input type=\"text\" value=\"Buscar\" onFocus=\"if(!this._haschanged){this.value=''};this._haschanged=true;\">\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<hr/>\n");
      out.write("\t\t<h3>Marcas</h3>\n");
      out.write("\t\t<ul class=\"toggle\">\n");
      out.write("\t\t\t<li class=\"icn_categories\"><a href=\"#\">Listar</a></li>\n");
      out.write("            <li class=\"icn_new_article\"><a href=\"#\">Agregar</a></li>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t</ul>\n");
      out.write("\t\t<h3>Modelos</h3>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \t<ul class=\"toggle\">\n");
      out.write("\t\t\t<li class=\"icn_categories\"><a href=\"#\">Listar</a></li>\n");
      out.write("            <li class=\"icn_new_article\"><a href=\"#\">Agregar</a></li>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t</ul>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t\t<h3>Anuncios</h3>\n");
      out.write("\t\t<ul class=\"toggle\">\n");
      out.write("\t\t\t<li class=\"icn_settings\"><a href=\"#\">Listar</a></li>\n");
      out.write("\t\t\t<li class=\"icn_security\"><a href=\"#\">Agregar</a></li>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</ul>\n");
      out.write("        \n");
      out.write("        <h3>Mensajes</h3>\n");
      out.write("\t\t<ul class=\"toggle\">\n");
      out.write("\t\t\t<li class=\"icn_settings\"><a href=\"#\">Listar</a></li>\n");
      out.write("\t\t\t<li class=\"icn_security\"><a href=\"#\">Nuevo</a></li>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</ul>\n");
      out.write("\t\t\n");
      out.write("\t\t<footer>\n");
      out.write("\t\t\t<hr />\n");
      out.write("\t\t\t<p><strong>Copyright &copy; 2015 Phonebook</strong></p>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</footer>\n");
      out.write("\t</aside><!-- end of sidebar -->\n");
      out.write("\t\n");
      out.write("\t<section id=\"main\" class=\"column\">\n");
      out.write("\t\t\n");
      out.write("\t\t<h4 class=\"alert_info\">Bienvenido a Phonebook</h4>\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t\t<article class=\"module width_3_quarter\">\n");
      out.write("\t\t<header><h3 class=\"tabs_involved\">Contenido</h3>\n");
      out.write("\t\t<ul class=\"tabs\">\n");
      out.write("   \t\t\t<li><a href=\"#tab1\">Anuncios</a></li>\n");
      out.write("    \t\t<li><a href=\"#tab2\">Modelos</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t\t</header>\n");
      out.write("\n");
      out.write("\t\t<div class=\"tab_container\" >\n");
      out.write("\t\t\t<div id=\"tab1\" class=\"tab_content\">\n");
      out.write("\t\t\t<table class=\"tablesorter\" cellspacing=\"1\" cellpadding=\"1\" id=\"reservations\" > \n");
      out.write("\t\t\t<thead> \n");
      out.write("\t\t\t\t<tr> \n");
      out.write("   \t\t\t\t\t\n");
      out.write("    \t\t\t\t<th>ID</th> \n");
      out.write("    \t\t\t\t<th>Nombre Aununcio</th> \n");
      out.write("    \t\t\t\t<th>Fecha Inicio</th> \n");
      out.write("    \t\t\t\t<th>Fecha Final</th>\n");
      out.write("                    <th>Descripción</th>  \n");
      out.write("                    <th></th> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("\t\t\t</thead>     \n");
      out.write("            <tbody> \n");
      out.write("\t\t\t\t<tr> \n");
      out.write("   \t\t\t\t\t<td>1</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("\t\t\t\t\t<tr> \n");
      out.write("   \t\t\t\t\t<td>2</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("                \t<tr> \n");
      out.write("   \t\t\t\t\t<td>3</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("                \t<tr> \n");
      out.write("   \t\t\t\t\t<td>4</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("                \t<tr> \n");
      out.write("   \t\t\t\t\t<td>5</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("                \t<tr> \n");
      out.write("   \t\t\t\t\t<td>6</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("\t\t\t</tbody>  \n");
      out.write("              \n");
      out.write("\t\t\t</tbody> \n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t</div><!-- end of #tab1 -->\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div id=\"tab2\" class=\"tab_content\">\n");
      out.write("\t\t\t<table class=\"tablesorter\" cellspacing=\"0\"> \n");
      out.write("\t\t\t<thead> \n");
      out.write("\t\t\t\t<tr> \n");
      out.write("   \t\t\t\t\t\t<th>ID</th> \n");
      out.write("    \t\t\t\t<th>Nombre Aununcio</th> \n");
      out.write("    \t\t\t\t<th>Fecha Inicio</th> \n");
      out.write("    \t\t\t\t<th>Fecha Final</th>\n");
      out.write("                    <th>Descripción</th>  \n");
      out.write("                    <th></th>\n");
      out.write("\t\t\t\t</tr> \n");
      out.write("\t\t\t</thead> \n");
      out.write("\t\t\t           <tbody> \n");
      out.write("\t\t\t\t<tr> \n");
      out.write("   \t\t\t\t\t<td>1</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("\t\t\t\t\t<tr> \n");
      out.write("   \t\t\t\t\t<td>2</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("                \t<tr> \n");
      out.write("   \t\t\t\t\t<td>3</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("                \t<tr> \n");
      out.write("   \t\t\t\t\t<td>4</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("                \t<tr> \n");
      out.write("   \t\t\t\t\t<td>5</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("                \t<tr> \n");
      out.write("   \t\t\t\t\t<td>6</td> \n");
      out.write("    \t\t\t\t<td>Vendo Moto G</td> \n");
      out.write("    \t\t\t\t<td>17-02-2015</td> \n");
      out.write("    \t\t\t\t<td>2-03-2015</td> \n");
      out.write("                    <td>Excelentes Condiciones</td> \n");
      out.write("    \t\t\t\t<td><input type=\"image\" src=\"images/icn_edit.png\" title=\"Edit\"><input type=\"image\" src=\"images/icn_trash.png\" title=\"Trash\"></td> \n");
      out.write("\t\t\t\t</tr> \n");
      out.write("\t\t\t</tbody>  \n");
      out.write("\t\t\t</table>\n");
      out.write("\n");
      out.write("\t\t\t</div><!-- end of #tab2 -->\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div><!-- end of .tab_container -->\n");
      out.write("\t\t\n");
      out.write("\t\t</article><!-- end of content manager article -->\n");
      out.write("\t\t\n");
      out.write("\t\t<article class=\"module width_quarter\">\n");
      out.write("\t\t\t<header><h3>Mensajes de Contacto</h3></header>\n");
      out.write("\t\t\t<div class=\"message_list\">\n");
      out.write("\t\t\t\t<div class=\"module_content\">\n");
      out.write("\t\t\t\t\t<div class=\"message\">\n");
      out.write("\t\t\t\t\t<p>Tienen disponible el primer fin de semana de enero?</p>\n");
      out.write("\t\t\t\t\t<p><strong>Misue Angel</strong></p></div>\n");
      out.write("\t\t\t\t\t<div class=\"message\">\n");
      out.write("\t\t\t\t\t<p>En qué consiste el sendero interpretativo río lacanja.</p>\n");
      out.write("\t\t\t\t\t<p><strong>Eunice Lopez</strong></p></div>\n");
      out.write("\t\t\t\t\t<div class=\"message\">\n");
      out.write("\t\t\t\t\t<p>Si hago una transferencia electrónica como podemos confirmar la reservación.</p>\n");
      out.write("\t\t\t\t\t<p><strong>Mayra González</strong></p></div>\n");
      out.write("\t\t\t\t\t<div class=\"message\">\n");
      out.write("\t\t\t\t\t<p>Hasta cuantas personas puede entrar el la cabaña rústica?.</p>\n");
      out.write("\t\t\t\t\t<p><strong>Daniel Gómez</strong></p></div>\n");
      out.write("\t\t\t\t\t<div class=\"message\">\n");
      out.write("\t\t\t\t\t<p>A partir de qué hora puedo ocupar mi reservación la fecha establecida.</p>\n");
      out.write("\t\t\t\t\t<p><strong>Pablo Romero</strong></p></div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<footer>\n");
      out.write("\t\t\t\t<form class=\"post_message\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" value=\"Respuesta\" onFocus=\"if(!this._haschanged){this.value=''};this._haschanged=true;\">\n");
      out.write("\t\t\t\t\t<input type=\"submit\" class=\"btn_post_message\" value=\"\"/>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</footer>\n");
      out.write("\t\t</article><!-- end of messages article -->\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t\n");
      out.write("\t\t<article class=\"module width_full\">\n");
      out.write("\t\t\t<header><h3>Post New Article</h3></header>\n");
      out.write("\t\t\t\t<div class=\"module_content\">\n");
      out.write("\t\t\t\t\t\t<fieldset>\n");
      out.write("\t\t\t\t\t\t\t<label>Post Title</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\">\n");
      out.write("\t\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t\t\t<fieldset>\n");
      out.write("\t\t\t\t\t\t\t<label>Content</label>\n");
      out.write("\t\t\t\t\t\t\t<textarea rows=\"12\"></textarea>\n");
      out.write("\t\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t\t\t<fieldset style=\"width:48%; float:left; margin-right: 3%;\"> <!-- to make two field float next to one another, adjust values accordingly -->\n");
      out.write("\t\t\t\t\t\t\t<label>Category</label>\n");
      out.write("\t\t\t\t\t\t\t<select style=\"width:92%;\">\n");
      out.write("\t\t\t\t\t\t\t\t<option>Articles</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Tutorials</option>\n");
      out.write("\t\t\t\t\t\t\t\t<option>Freebies</option>\n");
      out.write("\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t\t\t<fieldset style=\"width:48%; float:left;\"> <!-- to make two field float next to one another, adjust values accordingly -->\n");
      out.write("\t\t\t\t\t\t\t<label>Tags</label>\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" style=\"width:92%;\">\n");
      out.write("\t\t\t\t\t\t</fieldset><div class=\"clear\"></div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t<footer>\n");
      out.write("\t\t\t\t<div class=\"submit_link\">\n");
      out.write("\t\t\t\t\t<select>\n");
      out.write("\t\t\t\t\t\t<option>Draft</option>\n");
      out.write("\t\t\t\t\t\t<option>Published</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Publish\" class=\"alt_btn\">\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Reset\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</footer>\n");
      out.write("\t\t</article><!-- end of post new article -->\n");
      out.write("\t\t\n");
      out.write("\t\t<h4 class=\"alert_warning\">A Warning Alert</h4>\n");
      out.write("\t\t\n");
      out.write("\t\t<h4 class=\"alert_error\">An Error Message</h4>\n");
      out.write("\t\t\n");
      out.write("\t\t<h4 class=\"alert_success\">A Success Message</h4>\n");
      out.write("\t\t\n");
      out.write("\t\t<article class=\"module width_full\">\n");
      out.write("\t\t\t<header><h3>Basic Styles</h3></header>\n");
      out.write("\t\t\t\t<div class=\"module_content\">\n");
      out.write("\t\t\t\t\t<h1>Header 1</h1>\n");
      out.write("\t\t\t\t\t<h2>Header 2</h2>\n");
      out.write("\t\t\t\t\t<h3>Header 3</h3>\n");
      out.write("\t\t\t\t\t<h4>Header 4</h4>\n");
      out.write("\t\t\t\t\t<p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras mattis consectetur purus sit amet fermentum. Maecenas faucibus mollis interdum. Maecenas faucibus mollis interdum. Cras justo odio, dapibus ac facilisis in, egestas eget quam.</p>\n");
      out.write("\n");
      out.write("<p>Donec id elit non mi porta <a href=\"#\">link text</a> gravida at eget metus. Donec ullamcorper nulla non metus auctor fringilla. Cras mattis consectetur purus sit amet fermentum. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t<li>Donec ullamcorper nulla non metus auctor fringilla. </li>\n");
      out.write("\t\t\t\t\t\t<li>Cras mattis consectetur purus sit amet fermentum.</li>\n");
      out.write("\t\t\t\t\t\t<li>Donec ullamcorper nulla non metus auctor fringilla. </li>\n");
      out.write("\t\t\t\t\t\t<li>Cras mattis consectetur purus sit amet fermentum.</li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t</article><!-- end of styles article -->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\t\t<div class=\"spacer\"></div>\n");
      out.write("\n");
      out.write("<article class=\"module width_full\">\n");
      out.write("\t\t\t<header><h3>Estadísticas</h3></header>\n");
      out.write("\t\t\t<div class=\"module_content\">\n");
      out.write("\t\t\t\t<article class=\"stats_graph\">\n");
      out.write("\t\t\t\t\t<img src=\"http://chart.apis.google.com/chart?chxr=0,0,3000&chxt=y&chs=520x140&cht=lc&chco=76A4FB,80C65A&chd=s:Tdjpsvyvttmiihgmnrst,OTbdcfhhggcTUTTUadfk&chls=2|2&chma=40,20,20,30\" width=\"520\" height=\"140\" alt=\"\" />\n");
      out.write("\t\t\t\t</article>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<article class=\"stats_overview\">\n");
      out.write("\t\t\t\t\t<div class=\"overview_today\">\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_day\">Hoy</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_count\">1,276</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_type\">Visítas</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_count\">2,103</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_type\">Páginas</p>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"overview_previous\">\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_day\">Este Mes</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_count\">7,646</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_type\">Visítas</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_count\">2,054</p>\n");
      out.write("\t\t\t\t\t\t<p class=\"overview_type\">Páginas</p>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</article>\n");
      out.write("\t\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</article><!-- end of stats article -->\n");
      out.write("\t</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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

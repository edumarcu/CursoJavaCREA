package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005fb_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!--\n");
      out.write("Ejercicio 03_04\n");
      out.write("===============\n");
      out.write("\n");
      out.write("En este ejercicio va a continuar probando los fundamentos de la sintaxis de JSP.\n");
      out.write("\n");
      out.write(" a) Cree tres variables que contengan la siguiente información:\n");
      out.write("\n");
      out.write("     * nombre\n");
      out.write("     * apellido\n");
      out.write("     * año de nacimiento\n");
      out.write("\n");
      out.write(" b) Muestre la información usando una tabla HTML.\n");
      out.write("\n");
      out.write("    Debe ser similar a esta:\n");
      out.write("\n");
      out.write("      +====================+=====================+============================+\n");
      out.write("      |       Nombre       |      Apellido       |       Edad en 2013         |\n");
      out.write("      +====================+=====================+============================+\n");
      out.write("      |  <nombre alumno>   |  <apellido alumno>  | <2013 – año de nacimiento> |\n");
      out.write("      +====================+=====================+============================+\n");
      out.write("\n");
      out.write("-->\n");
      out.write("\n");

    String firstname = "Víctor";
    String lastname = "Jiménez Cerrada";
    int year = 1985;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Ejercicio 03_04: Variables</title>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        html {\n");
      out.write("            background-color: #f0f7ff;\n");
      out.write("            font-family: 'Helvetica', sans-serif;\n");
      out.write("            color: #777A75;\n");
      out.write("            font-size: 10pt;\n");
      out.write("            text-shadow: 0px 1px 0px white;\n");
      out.write("        }\n");
      out.write("        body {\n");
      out.write("            width: 720px;\n");
      out.write("            border: 1px solid #d3d7cf;\n");
      out.write("            margin: 90px auto 40px auto;\n");
      out.write("            padding: 10px 30px 20px 30px;\n");
      out.write("            background-color: #fefefe;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            box-shadow: 0px 1px 10px #d3d7cf;\n");
      out.write("        }\n");
      out.write("        h1:first-of-type {\n");
      out.write("            top: 25px;\n");
      out.write("            position: absolute;\n");
      out.write("            text-align: center;\n");
      out.write("            width: 720px;\n");
      out.write("        }\n");
      out.write("        h1 {\n");
      out.write("            text-shadow: 0px 2px 0px white;\n");
      out.write("            font-size: 14pt;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            font-size: 12pt;\n");
      out.write("            margin: 20px 0px 10px 0px;\n");
      out.write("        }\n");
      out.write("        h3 {\n");
      out.write("            font-size: 10pt;\n");
      out.write("        }\n");
      out.write("        h2, strong, th, dt {\n");
      out.write("            color: #555753;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        table, td {\n");
      out.write("            border: 1px solid grey;\n");
      out.write("            min-width: 100px;\n");
      out.write("            min-height: 20px;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 2px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Ejercicio 03_04: Variables</h1>\n");
      out.write("    <table>\n");
      out.write("      <tr>\n");
      out.write("        <th>Nombre</th>\n");
      out.write("        <th>Apellidos</th>\n");
      out.write("        <th>Edad en 2013</th>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("        <td>");
      out.print( firstname );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( lastname );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( 2013 - year );
      out.write("</td>\n");
      out.write("      </tr>\n");
      out.write("    </table>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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

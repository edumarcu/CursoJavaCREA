package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005fc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("Ejercicio 03_05\n");
      out.write("===============\n");
      out.write("\n");
      out.write("En este ejercicio se va a comenzar a poner en práctica los conocimientos de las\n");
      out.write("estructuras de control estudiadas.\n");
      out.write("\n");
      out.write("Los 3 apartados pueden hacerse dentro de este mismo proyecto.\n");
      out.write("\n");
      out.write(" a) Usando JSP y una estructura de bucle, escriba tres veces \"¡Hola!, mi nombre\n");
      out.write("    es <nombre del alumno>.\".\n");
      out.write("\n");
      out.write(" b) Defina la variable n con un numero entero positivo.\n");
      out.write("    Escriba los numeros del 1 al n indicando si son pares o impares.\n");
      out.write("    (Puede usar el operador ’ %’ para calcular el modulo de una division.)\n");
      out.write("\n");
      out.write(" c) Escriba los divisores de un numero n.\n");
      out.write("\n");
      out.write(" d) Escriba potencia m del numero n.\n");
      out.write("    Realice el cálculo mediante multiplicaciones.\n");
      out.write("\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Ejercicio 03_05: Estructuras de control</title>\n");
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
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Ejercicio 03_05: Estructuras de control</h1>\n");
      out.write("    <h2>Apartado A</h2>\n");
      out.write("    ");
 for (int i = 0; i < 3; i++) { 
      out.write("\n");
      out.write("    <p>¡Mi nombre es Íñigo Montoya!</p>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("    <h2>Apartado B</h2>\n");
      out.write("    ");
 int n = 8; 
      out.write("\n");
      out.write("    <p>Números del 1 al ");
      out.print( n );
      out.write("</p>\n");
      out.write("    <ul>\n");
      out.write("    ");
 for (int i = 1; i <= n; i++) { 
      out.write("\n");
      out.write("      <li>");
      out.print( n );
      out.write(" es ");
      out.print( (n % 2 == 0) ? "par" : "impar");
      out.write("</li>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <h2>Apartado C</h2>\n");
      out.write("    <p>Divisores de ");
      out.print( n );
      out.write("</p>\n");
      out.write("    <ul>\n");
      out.write("    ");
 for (int i = 1; i <= n; i++) { 
      out.write("\n");
      out.write("    ");
 if (n % i == 0) { 
      out.write("\n");
      out.write("      <li>");
      out.print( n );
      out.write("</li>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <h2>Apartado D</h2>\n");
      out.write("    ");

      int m = 2;
      int res = 1;

      for (int i = 1; i <= m; i++) {
          res *= n;
      }
    
      out.write("\n");
      out.write("    <p>");
      out.print( n );
      out.write("<sup>");
      out.print( m );
      out.write("</sup> = ");
      out.print( res );
      out.write("</p>\n");
      out.write("\n");
      out.write("\n");
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

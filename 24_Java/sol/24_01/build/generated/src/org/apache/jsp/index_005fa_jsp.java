package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005fa_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("Ejercicio 03_03\n");
      out.write("===============\n");
      out.write("\n");
      out.write("En este ejercicio comenzará a poner en práctica los conocimientos de la sintaxis\n");
      out.write("de JSP.\n");
      out.write("\n");
      out.write("Cada apartado se deberá completar en el lugar correspondiente en este\n");
      out.write("fichero index.php\n");
      out.write("\n");
      out.write(" a) Almacene el resultado de operar 3 * 4 en una variable.\n");
      out.write("    Imprima el valor de esa variable.\n");
      out.write("\n");
      out.write(" b) Almacene el resultado de operar 3.33 * 4.33 en una variable.\n");
      out.write("    Imprima el resultado con una precision de 3 decimales.\n");
      out.write("\n");
      out.write(" b.1) El resultado real es 14.4189. ¿Ha impreso el mismo resultado? ¿Por qué?\n");
      out.write("\n");
      out.write(" c) Compruebe si 9.95 * 100 es igual a 995 y escríbalo.\n");
      out.write("\n");
      out.write(" c.1) Puede que el resultado salga que es desigual.\n");
      out.write("      En este caso, pruebe a mostrar el resultado con 30 decimales y\n");
      out.write("      repita este apartado arreglando el error.\n");
      out.write("\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Ejercicio 03_03: Variables</title>\n");
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
      out.write("    <h1>Ejercicio 03_03: Variables</h1>\n");
      out.write("    <h2>Parte A</h2>\n");
      out.write("    ");

        int resa = 3 * 4;
    
      out.write("\n");
      out.write("    <p>3 * 4 = ");
      out.print( resa );
      out.write("</p>\n");
      out.write("\n");
      out.write("    <h2>Parte B</h2>\n");
      out.write("    ");

        float resb = 3.33f * 4.33f;
    
      out.write("\n");
      out.write("    <p>3.33 * 4.33 = ");
      out.print( String.format("%.3f", resb) );
      out.write("</p>\n");
      out.write("\n");
      out.write("    <h2>Parte C</h2>\n");
      out.write("    ");

        boolean resc= 9.95 * 100 == 995.0;
    
      out.write("\n");
      out.write("    <p>¿ 9.95 * 100 == 995 ? ");
      out.print( resc );
      out.write("</p>\n");
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

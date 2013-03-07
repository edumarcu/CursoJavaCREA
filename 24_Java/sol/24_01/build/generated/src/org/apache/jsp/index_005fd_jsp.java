package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005fd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private boolean defectivo(int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (n % i == 0) {
                res += i;
            }
        }
        return res <= n;
    }

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
      out.write("Ejercicio 03_07\n");
      out.write("===============\n");
      out.write("\n");
      out.write("En este ejercicio practicará lo aprendido respecto a las estructuras de control\n");
      out.write("de JSP, principalmente las estructuras while, do while e if.\n");
      out.write("\n");
      out.write(" a) Calcule los números defectivos entre 1 y 25.\n");
      out.write("\n");
      out.write("    Un número defectivo es aquel número mayor que la suma de sus divisores\n");
      out.write("    propios.\n");
      out.write("\n");
      out.write("    Los datos obtenidos se mostrarán de la siguiente manera:\n");
      out.write("\n");
      out.write("    Los divisores de 8 son 1,2,4.\n");
      out.write("    La suma de sus divisores propios es 7.\n");
      out.write("    Por ello, el Número 8 es defectivo.\n");
      out.write("\n");
      out.write("    Como idea para empezar, piense que, a excepción del resto de números\n");
      out.write("    naturales, el 1 únicamente tendrá un divisor y será él mismo.\n");
      out.write("\n");
      out.write("    Recuerde que la solución a este ejercicio se deberá conseguir haciendo uso\n");
      out.write("    de las estructuras de control while, do while e if.\n");
      out.write("-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Ejercicio 03_07: Estructuras de control</title>\n");
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
      out.write("    <h1>Ejercicio 03_07: Estructuras de control</h1>\n");
      out.write("    ");

      int[] numbers = {1,3,8,10,24};
    
      out.write("\n");
      out.write("    <ul>\n");
      out.write("      ");
 for (int n : numbers) { 
      out.write("\n");
      out.write("      <li>");
      out.print( n );
      out.write(' ');
      out.print( (defectivo(n)) ? "es" : "no es" );
      out.write(" defectivo</li>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("    </ul>\n");
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

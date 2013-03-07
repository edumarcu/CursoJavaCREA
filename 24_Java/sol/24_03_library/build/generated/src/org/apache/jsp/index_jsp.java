package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import curso.ej24_02.Book;
import curso.ej24_02.LibraryImpl;
import curso.ej24_02.Library;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=windows-1252");
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
      out.write("\n");
      out.write("\n");

        Library library = new LibraryImpl();
        library.addBook(new Book("0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997, "J. K. Rowling"));
        library.addBook(new Book("0 7475 3848 4", "Harry Potter and the chamber of secrets", 1998, "J. K. Rowling"));
        library.addBook(new Book("978 0 140 81774 4", "Nineteen eighty-four", 1949, "George Orwell"));
        library.addBook(new Book("35 221 2800 1", "Die unendliche geschichte", 1979, "Michael Ende"));
        library.addBook(new Book("0 345 39180 2", "The hitchhicker's guide to the galaxy", 1979, "Douglas Adams"));

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\n");
      out.write("    <title>Ejercicio 24_02 - Librería</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <h1>Librería</h1>\n");
      out.write("    <table>\n");
      out.write("      <thead>\n");
      out.write("        <tr>\n");
      out.write("          <th>ISBN</th>\n");
      out.write("          <th>title</th>\n");
      out.write("          <th>author</th>\n");
      out.write("        </tr>\n");
      out.write("      </thead>\n");
      out.write("      <tbody>\n");
      out.write("      ");
 for (Book book : library.list()) { 
      out.write("\n");
      out.write("      ");
    request.setAttribute("book", book); 
      out.write("\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "_row.jsp", out, false);
      out.write("\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("      </tbody>\n");
      out.write("    </table>\n");
      out.write("  </body>\n");
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

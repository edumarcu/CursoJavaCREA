package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import curso.ej24_02.Library;
import curso.ej24_02.Book;

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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

 request.setAttribute("title", "Library - Book List"); 
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layout/_header.jsp", out, false);
      out.write("\n");
      out.write("    <h2>Book List</h2>\n");
      out.write("    <table>\n");
      out.write("      <thead>\n");
      out.write("        <tr>\n");
      out.write("          <th>Title</th>\n");
      out.write("          <th>Author</th>\n");
      out.write("        </tr>\n");
      out.write("      </thead>\n");
      out.write("      <tbody>\n");
      out.write("      ");
      curso.ej24_02.Library library = null;
      library = (curso.ej24_02.Library) _jspx_page_context.getAttribute("library", PageContext.REQUEST_SCOPE);
      if (library == null){
        throw new java.lang.InstantiationException("bean library not found within scope");
      }
 for (Book book : library.list()) { 
   request.setAttribute("book", book); 
      out.write("\n");
      out.write("        <tr>\n");
      out.write("          <td>\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("          </td>\n");
      out.write("          <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.author}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("      </tbody>\n");
      out.write("    </table>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layout/_footer.jsp", out, false);
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

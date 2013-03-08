/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.demo25;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet 3.0, Java EE 6
 * @author EM
 */
@WebServlet(name = "Hello World Servlet", urlPatterns = {"/servlet/*"})
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.write("<html>\n");
        out.write("    <head>\n");
        out.write("        <title>Servlet</title>\n");
        out.write("    </head>\n");
        out.write("    <body>\n");
        out.write("        <h1>Ola ke ase!</h1>\n");
        out.write("    </body>\n");
        out.write("</html>\n");
    }



}

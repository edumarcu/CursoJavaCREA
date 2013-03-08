package curso.demo25;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ComposerServlet", urlPatterns = {"/ComposerServlet"})
public class ComposerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("foo", "BAR");

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Composer</title></head><body>");
        out.println("<h1>Include vs Forward</h1>");

        out.println("<h2>Include</h2>");
        RequestDispatcher disp1 = req.getRequestDispatcher("showAtts.jsp");
        disp1.include(req, resp);

        out.println("<h2>Forward</h2>");
        RequestDispatcher disp2 = req.getRequestDispatcher("showAtts.jsp");
        disp2.forward(req, resp);

        out.println("</body></html>");
    }



}

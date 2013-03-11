package curso.ej25_03;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "IndexServlet",
        urlPatterns = {"/change"})
public class IndexServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message = (String) req.getParameter("changeMessage");
        if (message != null && message != "") {
            ServletContext application = getServletContext();
            application.setAttribute("message", message);
        }

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

}

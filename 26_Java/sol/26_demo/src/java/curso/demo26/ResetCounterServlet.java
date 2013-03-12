package curso.demo26;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ResetCounterServlet", urlPatterns = {"/resetCounter"})
public class ResetCounterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // getSession(true);
//        session.setAttribute("contador", null);
        session.invalidate();

        resp.sendRedirect("index_session.jsp");
    }

}

package curso.ejercicio4.apartadob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ApartadoB", urlPatterns = {"/b"})
public class ApartadoB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("total") == null) {
            session.setAttribute("total", 0);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/b.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("add")) {
            post_add(req, resp);
        } else if (action.equals("reset")) {
            post_reset(req, resp);
        } else {
            String base = getServletContext().getContextPath();
            resp.sendRedirect(base + "/b");
        }
    }

    private void post_add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("numbers") == null) {
            session.setAttribute("numbers", new ArrayList<Integer>());
        }
        List<Integer> numbers = (List<Integer>) session.getAttribute("numbers");

        try {
            int number = Integer.parseInt(req.getParameter("number"));
            numbers.add(number);
        } catch (Exception e) {}

        int total = 0;
        for (Integer n : numbers) {
            total += n;
        }
        session.setAttribute("total", total);

        String base = getServletContext().getContextPath();
        resp.sendRedirect(base + "/b");
    }

    private void post_reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("numbers", null);
        session.setAttribute("total", 0);

        String base = getServletContext().getContextPath();
        resp.sendRedirect(base + "/b");
    }
}

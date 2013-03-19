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

@WebServlet(name = "ApartadoB", urlPatterns = {"/b"})
public class ApartadoB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  If not total in session, set to 0.
        Integer total = (Integer) req.getSession().getAttribute("total");
        List<Integer> numbers = (List<Integer>) req.getSession().getAttribute("numbers");

         if (total == null || numbers == null ) {
            total = new Integer(0);
            req.getSession().setAttribute("total", total);

            numbers = new ArrayList<>();
            req.getSession().setAttribute("numbers", numbers);
         }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/b.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  based on action parameter, execute post_add or post_reset.
        String actionParam = req.getParameter("action");
        switch (actionParam) {
            case "add":
                post_add(req, resp);
                break;
            case "reset":
                post_reset(req, resp);
                break;
            default:
                break;
        }

        resp.sendRedirect(getServletContext().getAttribute("base") + "/b");
    }

    private void post_add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  retrieve parameter number, store both the sumatory of numbers and the number in session.
        Integer number = null;
        try {
            number = Integer.parseInt(req.getParameter("number"));
        } catch (Exception e) {
            // if not a number exit
            return;
        }
        Integer total = (Integer) req.getSession().getAttribute("total");

        total += number;
        req.getSession().setAttribute("total", total);

        List<Integer> numbers = (List<Integer>) req.getSession().getAttribute("numbers");
        numbers.add(number);
        req.getSession().setAttribute("numbers", numbers);
    }

    private void post_reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  reset sumatory of numbers and number list.
        req.getSession().invalidate();
    }
}

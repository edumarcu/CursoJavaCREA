package curso.ejercicio4.apartadoa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ApartadoA", urlPatterns = {"/a"})
public class ApartadoA extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("number") != null) {
            try {
                int number = Integer.parseInt(req.getParameter("number").trim());
                req.setAttribute("number", number);

                List<Integer> divisors = new ArrayList<Integer>();
                for (int i = 1; i <= number; i++) {
                    if (number % i == 0) {
                        divisors.add(i);
                    }
                }
                req.setAttribute("divisors", divisors);
            } catch (Exception e) {}
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/a.jsp");
        dispatcher.forward(req, resp);
    }

}

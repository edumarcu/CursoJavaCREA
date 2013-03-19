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
        // Fetch param number and calculate its divisors.
        String numberText = req.getParameter("number");
        if (numberText == null) {
            // no divisors request yet, do nothing

        } else {
         //  assert number >0 and handle error
            int number = 0;
            try {
                number = Integer.parseInt(req.getParameter("number"));
            } catch (Exception e) {
                    // Redirect to View
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/a.jsp");
                dispatcher.forward(req, resp);
            }

            if (number < 0) {
                // Redirect to View
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/a.jsp");
                dispatcher.forward(req, resp);
            }

            List<Integer> divisors = new ArrayList<>();

            for (int i = 1; i <= number / 2; i++) { // TODO: try SQRT(number)
                if (number % i == 0) {
                    divisors.add(i);
                }
            }

            divisors.add(number);

            // Pass divisors as attribute to the view
            req.setAttribute("divisors", divisors);
            req.setAttribute("number", number); // to be shown in the form

            // Forward to View
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/a.jsp");
            dispatcher.forward(req, resp);
        }
        // Redirect to View
        resp.sendRedirect(getServletContext().getAttribute("base") + "/views/a.jsp");
    }

}

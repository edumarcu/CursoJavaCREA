package curso.ej25_04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
    public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message = req.getParameter("message");

        if (message == null || message.length() < 4) {
            String error = "El mensaje estaba vacío o tenía una longitud menor a 4 carácteres.";

            req.setAttribute("error", error);
            req.setAttribute("message", message);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/index");
            dispatcher.forward(req, resp);
            return;
        }

        ServletContext application = getServletContext();
        application.setAttribute("message", message);

        String base = req.getContextPath();
        resp.sendRedirect(base + "/index");
    }

}

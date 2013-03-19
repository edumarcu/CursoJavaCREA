package curso.ej33;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ValidateServlet", urlPatterns = {"/validate"})
public class ValidateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        Message message = new Message(text);

        ErrorSet errors = new ErrorSet();
        message.validate(errors);

        if (errors.isValid()) {
            boolean valid = false; // 2nd validation. message.save();

            if (valid) {
                HttpSession session = req.getSession();
                session.setAttribute("message", message);

                String base = getServletContext().getContextPath();
                resp.sendRedirect(base + "/index.jsp");
            } else {
                String errormsg = "Ocurrió un error interno al atender su solicitud, por favor inténtelo más tarde.";
                req.setAttribute("errormsg", errormsg);
                req.setAttribute("text", text);

                RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            String errormsg = "Ocurrió un error al validar el formulario.";
            req.setAttribute("errormsg", errormsg);
            req.setAttribute("errors", errors);
            req.setAttribute("text", text);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }

}

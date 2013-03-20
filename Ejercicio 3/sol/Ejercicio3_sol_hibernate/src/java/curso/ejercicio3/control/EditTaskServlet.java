package curso.ejercicio3.control;

import curso.ejercicio3.db.PersistenceException;
import curso.ejercicio3.db.PersistenceUtils;
import curso.ejercicio3.db.Task;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

@WebServlet(name = "EditTaskServlet", urlPatterns = {"/edit"})
public class EditTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {}

        Session s = PersistenceUtils.createSession();

        Task task = Task.findById(s, id);

        if (task != null) {
            req.setAttribute("task", task);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/edit_form.jsp");
            dispatcher.forward(req, resp);
        } else {
            throw new ServletException("Task not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {}
        String text = req.getParameter("text");

        Session s = PersistenceUtils.createSession();

        Task task = Task.findById(s, id);

        if (task != null) {
            task.setText(text);
            try {
                task.update(s);

                String base = req.getServletContext().getContextPath();
                resp.sendRedirect(base + "/index");
            } catch (PersistenceException e) {
                throw new ServletException(e);
            }
        } else {
            throw new ServletException("Task not found");
        }
    }
}

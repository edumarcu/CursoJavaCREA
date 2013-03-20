package curso.ejercicio3.control;

import curso.ejercicio3.db.PersistenceException;
import curso.ejercicio3.db.PersistenceUtils;
import curso.ejercicio3.db.Task;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

@WebServlet(name = "DoneTaskServlet", urlPatterns = {"/done"})
public class DoneTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {}

        Session s = PersistenceUtils.createSession();

        Task task = Task.findById(s, id);

        if (task != null) {
            task.setDone(true);

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

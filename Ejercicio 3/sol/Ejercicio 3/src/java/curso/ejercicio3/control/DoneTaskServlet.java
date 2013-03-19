package curso.ejercicio3.control;

import curso.ejercicio3.db.PersistenceException;
import curso.ejercicio3.db.PersistenceUtils;
import curso.ejercicio3.db.Task;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DoneTaskServlet", urlPatterns = {"/done"})
public class DoneTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {}

        EntityManager em = PersistenceUtils.createEntityManager();

        Task task = Task.findById(em, id);

        if (task != null) {
            task.setDone(true);

            try {
                task.update(em);

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

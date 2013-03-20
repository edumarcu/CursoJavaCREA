package curso.ejercicio3.control;

import curso.ejercicio3.db.PersistenceException;
import curso.ejercicio3.db.PersistenceUtils;
import curso.ejercicio3.db.Task;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditTaskServlet", urlPatterns = {"/edit"})
public class EditTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {}

        EntityManager em = PersistenceUtils.createEntityManager();

        Task task = Task.findById(em, id);

        if (task != null) {
            req.setAttribute("task", task);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/edit_form.jsp");
            dispatcher.forward(req, resp);
        } else {
            throw new ServletException("Task not found");
        }
    }
}

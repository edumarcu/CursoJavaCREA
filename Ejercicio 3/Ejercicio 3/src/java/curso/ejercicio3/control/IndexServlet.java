package curso.ejercicio3.control;

import curso.ejercicio3.db.PersistenceUtils;
import curso.ejercicio3.db.Task;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IndexServlet", urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Prepare Tasks
        EntityManager em = PersistenceUtils.createEntityManager();
        List<Task> todo = Task.findAllByDone(em, false);
        List<Task> done = Task.findAllByDone(em, true);
        em.close();

        // redirect to view
        req.setAttribute("todo", todo);
        req.setAttribute("done", done);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/index.jsp");
        dispatcher.forward(req, resp);
    }
}

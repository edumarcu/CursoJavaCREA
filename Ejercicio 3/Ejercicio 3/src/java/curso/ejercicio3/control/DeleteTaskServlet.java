package curso.ejercicio3.control;

import curso.ejercicio3.db.PersistenceUtils;
import curso.ejercicio3.db.Task;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteTaskServlet", urlPatterns = {"/delete"})
public class DeleteTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // For application Attributes
        ServletContext application = getServletContext();

        // Retrieve parameter "id"
        int id = Integer.parseInt(req.getParameter("id"));

        // Retrieve task from database
        EntityManager em = PersistenceUtils.createEntityManager();
        Task deleteTask = Task.findById(em, id);

        // Delete task from database
        try {
            deleteTask.delete(em);
        } catch (Exception e) {
            //TODO: Exception handling
        }
        em.close();

        // Redirect to index
        String base = (String) application.getAttribute("base");
        resp.sendRedirect(base + "/index");
    }
}

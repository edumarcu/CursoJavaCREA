package curso.ejercicio3.control;

import curso.ejercicio3.db.PersistenceUtils;
import curso.ejercicio3.db.Task;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditTaskServlet", urlPatterns = {"/edit"})
public class EditTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Retrieve parameter "id"
        int id = Integer.parseInt(req.getParameter("id"));

        // Retrieve task from database
        EntityManager em = PersistenceUtils.createEntityManager();
        Task editTask = Task.findById(em, id);
        em.close();

        // Task as attribute
        req.setAttribute("task", editTask);

        // Forward to edit_form
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/edit_form.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         // For application Attributes
        ServletContext application = getServletContext();

        // Retrieve parameter "id"
        int id = Integer.parseInt(req.getParameter("id"));

        // Retrieve task from database
        EntityManager em = PersistenceUtils.createEntityManager();
        Task editTask = Task.findById(em, id);

        // Retrieve parameter "text"
        String text = req.getParameter("text");

        // Update Text
        editTask.setText(text);

        // Update task on database
        try {
            editTask.update(em);
        } catch (Exception e) {
            //TODO: Exception handling
        }
        em.close();

        // Redirect to index
        String base = (String) application.getAttribute("base");
        resp.sendRedirect(base + "/index");
    }
}

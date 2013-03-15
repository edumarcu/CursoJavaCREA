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

@WebServlet(name = "AddTaskServlet", urlPatterns = {"/add"})
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/add_form.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // For application Attributes
        ServletContext application = getServletContext();

        // Retrieve parameter "text"
        String text = req.getParameter("text");
        // TODO: validate acentos (Jesús)

        // Create new task
        Task newTask = new Task();
        newTask.setText(text);
        newTask.setDone(false);

        // Save task on database
//        EntityManager em = (EntityManager) application.getAttribute("em");
        EntityManager em = PersistenceUtils.createEntityManager();
        try {
            newTask.create(em);
        } catch (Exception e) {

        }
        em.close();

        // Redirect to index
        String base = (String) application.getAttribute("base");
        resp.sendRedirect(base + "/index");
    }
}

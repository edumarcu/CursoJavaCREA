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

@WebServlet(name = "AddTaskServlet", urlPatterns = {"/add"})
public class AddTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/add_form.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: Retrieve parameter "text"

        // TODO: Create new task

        // TODO: Save task on database

        // TODO: Redirect to index
    }
}

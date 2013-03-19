package servlets;

import curso.ejercicio3.db.Task;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "TaskListServlet", urlPatterns = {"/tasks"})
public class TaskListServlet extends HttpServlet {

    @PersistenceContext(unitName = "33_InjectionPU")
    EntityManagerFactory emf;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        PrintWriter out = resp.getWriter();
        List<Task> tasks = Task.findAllByDone(em, true);
        tasks.addAll(Task.findAllByDone(em, false));

        for (Iterator<Task> it = tasks.iterator(); it.hasNext();) {
            Task task = it.next();

            out.println("<p>" + task.getText() + "</p>");

        }


    }



}

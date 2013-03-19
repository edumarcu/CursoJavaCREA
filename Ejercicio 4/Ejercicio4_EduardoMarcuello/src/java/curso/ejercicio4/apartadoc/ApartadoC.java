package curso.ejercicio4.apartadoc;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ApartadoC", urlPatterns = {"/c"})
public class ApartadoC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = PersistenceUtils.createEntityManager();
        req.setAttribute("entries", LogEntry.findAll(em));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/c.jsp");
        dispatcher.forward(req, resp);
    }

}

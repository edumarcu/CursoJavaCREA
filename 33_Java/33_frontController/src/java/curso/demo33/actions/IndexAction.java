package curso.demo33.actions;

import curso.demo33.util.Action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EM
 */
public class IndexAction extends Action {

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // indicamos lo que va a devolver el response, en la cabecera HTTP (el la HTML lo hacemos en el JSP)
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("name") == null) {
            session.setAttribute("name", "Desconocido");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/index.jsp");
        dispatcher.forward(request, response);
    }

}

package curso.demo33.actions;

import curso.demo33.util.Action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EM
 */
public class RenameAction extends Action {

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String newName = request.getParameter("name");
        session.setAttribute("name", newName);

        response.sendRedirect(base + "/html/index");
    }

}

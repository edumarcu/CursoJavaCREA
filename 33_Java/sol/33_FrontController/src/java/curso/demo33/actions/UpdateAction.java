package curso.demo33.actions;

import curso.demo33.util.Action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateAction extends Action{

    @Override
    public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        System.out.println(request.getCharacterEncoding());
        System.out.println(name);

        HttpSession session = request.getSession();
        session.setAttribute("name", name);

        response.sendRedirect(base + "/html/index");
    }

}

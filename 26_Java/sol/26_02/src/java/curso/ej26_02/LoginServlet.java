/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ej26_02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author golo
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String passw = req.getParameter("passw");

        User user = UserStorage.getUserByLoginAndPassword(login, passw);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
        }

        resp.sendRedirect("index.jsp");
    }

}
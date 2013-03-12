/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ej26_02;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author golo, EM
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("passw");

        //  Check login and password
        User user = UserStorage.getUserByLoginAndPassword(login, password);

        //  If correct, save login on session
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(5);

        if (user != null) {
            session.setAttribute("login", login);
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("message", "User or Pass not valid");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
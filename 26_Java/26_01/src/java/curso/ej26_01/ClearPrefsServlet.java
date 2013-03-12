package curso.ej26_01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClearPrefsServlet", urlPatterns = {"/clearPrefs"})
public class ClearPrefsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie styleCookie = new Cookie("style", "");
        styleCookie.setMaxAge(0);
        resp.addCookie(styleCookie);

        resp.sendRedirect("index.jsp");
    }
}

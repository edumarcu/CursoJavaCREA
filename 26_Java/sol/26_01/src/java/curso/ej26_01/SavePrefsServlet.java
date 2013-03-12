package curso.ej26_01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SavePrefsServlet", urlPatterns = {"/savePrefs"})
public class SavePrefsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String styleParam = req.getParameter("styleParam");
        Cookie stylePrefCookie = new Cookie("stylePref", styleParam);
        resp.addCookie(stylePrefCookie);

        resp.sendRedirect("index.jsp");
    }
}

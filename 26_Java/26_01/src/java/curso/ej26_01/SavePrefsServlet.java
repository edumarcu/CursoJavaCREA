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
        String style = req.getParameter("style");
        Cookie styleCookie = null;

        // Save style on a cookie
        switch (style) {
            case "black":
                styleCookie = new Cookie("style", "black");
                break;
             case "blue":
                styleCookie = new Cookie("style", "blue");
                break;
            case "green":
                styleCookie = new Cookie("style", "green");
                break;
            case "red":
                styleCookie = new Cookie("style", "red");
                break;
        }

        if (styleCookie != null) {
            styleCookie.setComment("black, blue, green, red");
            // color.setDomain("");
            // color.setPath("");
            // color.setHttpOnly(true);
            // color.setSecure(false);
            styleCookie.setMaxAge(10);
        }

        // Send cookie to client
        resp.addCookie(styleCookie);

        resp.sendRedirect("index.jsp");
    }
}

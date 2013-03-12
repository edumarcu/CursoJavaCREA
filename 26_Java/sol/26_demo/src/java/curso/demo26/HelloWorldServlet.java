package curso.demo26;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

    private String greeting;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String language = config.getInitParameter("language");
        if (language.equals("es")) {
            greeting = "Hola mundo!";
        } else {
            greeting = "Hello World!";
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(greeting + "  " + this);
    }
}

package curso.demo33.util;

import curso.demo33.actions.IndexAction;
import curso.demo33.actions.RenameAction;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/html/*"})
public class Controller extends HttpServlet {

    public final static String GET = "GET";
    public final static String POST = "POST";

    private final static Map<String, Action> actions_get;
    private final static Map<String, Action> actions_post;

    static {
        actions_get = new HashMap<String, Action>();
        actions_get.put("index", new IndexAction());


        actions_post = new HashMap<String, Action>();
        actions_post.put("rename", new RenameAction());
    }

    private void processRequest(
            String method,
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // Set Encoding UTF-8
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }

        //
        // Fetch action from URI
        //
        String uri = request.getRequestURI();
        String pattern  = "^.*/html/(.*)$";
        Matcher matcher = Pattern.compile(pattern).matcher(uri);

        String action = null;
        if (matcher.find()) {
            action = matcher.group(1);
        }
        if (action == null || action.equals("")) {
            action = "index";
        }

        //
        // Fetch the Action instance for the action parameter
        //
        Action actionInstance = null;
        if (method == GET) {
            actionInstance = actions_get.get(action);
        } else if (method == POST) {
            actionInstance = actions_post.get(action);
        } else {
            // TODO: throw error
            return;
        }

        if (actionInstance == null) {
            // TODO: throw error
            return;
        }

        //
        // Run action lyfecycle
        //
        // Init
        String base = getServletContext().getContextPath();
        actionInstance.setBase(base);
        request.setAttribute("base", base);

        // Execution
        actionInstance.doAction(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(GET, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(POST, req, resp);
    }


}

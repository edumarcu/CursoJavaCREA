package demo32.servlet;

import demo32.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = {"/servlet/user"}
        ,asyncSupported = true)
public class UserServlet extends HttpServlet {

    List<User> users;

    @Override
    public void init() throws ServletException {
        users = new ArrayList<User>();
        users.add(new User(1, "fry"));
        users.add(new User(2, "bender"));
        users.add(new User(3, "leela"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idparam = req.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idparam);
        } catch (Exception e) {}

        if (id > 0) {
            User user = null;
            for (User u : users) {
                if (u.getId() == id ) { user = u; break;}
            }

            if (user != null) {
                resp.getWriter().print(user.toJSON());
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < users.size(); i++) {
                sb.append(users.get(i).toJSON());
                if (i < (users.size() - 1)) {
                    sb.append(",");
                }
            }
            sb.append("]");
            resp.getWriter().print(sb.toString());
        }
    }

}

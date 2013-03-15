package demo32.services;

import demo32.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

@Path("/user")
public class UserResource {

    private static List<User> users;

    static {
        users = new ArrayList<User>();
        users.add(new User(1, "fry"));
        users.add(new User(2, "bender"));
        users.add(new User(3, "leela"));
    }

    @Context
    HttpServletRequest request;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public User getUser(@PathParam("id") Integer id) {
        for (User u : users) {
            if (u.getId() == id ) { return u; }
        }
        return null;
    }

    @GET
    @Produces("application/json")
    public List<User> getUsers() {
        return users;
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public boolean deleteUser(@PathParam("id") Integer id) {
        User user = null;
        for (User u : users) {
            if (u.getId() == id ) { user = u; break; }
        }

        if (user != null) {
            users.remove(user);
            return true;
        } else {
            return false;
        }
    }

    @POST
    @Produces("application/json")
    public boolean createUser(@FormParam("id") int id, @FormParam("name") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);

        users.add(user);
        return true;
    }

    @PUT
    @Path("/{id}")
    @Produces("application/json")
    public boolean editUser(@PathParam("id") Integer id) {
        User user = getUser(id);
        user.setName(request.getParameter("name"));

        return true;
    }
}

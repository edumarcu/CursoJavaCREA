package demo32.services;

import demo32.User;
import java.util.ArrayList;
import java.util.List;
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

/**
 * REST Web Service
 *
 * @author EM
 */
@Path("/user")
// estare en /webresources
public class UserResource {

    private static List<User> users;

    static {
        users = new ArrayList<User>();
        users.add(new User(1, "fry"));
        users.add(new User(2, "bender"));
        users.add(new User(3, "leela"));
    }

    @Context
    private UriInfo context;

    @GET
    @Path("/{id}")
    @Produces("application/json") // toJSON usa JAXB
    // el parametro el lo ha puesto como Integer
    public User getUser(@PathParam("id") int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @GET
    @Produces("application/json")
    // el parametro el lo ha puesto como Integer
    public List<User> getUsers() {
        return users;
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public void deleteUser(@PathParam("id") int id) {
        User userToDelete = null;

        // no se puede eliminar un elemento mientras se recoren las coelcciones
        for (User u : users) {
            if (u.getId() == id) {
                userToDelete = u;
                break;
            }
        }
        if (userToDelete != null) {
            users.remove(userToDelete);
        }
    }
/*
    @POST
    @Path("/{id/{name}")
    @Produces("application/json")
    public void createUser(@PathParam("id") int id, @PathParam("name") String name) {
        users.add(new User(id, name));
    }
*/
    // parametros de form
    @PUT
    @Produces("application/json")
    public void updateUser(@FormParam("id") int id, @FormParam("name") String name) {
        User userToUpdate = null;

        for (User u : users) {
            if (u.getId() == id) {
                userToUpdate = u;
                break;
            }
        }
        if (userToUpdate != null) {
            userToUpdate.setName(name);
        }
    }
}

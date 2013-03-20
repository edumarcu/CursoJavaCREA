package curso.ejercicio3.rest;

import curso.ejercicio3.db.PersistenceException;
import curso.ejercicio3.db.PersistenceUtils;
import curso.ejercicio3.db.Task;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("task")
public class TaskService {

    @POST
    @Consumes({"application/json"})
    public void create(Task task) throws PersistenceException {
        EntityManager em = PersistenceUtils.createEntityManager();
        task.create(em);
    }

    @PUT
    @Consumes({"application/json"})
    public void edit(Task task) throws PersistenceException {
        EntityManager em = PersistenceUtils.createEntityManager();
        task.update(em);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) throws PersistenceException {
        EntityManager em = PersistenceUtils.createEntityManager();
        Task.findById(em, id).delete(em);
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Task find(@PathParam("id") Integer id) {
        EntityManager em = PersistenceUtils.createEntityManager();
        return Task.findById(em, id);
    }

    @GET
    @Produces({"application/json"})
    public HashMap<String, List<Task>> findAll() {
        EntityManager em = PersistenceUtils.createEntityManager();
        HashMap<String, List<Task>> tasks = new HashMap<String, List<Task>>();
        tasks.put("todo", Task.findAllByDone(em, false));
        tasks.put("done", Task.findAllByDone(em, true));
        return tasks;
    }

    @POST
    @Path("{id}/done")
    public void setDone(@PathParam("id") Integer id) throws PersistenceException {
        EntityManager em = PersistenceUtils.createEntityManager();
        Task task = Task.findById(em, id);
        task.setDone(true);
        task.update(em);
    }

    @POST
    @Path("{id}/todo")
    public void setTodo(@PathParam("id") Integer id) throws PersistenceException {
        EntityManager em = PersistenceUtils.createEntityManager();
        Task task = Task.findById(em, id);
        task.setDone(false);
        task.update(em);
    }
}

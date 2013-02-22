package curso.demo22;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * ORM for cursoDemoPU, Relationships Task in user
 * @author EM
 */
public class Demo06 {
    public static void main(String[] args) {
        //Create ORM
        System.out.println("Creating ORM...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();
        System.out.println("OK!");

        System.out.println();
        System.out.println("USERS");
        User user = em.find(User.class, 2L);
        System.out.println("User: " + user);

        // Con LAzy solo carga los datos cuando se necesitan (con ToString no..)
        System.out.println("Tasks(" + user.getTasks().size() + "): " + user.getTasks());

        System.out.println();
        System.out.println("TASKS");
        Task task = em.find(Task.class, 2L);
        System.out.println("Task: " + task);

        System.out.println("User: " + task.getUser());

    }
}

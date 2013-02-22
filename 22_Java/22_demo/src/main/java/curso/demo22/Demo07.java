package curso.demo22;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * ORM for cursoDemoPU, Relationships persistance
 * @author EM
 */
public class Demo07 {
    public static void main(String[] args) {
        //Create ORM
        System.out.println("Creating ORM...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        System.out.println("OK!");

        System.out.println();
        System.out.println("USERS");
        User user = new User();
        user.setName("Perico Lospal Otes");

        em.persist(user);
        em.flush();
        System.out.println("Persisted User: " + em.find(User.class, user.getId()));

        System.out.println();
        System.out.println("TASKS");
        Task task = new Task();
        task.setDescription("Jugar al futbol");
        task.setUser(user);

        em.persist(task);
        em.flush();
        System.out.println("Persisted Task: " + em.find(Task.class, task.getId()));

        et.commit();
        System.out.println();
        System.out.println("USER - TASKS");
        em.refresh(user); // <-------------------------------
        System.out.println("Tasks(" + em.find(User.class, user.getId()).getTasks().size() + "): " +
                em.find(User.class, user.getId()).getTasks());

        em.close();

//        // Con LAzy solo carga los datos cuando se necesitan (con ToString no..)
//        System.out.println("Tasks(" + user.getTasks().size() + "): " + user.getTasks());
//
//        System.out.println();
//        System.out.println("TASKS");
//        Task task = em.find(Task.class, 2L);
//        System.out.println("Task: " + task);
//
//        System.out.println("User: " + task.getUser());

    }
}

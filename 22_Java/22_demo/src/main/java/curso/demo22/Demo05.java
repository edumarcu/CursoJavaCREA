package curso.demo22;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * ORM for cursoDemoPU, Relationships
 * @author EM
 */
public class Demo05 {
    public static void main(String[] args) {
        //Create ORM
        System.out.println("Creating ORM...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();
        System.out.println("OK!");

        String sql = "SELECT t FROM Task t WHERE t.userId = :userid";
        TypedQuery<Task> query = em.createQuery(sql, Task.class);
        query.setParameter("userid", 2L);

        System.out.println(query.getResultList());

    }
}

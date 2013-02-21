package curso.demo22;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * ORM for cursoDemoPU, EntityManagerFactory
 * @author EM
 */
public class Demo01 {
    public static void main(String[] args) {
        //Create ORM
        System.out.println("Creating ORM...");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        System.out.println("OK!");

        // Find
        User user = em.find(User.class, 1L);
        System.out.println("Find User (1): " + user);

        // EJB QL
        String eql = "SELECT u FROM User u";
        TypedQuery<User> typedQuery = em.createQuery(eql, User.class);
        List<User> result = typedQuery.getResultList();
        System.out.println("EJB QL Users: " + result);
    }
}

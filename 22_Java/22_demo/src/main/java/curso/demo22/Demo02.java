package curso.demo22;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * ORM for cursoDemoPU, Persist
 * @author EM
 */
public class Demo02 {
    public static void main(String[] args) {
        //Create ORM
        System.out.println("Creating ORM...");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        System.out.println("OK!");

        // Persist
        User user =new User( );
        user.setName("Jesusinín " + String.format("%.0f", Math.random() * 10));
        System.out.println("User: " + user);

        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
                em.persist(user);
                em.flush();
                et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            et.rollback();
        }

        System.out.println("User: " + user);

    }
}

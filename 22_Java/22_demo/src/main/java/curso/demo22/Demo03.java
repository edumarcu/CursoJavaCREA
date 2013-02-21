package curso.demo22;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * ORM for cursoDemoPU, Update
 * @author EM
 */
public class Demo03 {
    public static void main(String[] args) {
        //Create ORM
        System.out.println("Creating ORM...");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        System.out.println("OK!");

        // Persist
        /* Objeto no gestionado, hace falta Merge */
//        User user =new User( );
//        user.setId(3);
//        user.setName("Jhonny");

        /* Objeto gestionado (buscado en BD, no hace falta merge) */
        User user = em.find(User.class, 3L);
        user.setName("Marta");

        System.out.println("User: " + user);

        EntityTransaction et = em.getTransaction();
        et.begin();

        try {
//                user = em.merge(user);
                em.flush();
                et.commit();
        } catch (Exception e) {

            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }

        System.out.println("User: " + user);

    }
}

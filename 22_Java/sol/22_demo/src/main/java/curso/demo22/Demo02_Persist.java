package curso.demo22;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo02_Persist {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        User user = new User();
        user.setName("Pedro " + Math.random());

        System.out.println(user);

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(user);
            em.flush();

            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }

        System.out.println(user);
    }
}

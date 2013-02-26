package curso.demo22;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public class Demo03_Delete {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 7l);

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.remove(user);
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

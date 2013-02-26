package curso.demo22;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo04_Count {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Long> query = em.createQuery("SELECT Count(x) FROM User x", Long.class);
        Long number = (Long) query.getSingleResult();
        System.out.println("number: " +  number);

    }
}

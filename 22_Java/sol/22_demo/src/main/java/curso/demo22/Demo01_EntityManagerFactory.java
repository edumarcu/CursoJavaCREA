package curso.demo22;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo01_EntityManagerFactory {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1l);
        System.out.println("USER: " + user);

        // EJB QL
        String eql = "SELECT x FROM User x ORDER BY x.id";
        TypedQuery<User> query = em.createQuery(eql, User.class);
        List<User> users = query.getResultList();

        System.out.println("Users");
        for (User u : users) {
            System.out.println(u);
        }
    }
}

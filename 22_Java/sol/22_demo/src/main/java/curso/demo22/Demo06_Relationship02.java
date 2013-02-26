package curso.demo22;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo06_Relationship02 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 2l);
        System.out.println("USER: " + user);

//        em.close();
//        emf.close();
//
//        System.out.println(user.getTasks());
//        System.out.println(user.getTasks().size());
//        System.out.println(user.getTasks());

        for (Task task: user.getTasks()) {
            System.out.println("\t" + task.getDescription() + " - "
                    + task.getUser());
        }

    }
}

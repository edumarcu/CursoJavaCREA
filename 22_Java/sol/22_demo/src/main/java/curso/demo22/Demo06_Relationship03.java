package curso.demo22;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo06_Relationship03 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 2l);
        System.out.println("USER: " + user);

        EntityTransaction et = em.getTransaction();
        et.begin();

        user.getTasks().size();

        Task task = new Task();
        task.setUser(user);
        task.setDescription("Hacer otro ejercicio otra vez");
        task.setEstimationText("3:45");
        user.getTasks().add(task);

        em.flush();

        et.commit();

    }
}

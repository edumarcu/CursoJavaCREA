package curso.demo22;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Demo05_Relationship01 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        String sql = "SELECT x FROM Task x WHERE x.userId = :userid";
        TypedQuery<Task> query = em.createQuery(sql, Task.class);
        query.setParameter("userid", 2l);

        List<Task> tasks = query.getResultList();
        for (Task task : tasks) {
            System.out.println(task.getDescription() + " " + task.getEstimationText());
        }
    }
}

package curso.demo22;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo03_Update {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1l);
        user.setName("GoLo Actualizado");
//        User user = new User();
//        user.setId(7);
//        user.setName("Pedro Actualizado" + Math.random());

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
// Merge mezcla un objeto no gestionado con los campos del objeto gestionado
// Busca el objeto gestionado correspondiente por su id.
// Devuelve el objeto gestionado actualizado.
//            user = em.merge(user);
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

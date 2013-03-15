package curso.ejercicio3.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name="tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length=100, nullable=false, unique=true)
    private String text;

    @Column(nullable=false)
    private boolean done;

    public Task() {
    }

    public Task(int id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // Utils
    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", text=" + text + '}';
    }

    // Active Record - Find Methods
    public static Task findById(EntityManager em, int id) {
        // TODO:
        return null;
    }

    public static List<Task> findAll(EntityManager em, int id) {
        // TODO:
        return null;
    }

    public static List<Task> findAllByDone(EntityManager em, boolean done) {
        String sql = "SELECT t FROM Task t WHERE t.done = :done";
        TypedQuery<Task> query = em.createQuery(sql, Task.class);
        query.setParameter("done", done);

        return query.getResultList();
    }

    // Active Record - Data Modifying Methods
    public void create(EntityManager em) throws PersistenceException {

        EntityTransaction et = em.getTransaction();
        if (em.find(Task.class, this.getId()) != null) {
            throw new PersistenceException(this.toString() + " already exists!");

        } else {
            try {
                et.begin();
                em.persist(this);
                em.flush();
                et.commit();

            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }

                throw new PersistenceException("Error persisting " + this.toString());
            }
        }
    }

    public Task update(EntityManager em) throws PersistenceException {
        // TODO:
        return null;
    }

    public void delete(EntityManager em) throws PersistenceException {
        // TODO:
    }
}

package curso.ejercicio3.db;

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
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255, nullable = false)
    private String text;
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
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

    // Active Record - Find Methods
    public static Task findById(EntityManager em, int id) {
        return em.find(Task.class, id);
    }

    public static List<Task> findAll(EntityManager em, int id) {
        TypedQuery<Task> query = em.createQuery("SELECT x FROM Task x ORDER BY x.id ASC", Task.class);
        return query.getResultList();
    }

    public static List<Task> findAllByDone(EntityManager em, boolean done) {
        TypedQuery<Task> query = em.createQuery("SELECT x FROM Task x WHERE x.done = :done ORDER BY x.id ASC", Task.class);
        query.setParameter("done", done);
        return query.getResultList();
    }

    // Active Record - Data Modifying Methods
    public void create(EntityManager em) throws PersistenceException {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(this);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new PersistenceException("Error while creating Task", e);
        }
    }

    public Task update(EntityManager em) throws PersistenceException {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Task task = em.merge(this);
            et.commit();
            return task;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new PersistenceException("Error while updating Task", e);
        }
    }

    public void delete(EntityManager em) throws PersistenceException {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.remove(this);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            throw new PersistenceException("Error while deleting Task", e);
        }
    }
}

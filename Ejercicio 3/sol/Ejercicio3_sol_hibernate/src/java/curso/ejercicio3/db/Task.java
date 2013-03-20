package curso.ejercicio3.db;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Task {

    private int id;

    private String text;

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
    public static Task findById(Session s, int id) {
        return (Task) s.get(Task.class, id);
    }

    public static List<Task> findAll(Session s, int id) {
        Query query = s.createQuery("SELECT x FROM Task x ORDER BY x.id ASC");
        return query.list();
    }

    public static List<Task> findAllByDone(Session s, boolean done) {
        Query query = s.createQuery("SELECT x FROM Task x WHERE x.done = :done ORDER BY x.id ASC");
        query.setParameter("done", done);
        return query.list();
    }

    // Active Record - Data Modifying Methods
    public void create(Session s) throws PersistenceException {
        Transaction t = s.beginTransaction();
        t.begin();
        try {
            s.persist(this);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) {
                t.rollback();
            }
            throw new PersistenceException("Error while creating Task", e);
        }
    }

    public Task update(Session s) throws PersistenceException {
        Transaction t = s.beginTransaction();
        t.begin();
        try {
            Task task = (Task) s.merge(this);
            t.commit();
            return task;
        } catch (Exception e) {
            if (t.isActive()) {
                t.rollback();
            }
            throw new PersistenceException("Error while updating Task", e);
        }
    }

    public void delete(Session s) throws PersistenceException {
        Transaction t = s.beginTransaction();
        t.begin();
        try {
            s.delete(this);
            t.commit();
        } catch (Exception e) {
            if (t.isActive()) {
                t.rollback();
            }
            throw new PersistenceException("Error while deleting Task", e);
        }
    }
}

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

// TODO: Annotate
public class Task {

    // TODO: Annotate
    private int id;

    // TODO: Annotate
    private String text;

    // TODO: Annotate
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
        // TODO:
        return null;
    }

    public static List<Task> findAll(EntityManager em, int id) {
        // TODO:
        return null;
    }

    public static List<Task> findAllByDone(EntityManager em, boolean done) {
        // TODO:
        return null;
    }

    // Active Record - Data Modifying Methods
    public void create(EntityManager em) throws PersistenceException {
        // TODO:
    }

    public Task update(EntityManager em) throws PersistenceException {
        // TODO:
        return null;
    }

    public void delete(EntityManager em) throws PersistenceException {
        // TODO:
    }
}

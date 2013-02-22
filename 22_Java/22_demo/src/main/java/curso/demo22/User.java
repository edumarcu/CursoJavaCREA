package curso.demo22;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User implements Serializable {

    private final static long serialVersionUID = 1L;    // lo cambiariamos conforme cambia la clase

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(length=255, name="name")
    private String name;

//    @Transient  // ignora el campo
    @OneToMany(cascade=CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name="user_id",referencedColumnName="id", nullable=false)
    private List<Task> tasks;

    public User() {
        id = 0;
        name = null;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    // Equals & HashCode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    // to String

    @Override
    public String toString() {
        return "#" + id + " " + name;
    }

    /**
     * Active Record
     */
    // Queries

    public static User findById(EntityManager em, long id) {
        return  em.find(User.class, id);
    }

    public static List<User> findByPage(EntityManager em, int page, int usersByPage) {
        Query q = em.createNativeQuery("SELECT id, name FROM User u ORDER BY id LIMIT " +
                (page - 1) * usersByPage + "," + usersByPage, User.class);

        return  q.getResultList();
    }

    public static long count(EntityManager em) {
        Query q = em.createNativeQuery("SELECT COUNT(*) FROM User u");

        return (long) q.getSingleResult();
    }

    // Modifications
    public boolean create(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            createNoTransaction(em);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }
        return true;
    }

    public boolean createNoTransaction(EntityManager em) {
        try {
            em.persist(this);
            em.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            updateNoTransaction(em);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }
        return true;
    }

    public boolean updateNoTransaction(EntityManager em) {
        User user = em.find(User.class, this.id);
        user.setName(this.name);
        try {
            em.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            deleteNoTransaction(em);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }
        return true;
    }

    public boolean deleteNoTransaction(EntityManager em) {
        try {
            em.remove(this);
            em.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
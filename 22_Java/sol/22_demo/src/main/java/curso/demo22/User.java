package curso.demo22;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

@Entity
@Table(name="users")
public class User implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, name="id")
    private long id;

    @Column(unique=true, length=255, name="name")
    private String name;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="user_id"              // Column from tasks table
            , referencedColumnName="id"     // Column from users table.
                                            // By default, uses @Id column.
            , nullable=false)
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

    //
    // Active Record
    //

    // Queries

    public static User findById(EntityManager em, long id) {
        return em.find(User.class, id);
    }

    public static List<User> findByPage(EntityManager em, int page, int usersPerPage) {

        String sql = "SELECT u FROM User u ORDER BY u.id";
        TypedQuery<User> query = em.createQuery(sql, User.class);
        query.setFirstResult((page - 1) * usersPerPage);
        query.setMaxResults(usersPerPage);
        return query.getResultList();

        //
/*
        String sql = "SELECT u.* FROM users u ORDER BY u.id Limit ?,?";
        Query query = em.createNativeQuery(sql, User.class);
        query.setParameter(1, (page - 1) * usersPerPage);
        query.setParameter(2, usersPerPage);
        return query.getResultList();
        */
    }

    public static long count(EntityManager em) {
        String sql = "SELECT Count(x) FROM User x";
        TypedQuery<Long> query = em.createQuery(sql, Long.class);
        return query.getSingleResult();
    }

    // Modifications

    public boolean create(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            createNoTransaction(em);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }
    }

    public void createNoTransaction(EntityManager em) {
        em.persist(this);
        em.flush();
    }

    public User update(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            User user = updateNoTransaction(em);
            et.commit();
            return user;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return null;
        }
    }

    public User updateNoTransaction(EntityManager em) {
        User user = em.merge(this);
        em.flush();
        return user;
    }

    public boolean delete(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            deleteNoTransaction(em);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        }
    }

    public void deleteNoTransaction(EntityManager em) {
        em.remove(this);
        em.flush();
    }
}

package curso.demo22;

import java.util.Date;   /* el lo coge de util */
import java.util.GregorianCalendar;
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
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="task")
public class Task {

    @Id
    @Column(name="id", unique=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

//    @Column(name="user_id")
//    private long userId;

    @Column(length=255)
    private String description;

    private double estimation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="completed_at")
    private Date completedAt;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;

    public Task() {

    }

    public Task(long id, long userId, String description, double  estimation, Date completedAt) {
        this.id = id;
//        this.userId = userId;
        this.description = description;
        this.estimation = estimation;
        this.completedAt = completedAt;
    }

    // to String

    @Override
    public String toString() {
        return "#" + id + ":" + description + " by " + user.getName() + " [" + getEstimationText() + "]";
    }

    /**
     * Active Record
     */
    // Queries

//    public static User findById(EntityManager em, long id) {
//        return  em.find(User.class, id);
//    }
//
//    public static List<User> findByPage(EntityManager em, int page, int usersByPage) {
//        Query q = em.createNativeQuery("SELECT id, name FROM User u ORDER BY id LIMIT " +
//                (page - 1) * usersByPage + "," + usersByPage, User.class);
//
//        return  q.getResultList();
//    }
//
//    public static long count(EntityManager em) {
//        Query q = em.createNativeQuery("SELECT COUNT(*) FROM User u");
//
//        return (long) q.getSingleResult();
//    }
//
//    // Modifications
//    public boolean create(EntityManager em) {
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        try {
//            createNoTransaction(em);
//            et.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (et.isActive()) {
//                et.rollback();
//            }
//            return false;
//        }
//        return true;
//    }
//
//    public boolean createNoTransaction(EntityManager em) {
//        try {
//            em.persist(this);
//            em.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    public boolean update(EntityManager em) {
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        try {
//            updateNoTransaction(em);
//            et.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (et.isActive()) {
//                et.rollback();
//            }
//            return false;
//        }
//        return true;
//    }
//
//    public boolean updateNoTransaction(EntityManager em) {
//        User user = em.find(User.class, this.id);
//        user.setName(this.name);
//        try {
//            em.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    public boolean delete(EntityManager em) {
//        EntityTransaction et = em.getTransaction();
//        et.begin();
//        try {
//            deleteNoTransaction(em);
//            et.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (et.isActive()) {
//                et.rollback();
//            }
//            return false;
//        }
//        return true;
//    }
//
//    public boolean deleteNoTransaction(EntityManager em) {
//        try {
//            em.remove(this);
//            em.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(long userId) {
//        this.userId = userId;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getEstimation() {
        return estimation;
    }

    public String getEstimationText() {
        return String.format("%02d:%02d", (int) estimation,  (int) ((estimation - (int) estimation) * 60));
    }

    public void setEstimation(double estimation) {
        this.estimation = estimation;
    }

    public void setEstimationText(String estimation) {
        /* 00:00 */
        this.estimation = Integer.parseInt(estimation.split(":")[0]) +  Integer.parseInt(estimation.split(":")[1]) / 60.0;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Hashcode & Equals

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Task other = (Task) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


}

package curso.ejercicio4.apartadoc;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TypedQuery;

@Entity
@Table(name="log_entries")
public class LogEntry implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false)
    private String ip;

    @Column(nullable=false)
    private String method;

    @Column(nullable=false)
    private String path;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "created_at", nullable=false)
    private Date createdAt;

    //

    public LogEntry() {
    }

    public LogEntry(int id, String ip, String method, String path, Date createdAt) {
        this.id = id;
        this.ip = ip;
        this.method = method;
        this.path = path;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "LogEntry{" + "id=" + id + ", ip=" + ip + ", method=" + method + ", path=" + path + ", createdAt=" + createdAt + '}';
    }

    // Active Record

    public static List<LogEntry> findAll(EntityManager em) {
        String sql = "SELECT log FROM LogEntry log";
        TypedQuery<LogEntry> query = em.createQuery(sql, LogEntry.class);

        return query.getResultList();
    }

    public void save(EntityManager em) {
       EntityTransaction et = em.getTransaction();
        if (em.find(LogEntry.class, this.getId()) != null) {
            //TODO: handle error

        } else {
            try {
                et.begin();
                em.persist(this);
                et.commit();

            } catch (Exception e) {
                if (et.isActive()) {
                    et.rollback();
                }

                // TODO: Handle error
            }
        }
    }
}

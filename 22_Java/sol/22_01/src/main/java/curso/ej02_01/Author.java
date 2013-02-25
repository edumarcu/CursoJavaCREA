package curso.ej02_01;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

@Entity
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(length=50, nullable=false)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(length=50)
    private String country;

    @OneToMany(fetch=FetchType.LAZY) //, mappedBy="author")
    @JoinColumn(name="author_id", referencedColumnName="id")
    private List<Book> books;

    public Author() {
    }

    public Author(long id, String name, Date birthday, String country) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.country = country;
    }

    // Getters && Setters

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // Equals & HashCode

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Author other = (Author) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    // to String

    @Override
    public String toString() {
        return this.getName();
    }

    //
    // Active Record
    //

    // Queries
    public static Author findById(EntityManager em, long id) {
        return em.find(Author.class, id);
    }

    public static boolean containsAuthor(EntityManager em, long id) {
        return em.find(Author.class, id) != null;
    }

    public static long count(EntityManager em) {
        String sql = "SELECT COUNT(x) FROM Author x";
        TypedQuery<Long> query = em.createQuery(sql, Long.class);
        Long count = query.getSingleResult();
        return count;
    }

    // Modifying

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
//            throw new Exception("Error saving user");
            e.printStackTrace();
            return false;
        }
    }

    public void createNoTransaction(EntityManager em) {
        em.persist(this);
        em.flush();
    }
}

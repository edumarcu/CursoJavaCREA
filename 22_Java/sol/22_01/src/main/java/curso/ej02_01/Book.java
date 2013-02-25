package curso.ej02_01;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name="books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(length=20, nullable=false, unique=true)
    private String isbn;

    @Column(length=255, nullable=false)
    private String title;

    private int year;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="author_id", referencedColumnName="id")
    private Author author;

    public Book() {
    }

    public Book(String isbn, String title, int year) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    // Equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + (this.isbn != null ? this.isbn.hashCode() : 0);
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
        final Book other = (Book) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.isbn == null) ? (other.isbn != null) : !this.isbn.equals(other.isbn)) {
            return false;
        }
        return true;
    }

    // to String

    @Override
    public String toString() {
        String authorName = (this.author != null) ? this.author.getName() : "Anónimo";
        return String.format("Book: %s (%d) by %s - ISBN %s", this.title, this.year, authorName, this.isbn);
    }

    //
    // Active Record
    //

    // Queries
    public static Book findById(EntityManager em, long id) {
        return em.find(Book.class, id);
    }

    public static boolean containsBook(EntityManager em, long id) {
        return em.find(Book.class, id) != null;
    }

    public static long count(EntityManager em) {
        String sql = "SELECT COUNT(x) FROM Book x";
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

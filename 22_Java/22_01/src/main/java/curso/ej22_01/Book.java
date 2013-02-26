package curso.ej22_01;

import java.io.Serializable;
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

    public Book(long id, String isbn, String title, int year) {
        this.id = id;
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

    // Active Record
    public static boolean contains(EntityManager em, Book b) {
        return (em.find(Book.class, b.getId()) != null);
    }

    public static long count(EntityManager em) {
        String sql = "SELECT COUNT(b) FROM Book b";
        TypedQuery<Long> query = em.createQuery(sql, Long.class);
        Long count = query.getSingleResult();
        return count;
    }

    public static List<Book> list(EntityManager em) {
        String sql = "SELECT b FROM Book b";
        TypedQuery<Book> query = em.createQuery(sql, Book.class);
        return query.getResultList();
    }

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

    public boolean remove(EntityManager em) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            removeNoTransaction(em);
            et.commit();
            return true;

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }

            return false;
        }
    }

    public void removeNoTransaction(EntityManager em) {
        em.remove(this);
        em.flush();
    }

}

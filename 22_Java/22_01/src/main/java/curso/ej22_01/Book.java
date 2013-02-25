package curso.ej22_01;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

}

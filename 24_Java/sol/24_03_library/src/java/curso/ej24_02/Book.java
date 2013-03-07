package curso.ej24_02;



import java.io.Serializable;

public class Book implements Serializable {

    private String isbn;

    private String title;

    private int year;

    private String author;

    public Book(String isbn, String title, int year, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    // Getters & Setters

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.isbn != null ? this.isbn.hashCode() : 0);
        hash = 41 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 41 * hash + this.year;
        hash = 41 * hash + (this.author != null ? this.author.hashCode() : 0);
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
        if ((this.isbn == null) ? (other.isbn != null) : !this.isbn.equals(other.isbn)) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if ((this.author == null) ? (other.author != null) : !this.author.equals(other.author)) {
            return false;
        }
        return true;
    }

    // to String

    @Override
    public String toString() {
        return String.format("Book: %s (%d) by %s - ISBN %s", this.title, this.year, this.author, this.isbn);
    }

}

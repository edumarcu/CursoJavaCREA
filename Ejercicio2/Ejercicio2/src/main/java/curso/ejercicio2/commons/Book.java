package curso.ejercicio2.commons;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable, Comparable<Book> {

    private String isbn;
    private String title;
    private int year;
    private String author;

//    public Book(String isbn, String title, int year, String author) {
//        // FIXME
//    }

    public Book(String isbn, String title, int year, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.isbn);
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + this.year;
        hash = 59 * hash + Objects.hashCode(this.author);
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
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

    public int compareTo(Book book) {

        return this.title.compareTo(book.title);
    }



    @Override
    public String toString() {
        return "Book: " + title + " (" + year + ") by " + author + " - ISBN " + isbn;
    }


}

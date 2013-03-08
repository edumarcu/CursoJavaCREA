package curso.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LibraryImpl implements Library {

    private Set<Book> books = new TreeSet<Book>(new BookTitleComparator());

    private HashMap<String, Book> booksByISBN = new HashMap<String, Book>();

    private HashMap<Integer, Set<Book>> booksByYear = new HashMap<Integer, Set<Book>>();

    private HashMap<String, Set<Book>> booksByAuthor = new HashMap<String, Set<Book>>();

    public synchronized boolean addBook(Book book) {
        boolean added = books.add(book);
        if (added) {
            booksByISBN.put(book.getIsbn(), book);
            indexBookByAuthor(book);
            indexBookByYear(book);
        }
        return added;
    }

    private void indexBookByYear(Book book) {
        Integer year = book.getYear();
        if (!booksByYear.containsKey(year)) {
            booksByYear.put(year, new HashSet<Book>());
        }
        booksByYear.get(year).add(book);
    }

    private void indexBookByAuthor(Book book) {
        String author = book.getAuthor();
        if (!booksByAuthor.containsKey(author)) {
            booksByAuthor.put(author, new HashSet<Book>());
        }
        booksByAuthor.get(author).add(book);
    }

    public synchronized boolean removeBook(Book book) {
        boolean removed = books.remove(book);
        if (removed) {
            booksByISBN.remove(book.getIsbn());
            booksByAuthor.get(book.getAuthor()).remove(book);
            booksByYear.get(book.getYear()).remove(book);
        }
        return removed;
    }

    public synchronized boolean containsBook(Book book) {
        return books.contains(book);
    }

    public synchronized List<Book> list() {
        return new ArrayList<Book>(books);
    }

    public synchronized Book findByISBN(String isbn) {
        return booksByISBN.get(isbn);
    }

    public synchronized List<Book> findByYear(int year) {
        List<Book> result = new ArrayList<Book>();
        Collection<Book> books = booksByYear.get(year);
        if (books != null) {
            result.addAll(books);
        }
        return result;
    }

    public synchronized List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<Book>();
        Collection<Book> books = booksByAuthor.get(author);
        if (books != null) {
            result.addAll(books);
        }
        return result;
    }
}

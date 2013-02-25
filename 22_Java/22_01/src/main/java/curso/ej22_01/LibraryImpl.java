package curso.ej22_01;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LibraryImpl implements Library {

    private Set<Book> books = new TreeSet<>(new BookTitleComparator());

    private HashMap<String, Book> booksByISBN = new HashMap<>();

    private HashMap<Integer, Set<Book>> booksByYear = new HashMap<>();

    private HashMap<Author, Set<Book>> booksByAuthor = new HashMap<>();

    @Override
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
        Author author = book.getAuthor();
        if (!booksByAuthor.containsKey(author)) {
            booksByAuthor.put(author, new HashSet<Book>());
        }
        booksByAuthor.get(author).add(book);
    }

    @Override
    public synchronized boolean removeBook(Book book) {
        boolean removed = books.remove(book);
        if (removed) {
            booksByISBN.remove(book.getIsbn());
            booksByAuthor.get(book.getAuthor()).remove(book);
            booksByYear.get(book.getYear()).remove(book);
        }
        return removed;
    }

    @Override
    public synchronized boolean containsBook(Book book) {
        return books.contains(book);
    }

    @Override
    public synchronized List<Book> list() {
        return new ArrayList<>(books);
    }

    @Override
    public synchronized Book findByISBN(String isbn) {
        return booksByISBN.get(isbn);
    }

    @Override
    public synchronized List<Book> findByYear(int year) {
        return new ArrayList<>(booksByYear.get(year));
    }

    @Override
    public synchronized List<Book> findByAuthor(Author author) {
        return new ArrayList<>(booksByAuthor.get(author));
    }
}

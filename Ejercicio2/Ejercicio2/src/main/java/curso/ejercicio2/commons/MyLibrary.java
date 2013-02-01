package curso.ejercicio2.commons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Interface Library implementation, TreeSet for Books List and Maps for Queries
 * @author EM
 */
public class MyLibrary implements Library {

    private Set<Book> books = new TreeSet<>();
    private Map<String, Book> queryIsbn = new HashMap<>();
    private Map<Integer, ArrayList<Book>> queryYear = new HashMap<>();
    private Map<String, ArrayList<Book>> queryAuthor = new HashMap<>();

    @Override
    public boolean addBook(Book book) {

        boolean added;

        added = books.add(book);
        if (added) {
            queryIsbn.put(book.getIsbn(), book);

            if (queryYear.get(book.getYear()) == null){
                queryYear.put(book.getYear(), new ArrayList<Book>());
            }
            queryYear.get(book.getYear()).add(book);
            Collections.sort(queryYear.get(book.getYear()));

            if (queryAuthor.get(book.getAuthor()) == null) {
                queryAuthor.put(book.getAuthor(), new ArrayList<Book>());
            }
            queryAuthor.get(book.getAuthor()).add(book);
            Collections.sort(queryAuthor.get(book.getAuthor()));
        }

        return added;
    }

    @Override
    public boolean removeBook(Book book) {

        boolean removed;

        removed = books.remove(book);
        if (removed) {
            queryIsbn.remove(book.getIsbn());
            queryYear.get(book.getYear()).remove(book);
            queryAuthor.get(book.getAuthor()).remove(book);
        }

        return removed;
    }

    @Override
    public boolean containsBook(Book book) {

        return books.contains(book);
    }

    @Override
    public List<Book> list() {

        return Collections.unmodifiableList(new ArrayList<>(books));
    }

    @Override
    public Book findByISBN(String isbn) {

        return queryIsbn.get(isbn);
    }

    @Override
    public List<Book> findByYear(int year) {

        return Collections.unmodifiableList(queryYear.get(year));
    }

    @Override
    public List<Book> findByAuthor(String author) {

       return Collections.unmodifiableList(queryAuthor.get(author));
    }


}

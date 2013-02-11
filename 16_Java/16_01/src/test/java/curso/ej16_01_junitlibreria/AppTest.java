package curso.ej16_01_junitlibreria;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class AppTest {

    LibraryImpl library;
    static Book book;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Creating Book for Test");
        book = new Book("0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997, "J. K. Rowling");
    }

    @Before
    public void beforeTest() {
        System.out.println("Creating Library for Test");

        library = new LibraryImpl();
    }

    @Test
    public void test_add() {

        library.addBook(book);
        assertTrue(library.containsBook(book));
        assertTrue(library.list().size() == 1);
    }

    @Test
    public void test_remove() {

        library.addBook(book);
        library.removeBook(book);
        assertFalse(library.containsBook(book));
        assertTrue(library.list().isEmpty());
    }

    @Test
    public void test_list() {

        library.addBook(book);
        List<Book> l = new ArrayList();
        l.add(book);
        assertEquals(library.list(), l);
    }

    @Test
    public void findByISBN() {

        library.addBook(book);
        assertEquals(library.findByISBN(book.getIsbn()), book);
    }

    @Test
    public void findByYear() {

        library.addBook(book);
        List<Book> l = new ArrayList();
        l.add(book);
        assertEquals(library.findByYear(book.getYear()), l);
    }

    @Test
    public void findByAuthor() {

        library.addBook(book);
        List<Book> l = new ArrayList();
        l.add(book);
        assertEquals(library.findByAuthor(book.getAuthor()), l);
    }
}

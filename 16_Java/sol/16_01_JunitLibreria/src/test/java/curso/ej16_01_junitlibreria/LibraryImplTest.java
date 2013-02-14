package curso.ej16_01_junitlibreria;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibraryImplTest {

    private Library library;

    private static Book b1984;
    private static Book bhp1;
    private static Book bhp2;
    private static Book bhi;
    private static Book bga;

    @BeforeClass
    public static void beforeClass() {
        b1984 = new Book("978 0 140 81774 4", "Nineteen eighty-four", 1949, "George Orwell");
        bhp1 = new Book("0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997, "J. K. Rowling");
        bhp2 = new Book("0 7475 3848 4", "Harry Potter and the chamber of secrets", 1998, "J. K. Rowling");
        bhi = new Book("35 221 2800 1", "Die unendliche geschichte", 1979, "Michael Ende");
        bga = new Book("0 345 39180 2", "The hitchhicker's guide to the galaxy", 1979, "Douglas Adams");
    }

    @Before
    public void beforeTest() {
        library = new LibraryImpl();
    }

    @Test
    public void test_addBook_bookNotExists() {
        boolean result = library.addBook(bhp1);
        assertTrue(result);

        assertTrue(library.containsBook(bhp1));
        assertEquals(1, library.list().size());

        assertEquals(bhp1, library.list().get(0));
    }

    @Test
    public void test_addBook_bookExists() {
        library.addBook(bhp1);
        boolean result = library.addBook(bhp1);
        assertFalse(result);

        assertEquals(1, library.list().size());
    }

    @Test
    public void test_removeBook() {
        library.addBook(bhp1);
        boolean result = library.removeBook(bhp1);
        assertTrue(result);

        result = library.removeBook(bhp1);
        assertFalse(result);

        assertFalse(library.containsBook(bhp1));
        assertEquals(0, library.list().size());
    }

    @Test
    public void test_list() {
        library.addBook(bhp1);
        library.addBook(bhp2);
        library.addBook(b1984);

        Book[] expected = new Book[]{ bhp2, bhp1, b1984};

        Book[] books = library.list().toArray(new Book[0]);
        assertEquals(3, books.length);
        assertArrayEquals(expected, books);
    }

    @Test
    public void test_findByISBN() {
        library.addBook(bhp1);
        library.addBook(bhp2);
        library.addBook(b1984);

        Book result = library.findByISBN(b1984.getIsbn());

        assertEquals(b1984, result);
    }

    @Test
    public void test_findByYear() {
        library.addBook(bhp1);
        library.addBook(bhp2);
        library.addBook(b1984);
        library.addBook(bhi);
        library.addBook(bga);

        List<Book> result = library.findByYear(1979);

        assertEquals(2, result.size());
        assertTrue(result.contains(bhi));
        assertTrue(result.contains(bga));
    }

    @Test
    public void test_findByAuthor() {
        library.addBook(bhp1);
        library.addBook(bhp2);
        library.addBook(b1984);
        library.addBook(bhi);
        library.addBook(bga);

        List<Book> result = library.findByAuthor("J. K. Rowling");

        assertEquals(2, result.size());
        assertTrue(result.contains(bhp1));
        assertTrue(result.contains(bhp2));
    }
}

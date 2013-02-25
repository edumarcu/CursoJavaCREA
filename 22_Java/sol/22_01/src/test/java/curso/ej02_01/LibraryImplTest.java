package curso.ej02_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibraryImplTest {

    private EntityManager em;

    private static Book b1984;
    private static Book bhp1;
    private static Book bhp2;
    private static Book bhi;
    private static Book bga;
    private static Author ago;
    private static Author ajkr;
    private static Author ame;
    private static Author ada;

    @BeforeClass
    public static void beforeClass() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ago = new Author(1, "George Orwell", sdf.parse("1903-06-25"), "United Kingdom");
        ajkr = new Author(2, "J. K. Rowling", sdf.parse("1965-07-31"), "United Kingdom");
        ajkr = new Author(3, "Michael Ende", sdf.parse("1929-11-12"), "Germany");
        ajkr = new Author(4, "Douglas Adams", sdf.parse("1952-03-11"), "United Kingdom");

        b1984 = new Book("978 0 140 81774 4", "Nineteen eighty-four", 1949);
        b1984.setAuthor(ago);
        bhp1 = new Book("0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997);
        bhp1.setAuthor(ajkr);
        bhp2 = new Book("0 7475 3848 4", "Harry Potter and the chamber of secrets", 1998);
        bhp2.setAuthor(ajkr);
        bhi = new Book("35 221 2800 1", "Die unendliche geschichte", 1979);
        bhi.setAuthor(ame);
        bga = new Book("0 345 39180 2", "The hitchhicker's guide to the galaxy", 1979);
        bga.setAuthor(ada);
    }

    @Before
    public void beforeTest() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1/test";
        String user = "root";
        String pass = "";
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt1 = conn.createStatement();
        stmt1.execute("TRUNCATE TABLE books");
        stmt1.close();

        Statement stmt2 = conn.createStatement();
        stmt2.execute("TRUNCATE TABLE authors");
        stmt2.close();

        conn.close();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        em = emf.createEntityManager();
    }

    @Test
    public void test_addBook_bookNotExists() {
        boolean result = ajkr.create(em);
        result = result && bhp1.create(em);
        assertTrue(result);

        assertTrue(Book.containsBook(em, bhp1.getId()));
        assertEquals(1, Book.count(em));

        assertEquals(bhp1, Book.findById(em, bhp1.getId()));
    }
/*
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

        Book[] expected = new Book[]{bhp2, bhp1, b1984};

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

* */
}

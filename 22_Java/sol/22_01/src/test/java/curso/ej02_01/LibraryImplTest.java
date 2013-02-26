package curso.ej02_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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

    @Before
    public void beforeTest() throws SQLException, ParseException {
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

        //
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ago = new Author(1, "George Orwell", sdf.parse("1903-06-25"), "United Kingdom");
        ajkr = new Author(2, "J. K. Rowling", sdf.parse("1965-07-31"), "United Kingdom");
        ame = new Author(3, "Michael Ende", sdf.parse("1929-11-12"), "Germany");
        ada = new Author(4, "Douglas Adams", sdf.parse("1952-03-11"), "United Kingdom");

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

    @Test
    @Ignore
    public void test_addBook_bookNotExists() {
        boolean result = ajkr.create(em);
        result = result && bhp1.create(em);
        assertTrue(result);

        assertTrue(Book.containsBook(em, bhp1.getId()));
        assertEquals(1, Book.count(em));

        assertEquals(bhp1, Book.findById(em, bhp1.getId()));
    }

    @Test
    @Ignore
    public void test_addBook_bookExists() {
        ajkr.create(em);
        bhp1.create(em);

        boolean result = bhp1.create(em);
        assertFalse(result);

        Book book1 = bhp1.clone();
        book1.setId(0);
        result = book1.create(em);
        assertFalse(result);

        assertEquals(1, Book.count(em));
    }

    @Test
    public void test_removeBook() {
        ajkr.create(em);
        bhp1.create(em);
        boolean result = bhp1.remove(em);
        assertTrue(result);

        result = bhp1.remove(em);
        assertFalse(result);

        assertFalse(Book.containsBook(em, bhp1.getId()));
        assertEquals(0, Book.count(em));
    }

    @Test
    public void test_list() {
        ajkr.create(em);
        ago.create(em);

        bhp1.create(em);
        bhp2.create(em);
        b1984.create(em);

        Book[] expected = new Book[]{bhp2, bhp1, b1984};

        Book[] books = Book.findAll(em).toArray(new Book[0]);
        assertEquals(3, books.length);
        assertArrayEquals(expected, books);
    }

    @Test
    public void test_findByISBN() {
        ajkr.create(em);
        ago.create(em);

        bhp1.create(em);
        bhp2.create(em);
        b1984.create(em);

        Book result = Book.findByISBN(em, b1984.getIsbn());

        assertEquals(b1984, result);
    }

    @Test
    public void test_findByYear() {
        ajkr.create(em);
        ago.create(em);
        ada.create(em);
        ame.create(em);

        bhp1.create(em);
        bhp2.create(em);
        b1984.create(em);
        bhi.create(em);
        bga.create(em);

        List<Book> result = Book.findByYear(em, 1979);

        assertEquals(2, result.size());
        assertTrue(result.contains(bhi));
        assertTrue(result.contains(bga));
    }

    @Test
    public void test_findByAuthor1() {
        ajkr.create(em);
        ago.create(em);
        ada.create(em);
        ame.create(em);

        bhp1.create(em);
        bhp2.create(em);
        b1984.create(em);
        bhi.create(em);
        bga.create(em);

        em.refresh(ajkr);
        ajkr = Author.findById(em, ajkr.getId());
        List<Book> result = ajkr.getBooks();

        assertEquals(2, result.size());
        assertTrue(result.contains(bhp1));
        assertTrue(result.contains(bhp2));
    }

    @Test
    public void test_findByAuthor2() {
        ajkr.create(em);
        ago.create(em);
        ada.create(em);
        ame.create(em);

        bhp1.create(em);
        bhp2.create(em);
        b1984.create(em);
        bhi.create(em);
        bga.create(em);

        List<Book> result = Book.findByAuthor(em, ajkr);

        assertEquals(2, result.size());
        assertTrue(result.contains(bhp1));
        assertTrue(result.contains(bhp2));
    }


    @Test
    public void test_refresh() throws SQLException {
        ajkr.create(em);
        ago.create(em);
        ada.create(em);
        ame.create(em);

        bhp1.create(em);
        bhp2.create(em);
        b1984.create(em);
        bhi.create(em);
        bga.create(em);

        String url = "jdbc:mysql://127.0.0.1/test";
        String user = "root";
        String pass = "";
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt1 = conn.createStatement();
        stmt1.execute("UPDATE authors SET name = 'FOO' WHERE id = 1");
        stmt1.close();

        System.out.println("BEFORE REFRESH:" + ajkr);
        System.out.println("BEFORE REFRESH:" + ajkr.getBooks());

        em.refresh(ajkr);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss S");

        System.out.println(sdf.format(new Date()) + " AFTER REFRESH:" + ajkr);
        System.out.println(sdf.format(new Date()) + "AFTER REFRESH:" + ajkr.getBooks());

        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        ajkr = Author.findById(em, 1l);

        System.out.println(sdf.format(new Date()) + "AFTER FIND:" + ajkr);
        System.out.println(sdf.format(new Date()) + "AFTER FIND:" + ajkr.getBooks());
    }
}

package curso.ej22_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LibraryImplTest {

    private static Book b1984;
    private static Book bhp1;
    private static Book bhp2;
    private static Book bhi;
    private static Book bga;

    private static Author jkr;

    private EntityManager em;

    @BeforeClass
    public static void beforeClass() throws ParseException {
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-mm-dd");

        jkr = new Author(1, "J. K. Rowling", sdf.parse("1965-07-31"), "United Kingdom");
        bhp1 = new Book(1, "0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997);
        bhp1.setAuthor(jkr);

        bhp2 = new Book(2, "0 7475 3848 4", "Harry Potter and the chamber of secrets", 1998);
        bhp2.setAuthor(jkr);

        b1984 = new Book(3, "978 0 140 81774 4", "Nineteen eighty-four", 1949);
        b1984.setAuthor(new Author(2, "George Orwell", sdf.parse("1903-06-25"), "United Kingdom"));

        bhi = new Book(4, "35 221 2800 1", "Die unendliche geschichte", 1979);
        bhi.setAuthor(new Author(3, "Michael Ende", sdf.parse("1929-11-12"), "United Kingdom"));

        bga = new Book(5, "0 345 39180 2", "The hitchhicker's guide to the galaxy", 1979);
        bga.setAuthor(new Author(4, "Douglas Adams", sdf.parse("1929-03-11"), "United Kingdom"));
    }

    @Before
    public void createEntityManager() {
//        System.out.println("Creating ORM...");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
        em = emf.createEntityManager();
//        System.out.println("OK!");
    }

    @After
    public void closeEM() {
        em.close();
    }

    @Before
    public void prepareTables() throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        Statement stmt = conn.createStatement();
        Boolean result = stmt.execute("TRUNCATE TABLE authors");
//        System.out.println("DELETE authors = " + result);

        stmt = conn.createStatement();
        result = stmt.execute("TRUNCATE TABLE books");
//        System.out.println("DELETE books = " + result);

        stmt = conn.createStatement();
        result = stmt.execute("INSERT INTO authors(name, birthday, country) " +
                "VALUES ('J. K . Rowling', '1947-1-15', 'UK')");
//        System.out.println("INSERT author JKR = " + result);

        stmt = conn.createStatement();
        result = stmt.execute("INSERT INTO books(isbn, title, year, author_id) " +
                "VALUES ('0 7475 5819 1', 'Harry Potter and the philosopher\\'s stone', 1997, 1)");
//        System.out.println("INSERT bhp1 = " + result);
    }

    @Test
    public void test_containsBook_bookNotExists() {
         assertFalse(Book.contains(em, bga));
    }

    @Test
    public void test_containsBook_bookExists() {
         assertTrue(Book.contains(em, bhp1));
    }

    @Test
    public void test_count_noAddedBooks() {
        assertEquals(1, Book.count(em));
    }

    @Test
    public void test_list_noAddedBooks() {
        List<Book> expected = new ArrayList<>();

        expected.add(bhp1);

        assertEquals(1, Book.list(em).size());
        assertEquals(expected, Book.list(em));
    }


    @Test
    public void test_add_bookNotExists() {
        long nBooks  = Book.list(em).size();
        assertTrue(bhp2.create(em));

        assertTrue(Book.contains(em, bhp2));
        assertEquals(nBooks + 1, Book.list(em).size());
    }

    @Test
    public void test_add_bookExists() {
        long nBooks  = Book.list(em).size();
        assertFalse(bhp1.create(em));

        assertTrue(Book.contains(em, bhp1));
        assertEquals(nBooks, Book.list(em).size());
    }

    @Test
    public void test_remove_bookExists() {
        long nBooks  = Book.list(em).size();
        assertTrue(bhp1.remove(em));

        assertFalse(Book.contains(em, bhp1));
        assertEquals(nBooks - 1, Book.list(em).size());
    }
//
//    @Test
//    public void test_list() {
//        library.addBook(bhp1);
//        library.addBook(bhp2);
//        library.addBook(b1984);
//
//        Book[] expected = new Book[]{ bhp2, bhp1, b1984};
//
//        Book[] books = library.list().toArray(new Book[0]);
//        assertEquals(3, books.length);
//        assertArrayEquals(expected, books);
//    }
//
//    @Test
//    public void test_findByISBN() {
//        library.addBook(bhp1);
//        library.addBook(bhp2);
//        library.addBook(b1984);
//
//        Book result = library.findByISBN(b1984.getIsbn());
//
//        assertEquals(b1984, result);
//    }
//
//    @Test
//    public void test_findByYear() {
//        library.addBook(bhp1);
//        library.addBook(bhp2);
//        library.addBook(b1984);
//        library.addBook(bhi);
//        library.addBook(bga);
//
//        List<Book> result = library.findByYear(1979);
//
//        assertEquals(2, result.size());
//        assertTrue(result.contains(bhi));
//        assertTrue(result.contains(bga));
//    }
//
//    @Test
//    public void test_findByAuthor() {
//        library.addBook(bhp1);
//        library.addBook(bhp2);
//        library.addBook(b1984);
//        library.addBook(bhi);
//        library.addBook(bga);
//
//        List<Book> result = library.findByAuthor("J. K. Rowling");
//
//        assertEquals(2, result.size());
//        assertTrue(result.contains(bhp1));
//        assertTrue(result.contains(bhp2));
//    }
}

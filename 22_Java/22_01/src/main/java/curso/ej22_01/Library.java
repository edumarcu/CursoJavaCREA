package curso.ej22_01;

import java.util.List;

public interface Library {

    boolean addBook(Book book);

    boolean removeBook(Book book);

    boolean containsBook(Book book);

    List<Book> list();

    Book findByISBN(String isbn);

    List<Book> findByYear(int year);

    List<Book> findByAuthor(Author author);

}

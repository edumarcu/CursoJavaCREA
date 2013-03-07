package curso.ej24_02.library;



import java.util.List;

public interface Library {

    boolean addBook(Book book);

    boolean removeBook(Book book);

    boolean containsBook(Book book);

    List<Book> list();

    Book findByISBN(String isbn);

    List<Book> findByYear(int year);

    List<Book> findByAuthor(String author);

}

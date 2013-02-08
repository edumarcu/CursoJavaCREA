package curso.ejercicio2.commons;

import java.util.List;

/**
 *
 * @author EM
 */
public class ListBooksCommand implements Command {

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void execute(Library library) {
        books = library.list();
    }

    public List<Book> getPoints() {
        return books;
    }
}

package curso.ejercicio2.commons;

import java.util.List;

public class ListBooksCommand implements Command {

    private List<Book> books;

    public void execute(Library library) {
        books = library.list();
    }

    public List<Book> getBooks() {
        return books;
    }
}

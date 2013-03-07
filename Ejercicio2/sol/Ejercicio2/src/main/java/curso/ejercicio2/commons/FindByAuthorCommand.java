package curso.ejercicio2.commons;

import java.util.List;

public class FindByAuthorCommand implements Command {

    private String author;

    public FindByAuthorCommand(String author) {
        this.author = author;
    }

    private List<Book> books;

    public void execute(Library library) {
        books = library.findByAuthor(author);
    }

    public List<Book> getBooks() {
        return books;
    }
}

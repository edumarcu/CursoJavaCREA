package curso.ejercicio2.commons;

/**
 *
 * @author EM
 */
public class AddBookCommand implements Command {

    private boolean ok = false;

    private Book book;

    public AddBookCommand(Book book) {
        this.book = book;
    }

    public void execute(Library library) {
        ok = library.addBook(book);
    }

    public boolean isOk() {
        return ok;
    }
}

package curso.ejercicio2.commons;

/**
 *
 * @author EM
 */
public class RemoveBookCommand implements Command {

    private boolean ok = false;

    private Book book;

    public RemoveBookCommand(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }


    @Override
    public void execute(Library library) {
        ok = library.removeBook(book);
    }

    public boolean isOk() {
        return ok;
    }
}

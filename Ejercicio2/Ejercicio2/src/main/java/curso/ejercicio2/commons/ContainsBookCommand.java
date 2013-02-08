package curso.ejercicio2.commons;

/**
 *
 * @author EM
 */
public class ContainsBookCommand implements Command {
    private boolean contains = false;

    private Book book;

    public ContainsBookCommand(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public void execute(Library library) {
        contains = library.containsBook(book);
    }

    public boolean isOk() {
        return contains;
    }
}

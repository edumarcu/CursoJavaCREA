package curso.ejercicio2.commons;

public class ContainsBookCommand implements Command {

    private Book book;

    private boolean ok;

    public ContainsBookCommand(Book book) {
        this.book = book;
    }

    public void execute(Library library) {
        ok = library.containsBook(book);
    }

    public boolean isOk() {
        return ok;
    }
}

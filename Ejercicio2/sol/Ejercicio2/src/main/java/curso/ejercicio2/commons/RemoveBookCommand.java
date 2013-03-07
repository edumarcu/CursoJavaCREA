package curso.ejercicio2.commons;

public class RemoveBookCommand implements Command {

    private Book book;

    private boolean ok;

    public RemoveBookCommand(Book book) {
        this.book = book;
    }

    public void execute(Library library) {
        ok = library.removeBook(book);
    }

    public boolean isOk() {
        return ok;
    }
}

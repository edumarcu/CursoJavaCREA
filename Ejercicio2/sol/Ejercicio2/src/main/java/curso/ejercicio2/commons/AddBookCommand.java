package curso.ejercicio2.commons;

public class AddBookCommand implements Command {

    private Book book;

    private boolean ok;

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

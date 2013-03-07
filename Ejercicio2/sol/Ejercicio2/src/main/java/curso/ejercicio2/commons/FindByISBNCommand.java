package curso.ejercicio2.commons;

public class FindByISBNCommand implements Command {

    private String isbn;

    public FindByISBNCommand(String isbn) {
        this.isbn = isbn;
    }

    private Book book;

    public void execute(Library library) {
        book = library.findByISBN(isbn);
    }

    public Book getBook() {
        return book;
    }
}

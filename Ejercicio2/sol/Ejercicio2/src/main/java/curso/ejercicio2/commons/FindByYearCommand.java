package curso.ejercicio2.commons;

import java.util.List;

public class FindByYearCommand implements Command {

    private int year;

    public FindByYearCommand(int year) {
        this.year = year;
    }

    private List<Book> books;

    public void execute(Library library) {
        books = library.findByYear(year);
    }

    public List<Book> getBooks() {
        return books;
    }
}

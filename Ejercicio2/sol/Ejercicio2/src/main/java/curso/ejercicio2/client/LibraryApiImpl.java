package curso.ejercicio2.client;

import curso.ejercicio2.commons.AddBookCommand;
import curso.ejercicio2.commons.Book;
import curso.ejercicio2.commons.ContainsBookCommand;
import curso.ejercicio2.commons.FindByAuthorCommand;
import curso.ejercicio2.commons.FindByISBNCommand;
import curso.ejercicio2.commons.FindByYearCommand;
import curso.ejercicio2.commons.Library;
import curso.ejercicio2.commons.ListBooksCommand;
import curso.ejercicio2.commons.RemoveBookCommand;
import java.util.List;

public class LibraryApiImpl implements Library {

    private CommandExecutor executor;

    public LibraryApiImpl(CommandExecutor executor) {
        this.executor = executor;
    }

    public boolean addBook(Book book) {
        try{
            AddBookCommand command = executor.executeCommand(new AddBookCommand(book));
            return command.isOk();
        } catch (Exception e) {
            System.err.println("Error ejecutando comando en el servidor:");
            e.printStackTrace(System.err);
            return false;
        }
    }

    public boolean removeBook(Book book) {
        try{
            RemoveBookCommand command = executor.executeCommand(new RemoveBookCommand(book));
            return command.isOk();
        } catch (Exception e) {
            System.err.println("Error ejecutando comando en el servidor:");
            e.printStackTrace(System.err);
            return false;
        }
    }

    public boolean containsBook(Book book) {
        try{
            ContainsBookCommand command = executor.executeCommand(new ContainsBookCommand(book));
            return command.isOk();
        } catch (Exception e) {
            System.err.println("Error ejecutando comando en el servidor:");
            e.printStackTrace(System.err);
            return false;
        }
    }

    public List<Book> list() {
        try{
            ListBooksCommand command = executor.executeCommand(new ListBooksCommand());
            return command.getBooks();
        } catch (Exception e) {
            System.err.println("Error ejecutando comando en el servidor:");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public Book findByISBN(String isbn) {
        try{
            FindByISBNCommand command = executor.executeCommand(new FindByISBNCommand(isbn));
            return command.getBook();
        } catch (Exception e) {
            System.err.println("Error ejecutando comando en el servidor:");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public List<Book> findByYear(int year) {
        try{
            FindByYearCommand command = executor.executeCommand(new FindByYearCommand(year));
            return command.getBooks();
        } catch (Exception e) {
            System.err.println("Error ejecutando comando en el servidor:");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public List<Book> findByAuthor(String author) {
        try{
            FindByAuthorCommand command = executor.executeCommand(new FindByAuthorCommand(author));
            return command.getBooks();
        } catch (Exception e) {
            System.err.println("Error ejecutando comando en el servidor:");
            e.printStackTrace(System.err);
            return null;
        }
    }

}

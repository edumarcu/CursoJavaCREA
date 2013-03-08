package curso.ej25_01;

import curso.ej24_02.Book;
import curso.ej24_02.Library;
import curso.ej24_02.LibraryImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListBooksServlet", urlPatterns = {"/list"})
public class ListBooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Library library = new LibraryImpl();
        library.addBook(new Book("0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997, "J. K. Rowling"));
        library.addBook(new Book("0 7475 3848 4", "Harry Potter and the chamber of secrets", 1998, "J. K. Rowling"));
        library.addBook(new Book("978 0 140 81774 4", "Nineteen eighty-four", 1949, "George Orwell"));
        library.addBook(new Book("35 221 2800 1", "Die unendliche geschichte", 1979, "Michael Ende"));
        library.addBook(new Book("0 345 39180 2", "The hitchhicker's guide to the galaxy", 1979, "Douglas Adams"));

        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Books</title></head><body>");
        out.println("<h1>Book List</h1>");
        out.println("<ul>");
        for (Book book : library.list()) {
            out.printf("<li>%s</li>", book.getTitle());
        }
        out.println("</ul>");
        out.println("</body></html>");
    }

}

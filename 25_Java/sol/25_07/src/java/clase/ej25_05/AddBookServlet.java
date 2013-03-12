package clase.ej25_05;

import clase.ej25_02.LibraryFactory;
import curso.ej24_02.Book;
import curso.ej24_02.Library;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddBookServlet", urlPatterns = {"/addBook"})
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retieve Params
        Book book = new Book();
        book.setIsbn(req.getParameter("isbn"));
        book.setTitle(req.getParameter("title"));
        book.setAuthor(req.getParameter("author"));
        int year = 0;
        try {
            year = Integer.parseInt(req.getParameter("year"));
        } catch (Exception e) {}
        book.setYear(year);

        // TODO: Validate book
        // If not valid, forward to form
        //

        // Save Book
        Library library = LibraryFactory.library(req);
        library.addBook(book); // TODO: If not added, forward to form

        String base = req.getContextPath();
        resp.sendRedirect(base + "/index");
    }
}

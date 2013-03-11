package curso.ej25_07;

import curso.library.Book;
import curso.library.Library;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "DetailServlet",
        urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Library library = LibraryFactory.library(req);
        String isbn = (String) req.getParameter("isbn");

        boolean valid = isbn != null && isbn.trim().replaceAll(" ", "").length() >= 10;
        Book book = (valid) ? library.findByISBN(isbn) : null;

        String message = null;
        if (book == null) {
            message = "Sorry, but the book with <strong>ISBN: \"" + isbn + "\"</strong> is not in the library!";
        }

        req.setAttribute("book", book);
        req.setAttribute("message", message);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/detail.jsp");
        dispatcher.forward(req, resp);
    }

}


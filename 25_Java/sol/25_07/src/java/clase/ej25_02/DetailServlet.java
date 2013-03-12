package clase.ej25_02;

import curso.ej24_02.Book;
import curso.ej24_02.Library;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DetailServlet", urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Library library = LibraryFactory.library(req);

        // Fetch param
        String isbn = req.getParameter("isbn");
        // TODO escapar isbn
        req.setAttribute("isbn", isbn);

        // Validate param "isbn"
        // isbn is valid if it's not null and have at least 10 characters
        boolean valid = isbn != null && isbn.trim().replaceAll(" ", "").length() >= 10;

        // If param "isbn" is ok, fetch book
        // else left book == null
        Book book = (valid) ? library.findByISBN(isbn) : null;
        req.setAttribute("book", book);

        // Forward to view
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/detail.jsp");
        dispatcher.forward(req, resp);
    }

}

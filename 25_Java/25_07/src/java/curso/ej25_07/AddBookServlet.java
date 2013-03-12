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
        name = "AddBookServlet",
        urlPatterns = {"/add_book"})
public class AddBookServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Library library = LibraryFactory.library(req);

        String isbn = (String) req.getParameter("isbn");
        String title = (String) req.getParameter("title");
        String author = (String) req.getParameter("author");
        int year = 0;
        try {
          year = Integer.parseInt( (String) req.getParameter("year"));
        } catch ( Exception e ) {}

        //TODO: Verfy parameters and validate book
        //boolean valid = isbn != null && isbn.trim().replaceAll(" ", "").length() >= 10;
        Book book = new Book(isbn, title, year, author);

        //TODO: verify insertion, error then forward
        library.addBook(book);

//        String message = null;
//        if (book == null) {
//            message = "Sorry, but the book with <strong>ISBN: \"" + isbn + "\"</strong> is not in the library!";
//        }

        req.setAttribute("book", book);
//        req.setAttribute("message", message);
        resp.sendRedirect(req.getContextPath() + "/index");
        //TODO: si hacemos forward con error, habria que hacer doPost en index, porque lo manda de aqui
    }

}


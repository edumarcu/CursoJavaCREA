package curso.ej25_07;

import curso.library.Book;
import curso.library.Library;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "FindByAuthorServlet",
        urlPatterns = {"/find_by_author"})
public class FindByAuthorServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Library library = LibraryFactory.library(req);
          // Fetch "author" param
        String author = req.getParameter("author");

        // Fetch books for author
        List<Book> books = library.findByAuthor(author);

        String message = null;
        if (books == null || books.isEmpty()) {
            message = "Sorry, but the <strong>Author: \"" + author + "\"</strong> has no Book in the library!";
        }

        req.setAttribute("books", (List<Book>) books);
        req.setAttribute("author", author);
        req.setAttribute("message", message);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/find_by_author.jsp");
        dispatcher.forward(req, resp);
    }

}


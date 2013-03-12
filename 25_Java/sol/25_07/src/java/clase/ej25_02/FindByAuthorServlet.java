package clase.ej25_02;

import curso.ej24_02.Book;
import curso.ej24_02.Library;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FindByAuthorServlet", urlPatterns = {"/findByAuthor"})
public class FindByAuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Library library = LibraryFactory.library(req);

        // Fetch "author" param
        String author = req.getParameter("author");

        // Fetch books for author
        List<Book> books = library.findByAuthor(author);

        // Forward to view
        req.setAttribute("author", author);
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/find_by_author.jsp");
        dispatcher.forward(req, resp);
    }

}

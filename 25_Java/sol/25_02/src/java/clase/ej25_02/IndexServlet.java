package clase.ej25_02;

import curso.ej24_02.Book;
import curso.ej24_02.Library;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "IndexServlet",
        urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Library library = LibraryFactory.library(req);
        List<Book> books = library.list();

        String message = null;
        if (books == null || books.isEmpty()) {
            message = "There are no books in the library";
        }

        req.setAttribute("books", books);
        req.setAttribute("message", message);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/index.jsp");
        dispatcher.forward(req, resp);
    }

}

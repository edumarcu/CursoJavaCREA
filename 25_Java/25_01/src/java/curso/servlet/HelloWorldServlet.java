/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.servlet;

import curso.library.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet 3.0, Java EE 6
 * @author EM
 */
@WebServlet(name = "Hello World Servlet", urlPatterns = {"/list"})
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Library library;

        Book b1984;
        Book bhp1;
        Book bhp2;
        Book bhi;
        Book bga;

        library = new LibraryImpl();

        b1984 = new Book("978 0 140 81774 4", "Nineteen eighty-four", 1949, "George Orwell");
        bhp1 = new Book("0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997, "J. K. Rowling");
        bhp2 = new Book("0 7475 3848 4", "Harry Potter and the chamber of secrets", 1998, "J. K. Rowling");
        bhi = new Book("35 221 2800 1", "Die unendliche geschichte", 1979, "Michael Ende");
        bga = new Book("0 345 39180 2", "The hitchhicker's guide to the galaxy", 1979, "Douglas Adams");

        library.addBook(b1984);
        library.addBook(bhp1);
        library.addBook(bhp2);
        library.addBook(bhi);
        library.addBook(bga);

        PrintWriter out = response.getWriter();
        out.write("<html>\n");
        out.write("    <head>\n");
        out.write("        <title>My Library</title>\n");
        out.write("    </head>\n");
        out.write("    <body>\n");
        out.write("        <h1>My Books</h1>\n");
        out.write("        <p>Size = " + library.list().size() + "</p>\n");
        out.write("        <table>\n");
        out.write("            <thead>\n");
        out.write("                <tr>\n");
        out.write("                    <th>ISBN</th>\n");
        out.write("                    <th>Title</th>\n");
        out.write("                    <th>Book</th>\n");
        out.write("                </tr>\n");
        out.write("            </thead>\n");
        out.write("            <tbody>\n");
                                        for (Book b : library.list()) {
        out.write("                    <tr>\n");
        out.write("                        <td>" + b.getIsbn() + "</td>\n");
        out.write("                        <td>" + b.getTitle()+ "</td>\n");
        out.write("                        <td>" + b.getAuthor()+ "</td>\n");
        out.write("                    </tr>\n");
                                        }
        out.write("            </tbody>\n");
        out.write("        <table>\n");
        out.write("    </body>\n");
        out.write("</html>\n");
    }
}

<%--
    Document   : index
    Created on : 07-mar-2013, 9:15:16
    Author     : EM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="curso.ej24_02.library.*" %>
<%@page import="java.util.Iterator"%>

<%
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
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>My Library</title>
    </head>
    <body>
        <h1>My Books</h1>
        <p><%= "Size = " + library.list().size() %></p>

        <table>
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>Book</th>
                </tr>
            </thead>
            <tbody>
               <%--  for (int i = 0; i < library.list().size(); i++) { --%>

                <%
                    Iterator itr = library.list().iterator();
                    
                    while (itr.hasNext()) {
                    Book b = (Book) itr.next();
                %>
                <tr>
                    <td><%= b.getIsbn() %></td>
                    <td><%= b.getTitle() %></td>
                    <td><%= b.getAuthor() %></td>
                </tr>
                <% } %>

            </tbody>
        </table>
    </body>
</html>

<%@page import="curso.ej24_02.Book"%>
<%@page import="curso.ej24_02.LibraryImpl"%>
<%@page import="curso.ej24_02.Library"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%
        Library library = new LibraryImpl();
        library.addBook(new Book("0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997, "J. K. Rowling"));
        library.addBook(new Book("0 7475 3848 4", "Harry Potter and the chamber of secrets", 1998, "J. K. Rowling"));
        library.addBook(new Book("978 0 140 81774 4", "Nineteen eighty-four", 1949, "George Orwell"));
        library.addBook(new Book("35 221 2800 1", "Die unendliche geschichte", 1979, "Michael Ende"));
        library.addBook(new Book("0 345 39180 2", "The hitchhicker's guide to the galaxy", 1979, "Douglas Adams"));
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Ejercicio 24_02 - Librería</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
  </head>
  <body>
    <h1>Librería</h1>
    <table>
      <thead>
        <tr>
          <th>ISBN</th>
          <th>title</th>
          <th>author</th>
        </tr>
      </thead>
      <tbody>
      <% for (Book book : library.list()) { %>
      <%    request.setAttribute("book", book); %>
      <jsp:include page="_row.jsp"  />
      <% } %>
      </tbody>
    </table>
  </body>
</html>

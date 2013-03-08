<%@page import="curso.ej24_02.Library"%>
<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Book Detail"); %>
<jsp:include page="layout/_header.jsp" />
<jsp:useBean id="library" scope="request" type="curso.ej24_02.Library"/>
<%
  // Fetch param
  String isbn = request.getParameter("isbn");

  // Validate param "isbn"
  // isbn is valid if it's not null and have at least 10 characters
  boolean valid = isbn != null && isbn.trim().replaceAll(" ", "").length() >= 10;

  // If param "isbn" is ok, fetch book
  // else left book == null
  Book book = (valid) ? library.findByISBN(isbn) : null;
  request.setAttribute("book", book);
%>
    <h2>Book Detail</h2>
    <%-- if book == null, show error, else show the book --%>
    <% if (book == null) { %>
    <p>Sorry we couldn't find a book with the given isbn: <%= isbn %></p>
    <% } else { %>
    <dl>
      <dt>ISBN:</dt>
      <dd>${book.isbn}</dd>
      <dt>Title:</dt>
      <dd>${book.title}</dd>
      <dt>Author:</dt>
      <dd>${book.author}</dd>
      <dt>Year:</dt>
      <dd>${book.year}</dd>
    </dl>
    <% } %>
<jsp:include page="layout/_footer.jsp" />
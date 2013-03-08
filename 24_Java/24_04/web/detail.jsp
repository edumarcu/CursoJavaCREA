<%@page import="curso.ej24_02.Library"%>
<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Book Detail"); %>
<jsp:include page="layout/_header.jsp" />
<jsp:useBean id="library" scope="request" type="curso.ej24_02.Library"/>
<%
    // Fetch "isbn" param
    String isbn = request.getParameter("isbn"); // <%-- TODO: Fetch "isbn" param

    // Validate param "isbn"
    // isbn is valid if it's not null and have at least 10 characters
    boolean valid = (isbn != null) && (isbn.replaceAll(" ", "").length() >= 10); // <%-- TODO: validate

    // If param "isbn" is ok, fetch book
    // else left book == null
    Book book = (valid ? library.findByISBN(isbn) : null); // TODO: fetch book
    request.setAttribute("book", book);
%>
    <h2>Book Detail</h2>
    <%-- if book == null, show error, else show the book --%>
    <% if (book == null) { %>
    <p>Sorry we couldn't find a book with the given isbn: <%= isbn %></p>
    <% } else { %>
    <dl>
        <dt>ISBN:</dt>
        <dl>${book.isbn}</dl>
        <dt>Title:</dt>
        <dl>${book.title}</dl>
        <dt>Author:</dt>
        <dl>${book.author}</dl>
        <dt>Year:</dt>
        <dl>${book.year}</dl>
    </dl>
    <% } %>
<jsp:include page="layout/_footer.jsp" />
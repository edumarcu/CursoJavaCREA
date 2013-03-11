<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Book Detail"); %>
<%
  Book book = (Book) request.getAttribute("book");
%>
<jsp:include page="layout/_header.jsp" />
    <h2>Book Detail</h2>
    <%-- if book == null, show error, else show the book --%>
    <% if (book == null) { %>
    <p>Sorry we couldn't find a book with the given isbn: ${isbn}</p>
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
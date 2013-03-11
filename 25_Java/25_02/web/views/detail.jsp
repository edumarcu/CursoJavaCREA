<%@page import="curso.library.Library"%>
<%@page import="curso.library.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Book Detail"); %>
<jsp:include page="layout/_header.jsp" />
<%
    Book book = (Book) request.getAttribute("book");
    String message = (String) request.getAttribute("message");
%>
    <h2>Book Detail</h2>
    <%-- if book == null, show error, else show the book --%>
    <% if (book == null) { %>
    <p>${message}</p>
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
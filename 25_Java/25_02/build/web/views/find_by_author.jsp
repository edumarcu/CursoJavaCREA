<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@page import="curso.library.Library"%>
<%@page import="curso.library.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Books for author"); %>
<jsp:include page="layout/_header.jsp" />
<%
    String author = (String) request.getAttribute("author");
    List<Book> books = (List<Book>) request.getAttribute("books");
    String message = (String) request.getAttribute("message");
%>
    <% if (books == null || books.isEmpty()) { %>
    <p>${message}</p>
    <% } else { %>
    <h2>Books of ${author}</h2>
    <table>
      <thead>
        <tr>
          <th>Title</th>
          <th>Year</th>
        </tr>
      </thead>
      <tbody>
      <% for (Book book : books) { %>
      <%   request.setAttribute("book", book); %>
        <tr>
          <td>
            <a href="${base}/detail?isbn=${book.isbn}">
              ${book.title}
            </a>
          </td>
          <td>${book.year}</td>
        </tr>
      <% } %>
      </tbody>
    </table>
    <% } %>
<jsp:include page="layout/_footer.jsp" />
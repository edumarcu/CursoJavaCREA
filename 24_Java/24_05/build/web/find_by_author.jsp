<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@page import="curso.ej24_02.Library"%>
<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Books for author"); %>
<jsp:include page="layout/_header.jsp" />
<jsp:useBean id="library" scope="request" type="curso.ej24_02.Library"/>
<%
  // Fetch "author" param
  String author = null; // <%-- TODO:

  // Fetch books for author
  List<Book> books = null; // <%-- TODO:
%>
    <h2>Books from <%-- TODO: author --%></h2>
    <%--TODO: if empty list books indicate --%>
    <% if (books.size() == 0) { %>
    <p>Sorry, we couldn't find books for author: <%= author %></p>
    <% } else { %>
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
            <a href="detail.jsp?isbn=${book.isbn}">
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
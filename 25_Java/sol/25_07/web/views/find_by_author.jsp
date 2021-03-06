<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@page import="curso.ej24_02.Library"%>
<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Books for author"); %>
<%
  List<Book> books = (List<Book>) request.getAttribute("books");
%>
<jsp:include page="layout/_header.jsp" />
    <h2>Books from ${author}</h2>
    <%--TODO: if empty list books indicate --%>
    <% if (books.size() == 0) { %>
    <p>Sorry, we couldn't find books for author: ${author}</p>
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
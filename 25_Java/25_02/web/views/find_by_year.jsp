<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@page import="curso.library.Library"%>
<%@page import="curso.library.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Books of Year"); %>
<jsp:include page="layout/_header.jsp" />
<%
    int year = (Integer) request.getAttribute("year");
    List<Book> books = (List<Book>) request.getAttribute("books");
    String message = (String) request.getAttribute("message");
%>

    <%--TODO: if empty list books indicate --%>
    <% if (books == null || books.isEmpty()) { %>
    <p>${message}</p>
    <% } else { %>
    <h2>Books published on <%= year %></h2>
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
          <td>${book.author}</td>
        </tr>
      <% } %>
      </tbody>
    </table>
    <% } %>
<jsp:include page="layout/_footer.jsp" />
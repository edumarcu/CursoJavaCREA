<%@page import="java.util.List"%>
<%@page import="curso.library.Library"%>
<%@page import="curso.library.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<%  request.setAttribute("title", "Library - Book List");%>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
    String message = (String) request.getAttribute("message");
%>
<jsp:include page="layout/_header.jsp" />
<h2>Book List</h2>
<% if (message != null) { %>
  <p>${message}</p>
<% } else { %>
<table>
  <thead>
    <tr>
      <th>Title</th>
      <th>Author</th>
    </tr>
  </thead>
  <tbody>
    <% for (Book book : books) {%>
    <%   request.setAttribute("book", book);%>
    <tr>
      <td>
        <a href="${base}/detail?isbn=${book.isbn}">
            ${book.title}
        </a>
      </td>
      <td>${book.author}</td>
    </tr>
    <% }%>
  </tbody>
</table>
<% }%>

<h3>Search by author name</h3>
<form action="${base}/find_by_author" method="GET">
  <input type="text" name="author" />
  <input type="submit" value="Search!" />
</form>

<h3>Search by year</h3>
<form action="${base}/find_by_year" method="GET">
  <input type="text" name="year" />
  <input type="submit" value="Search!" />
</form>


<jsp:include page="layout/_footer.jsp" />

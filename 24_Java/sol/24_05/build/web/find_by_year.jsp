<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@page import="curso.ej24_02.Library"%>
<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<% request.setAttribute("title", "Library - Books for year"); %>
<jsp:include page="layout/_header.jsp" />
<jsp:useBean id="library" scope="request" type="curso.ej24_02.Library"/>
<%
  // Fetch "author" param
  String yeartxt = request.getParameter("year");
  Integer year = null;
  try {
    year = new Integer(yeartxt);
  } catch ( Exception e ) {}

  // Fetch books for author
  List<Book> books = library.findByYear(year);
%>
    <h2>Books published on <%= year %></h2>
    <%--TODO: if empty list books indicate --%>
    <% if (books.size() == 0) { %>
    <p>Sorry, we couldn't find books published on: <%= year %></p>
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
          <td>${book.author}</td>
        </tr>
      <% } %>
      </tbody>
    </table>
    <% } %>
<jsp:include page="layout/_footer.jsp" />
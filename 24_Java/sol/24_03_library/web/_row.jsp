<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<% Book book = (Book) request.getAttribute("book"); %>
<tr>
  <td><%= book.getIsbn() %></td>
  <td><%= book.getTitle()%></td>
  <td><%= book.getAuthor()%></td>
</tr>
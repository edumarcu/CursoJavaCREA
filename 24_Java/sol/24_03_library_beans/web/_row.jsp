<%@page import="curso.ej24_02.Book"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page isELIgnored="false" %>
<%-- <jsp:useBean type="curso.ej24_02.Book" id="book" scope="request"/> --%>
<tr>
  <%--
  <td><jsp:getProperty name="book" property="isbn" /></td>
  <td><jsp:getProperty name="book" property="title" /></td>
  <td><jsp:getProperty name="book" property="author" /></td>
  --%>
  <td>${request.book.isbn}</td>
  <td>${book.title}</td>
  <td>${book.author}</td>
</tr>
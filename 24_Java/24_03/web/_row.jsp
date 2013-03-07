<%--
    Document   : _row
    Created on : 07-mar-2013, 10:11:26
    Author     : EM
--%>

<%@page import="curso.ej24_03.library.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Book b = (Book) request.getAttribute("book");
%>

<%
    out.print("<tr>");
        out.print("<td>" + b.getIsbn() + "</td>");
        out.print("<td>" + b.getTitle() + "</td>");
        out.print("<td>" + b.getAuthor() + "</td>");
    out.print("</tr>");
%>

<%--
<tr>
    <td><%= b.getIsbn()%></td>
    <td><%= b.getTitle()%></td>
    <td><%= b.getAuthor()%></td>
</tr>
--%>


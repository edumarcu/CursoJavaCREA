<%--
    Document   : index
    Created on : 06-mar-2013, 12:37:27
    Author     : golo
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<% String nombre = "Víctor Jiménez"; %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <p>I'm <%= nombre %></p>

    <ul>
      <% for (int i = 0; i < 10; i++) { %>
      <li><%= i %></li>
      <% } %>
    </ul>
  </body>
</html>

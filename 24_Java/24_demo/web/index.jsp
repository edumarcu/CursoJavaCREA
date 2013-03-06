<%--
    Document   : index
    Created on : 06-mar-2013, 12:32:35
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String name = "Eduardo Marcuello";%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>My name is <%= name %></p>
        <ul>
            <% for (int i =0; i <10; i++) { %>
                <li><%= i %></li>
            <% } %>

        </ul>
    </body>
</html>

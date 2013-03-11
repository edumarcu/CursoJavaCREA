<%--
    Document   : index
    Created on : 11-mar-2013, 11:50:19
    Author     : EM
    Comments: Servlets
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String error = (String) request.getAttribute("error");
    String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Message changing</title>
    </head>
    <body>
        <p>Message: ${applicationScope.message}</p>
        <% if (error != null) { %>
        <p style="color: red; margin-left: 1em" >${error}</p>
        <% } %>
        <br />
        <h2>Change Message</h2>
        <p>Message: </p>
        <form action="change" method="GET">
            <input type="text"  name="changeMessage" value="${message}"/>
            <input type="submit" value="Change!" />
        </form>
    </body>
</html>

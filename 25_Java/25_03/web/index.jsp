<%--
    Document   : index
    Created on : 11-mar-2013, 11:50:19
    Author     : EM
    Comments: Servlets
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String message = (String) request.getAttribute("message");

    if (message == null || message == "") {
        message = (String) application.getAttribute("message");
        if (message == null || message == "") {
            message = "1a vez";
        }
    } else {
        application.setAttribute("message", message);
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Message changing</title>
    </head>
    <body>
        <p>Message: ${message} y <%= message %></p>
        <br />
        <h2>Change Message</h2>
        <p>Message: </p>
        <form action="change" method="GET">
            <input type="text"  name="changeMessage" />
            <input type="submit" value="Change!" />
        </form>
    </body>
</html>

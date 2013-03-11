<%--
    Document   : index
    Created on : 11-mar-2013, 11:50:19
    Author     : EM
    Comments: Servlets
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Message changing</title>
    </head>
    <body>
        <p>Message: ${message}</p>
        <br />
        <h2>Change Message</h2>
        <p>Message: </p>
        <form action="change" method="GET">
            <input type="text"  name="changeMessage" />
            <input type="submit" value="Change!" />
        </form>
    </body>
</html>

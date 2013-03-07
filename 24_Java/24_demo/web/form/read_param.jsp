<%--
    Document   : read_param
    Created on : 07-mar-2013, 13:04:10
    Author     : EM
    Comment: Param by URL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your name is <%= request.getParameter("name") %></h1>
    </body>
</html>

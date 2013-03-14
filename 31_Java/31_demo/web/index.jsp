<%--
    Document   : index
    Created on : 14-mar-2013, 9:15:07
    Author     : EM
    Comments: Internationalization, I18N
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="curso.demo31.Textos" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><%= Textos.getBundle().getString("app.name") %>${param.locale} <%  %></title>
    </head>
    <body>
        <h1><%= Textos.getBundle().getString("hello.world") %></h1>
    </body>
</html>

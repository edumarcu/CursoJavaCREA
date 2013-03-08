<%--
    Document   : index
    Created on : 08-mar-2013, 11:57:14
    Author        : EM
    Comments: Library with Servlet
--%>

<%@page import="curso.servlet.HelloWorldServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Servlet Example</h1>
        <%-- <% new HelloWorldServlet().doGet(request, response); %> --%>
        <% response.sendRedirect("list"); %>
        <a href="list">Run Servlet</a>
    </body>
</html>
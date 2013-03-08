<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@include file="_library.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>${title}</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
  </head>
  <body>
    <h1>Librería</h1>
    <div id="menu">
      <% if (!request.getRequestURI().contains("index.jsp")) { %>
      <a href="index.jsp">Book List</a>
      <% } %>
    </div>

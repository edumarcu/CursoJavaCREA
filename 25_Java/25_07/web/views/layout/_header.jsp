<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>${title}</title>
    <link rel="stylesheet" href="${base}/css/style.css" type="text/css" media="screen">
  </head>
  <body>
    <h1>Librería</h1>
    <div id="menu">
      <% if (!request.getRequestURI().contains("index.jsp")) { %>
      <a href="${base}/index.jsp">Book List</a>
      <% } %>
    </div>

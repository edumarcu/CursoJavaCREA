<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String error = (String) request.getAttribute("error"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Message</title>
  </head>
  <body>
    <h1>Message</h1>
    <p>${applicationScope.message}</p>
    <h2>Change Message</h2>
    <% if (error != null) { %>
    <p style="color: red;">${error}</p>
    <% } %>
    <form action="update" method="POST">
      <input type="text" name="message" value="${requestScope.message}" />
      <input type="submit" value="Change!" />
    </form>
  </body>
</html>
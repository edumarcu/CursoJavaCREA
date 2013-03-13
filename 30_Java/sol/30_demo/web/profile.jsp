<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>User Profile!</h1>
    <p>User Name: <%= request.getRemoteUser() %></p>
    <p>Principal Name: <%= request.getUserPrincipal().getName() %></p>
    <p>is Admin: <%= request.isUserInRole("boss") %></p>
  </body>
</html>

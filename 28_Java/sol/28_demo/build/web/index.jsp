<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <ul>
      <li>App Name: ${appName}</li>
      <li>App Version: ${appVersion}</li>
      <li>Base: ${base}</li>
    </ul>
  </body>
</html>
<% session.setAttribute("index", true); %>
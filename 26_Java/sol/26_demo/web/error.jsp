<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error</title>
  </head>
  <body>
    <h1>A nasty bug has occurred</h1>
    <% if (exception != null) { %>
<pre>
  <%= exception.getMessage().replaceAll("<", "&lt;").replaceAll(">", "&gt;") %>
</pre>
    <% } %>
  </body>
</html>

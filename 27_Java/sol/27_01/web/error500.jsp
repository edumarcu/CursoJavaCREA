<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exercise 27_01 Error Page</title>
  </head>
  <body>
    <h1>Ooops!</h1>
    <p>
      Something bad has happened:
    </p>
<pre>
<%= exception.getMessage().replace("<", "&lt;").replace(">", "&gt;") %>
</pre>
  </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exercise 27_01 Error Page</title>
  </head>
  <body>
    <h1>Ooops the requested page cannot be found!</h1>
    <p>
      The requested page was: <%= request.getAttribute("javax.servlet.forward.request_uri") %>
    </p>
  </body>
</html>

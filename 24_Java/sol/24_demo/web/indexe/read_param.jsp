<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>
      Your Name is <%= request.getParameter("username") %>
      and your age is <%= request.getParameter("age") %>
    </h1>
  </body>
</html>

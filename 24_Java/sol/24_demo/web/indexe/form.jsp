<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Send a Param</h1>
    <p>
      <a href="read_param.jsp?name=Victor">My name is Victor</a>
    </p>
    <p>
      <form action="read_param.jsp" method="POST">
        My name is
        <input type="text" name="username" />
        and I'm
        <input type="text" name="age" />
        years old.
        <input type="submit" value="Enviar" />
      </form>
    </p>
  </body>
</html>

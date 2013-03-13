<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <form method="POST" action="j_security_check">
      <p>
        <%
            String uri = (String) request.getAttribute("javax.servlet.forward.request_uri");
            if (uri.endsWith("j_security_check")) {
                out.print("<p>Datos de autenticación incorrectos.</p>");
            }
        %>
      </p>
      <p>
        Login:  <input type="text" name="j_username"><br />
        Password: <input type="password" name="j_password"><br />
        <input type="submit" value="Login!">
      </p>
   </form>
  </body>
</html>

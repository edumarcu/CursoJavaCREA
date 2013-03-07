<%--
    Document   : form
    Created on : 07-mar-2013, 13:02:45
    Author     : EM
    Comment: Get params form URL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Send a Param</h1>
        <p>
            <a href="read_param.jsp?name=Victor">My names is Victor</a>
        </p>

        <form action="read_param.jsp" method="GET">
        <%-- <form action="read_param.jsp" method="POST"> --%>
            <p>
              My name is:
              <input type="text" name="name" />
              <input type="submit" value="Enviar" />
              </p>
          </form>

    </body>
</html>

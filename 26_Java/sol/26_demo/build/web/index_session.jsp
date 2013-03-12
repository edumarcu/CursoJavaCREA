<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%
    Integer contador = (Integer) session.getAttribute("contador");
    if (contador == null) {
        contador = 0;
    } else {
        contador ++;
    }
    session.setAttribute("contador", contador);
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page - Cookies!</title>
  </head>
  <body>
    <h1>Session!</h1>
    <p>New? <%= session.isNew() %></p>
    <p>You have entered ${contador} times.</p>
    <p><a href="resetCounter">Reset Counter</a></p>
    <p><a href="<%= response.encodeURL("index_session.jsp") %>">Link Here</a></p>
  </body>
</html>

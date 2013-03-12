<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%
    boolean e = true;
    if (e) {
      throw new Exception("ERROOOOOOOOOR!");
    }
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

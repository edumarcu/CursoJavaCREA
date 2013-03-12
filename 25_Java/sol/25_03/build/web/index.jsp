<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String message = request.getParameter("message");
if ( message != null && message.length() > 0 ) {
    application.setAttribute("message", message);
    response.sendRedirect("index.jsp");
} else {
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Message</title>
  </head>
  <body>
    <h1>Message</h1>
    <p>${message}</p>
    <h2>Change Message</h2>
    <form action="index.jsp" method="GET">
      <input type="text" name="message" />
      <input type="submit" value="Change!" />
    </form>
  </body>
</html>
<% } %>
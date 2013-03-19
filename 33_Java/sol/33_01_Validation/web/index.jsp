<%@page import="curso.ej33.ErrorSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ErrorSet errors = (ErrorSet) request.getAttribute("errors");
    if (errors == null) {
        errors = new ErrorSet();
    }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Validation</title>
  </head>
  <body>
    <h1>Message</h1>
    <p>${message.text}</p>

    <h2>Update Message</h2>
    <p>${errormsg}</p>
    <form action="validate" method="GET">
      <%= errors.htmlErrorsFor("text") %>
      <input type="text" name="text" value="${text}"
             style="<%= errors.validField("text") ? "" : "border: 1px solid red;" %>"/>
      <input type="submit" value="Validate!" />
    </form>
  </body>
</html>

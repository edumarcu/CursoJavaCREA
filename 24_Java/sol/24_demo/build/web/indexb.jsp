<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
<%  String foo = "FOO"; %>

    <jsp:include page="_variables.jsp" />
<%--
    <jsp:include page="_variables.jsp" />
    <%@include file="_variables.jsp" %>
--%>
    <%@include file="_variables.jsp" %>
  </body>
</html>

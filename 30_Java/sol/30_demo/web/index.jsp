<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String query = request.getParameter("query");
    pageContext.setAttribute("queryAtt", query);
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
    <form action="index.jsp" method="GET">
      <input type="text" name="query"
             value="<c:out value="${queryAtt}" escapeXml="true"/>"/>
      <input type="submit" value="Search" />
    </form>
  </body>
</html>

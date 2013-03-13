<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    List<String> names = new ArrayList<String>();
    names.add("Pepe");
    names.add("Paco");
    names.add("Pedro");
    names.add("Pablo");
    request.setAttribute("namesList", names);
%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>
  <h1>Hello World!</h1>
  <ul>
    <c:forEach var="name" items="${requestScope.namesList}">
      <li>${name}</li>
    </c:forEach>
  </ul>
</body>
</html>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>JSP Objects</h1>
    <%
        request.setAttribute("foo", "FOO");
    %>
    <h2>Attributes in request 1</h2>
    <p>Request URI: <%= request.getRequestURI() %></p>
    <ul>
      <%
        Enumeration<String> names1 = request.getAttributeNames();

        while(names1.hasMoreElements()) {
            String name = names1.nextElement();
            String value = request.getAttribute(name) + "";
            out.print("<li><strong>" + name + "</strong>: " + value + "</li>");
        }
      %>
    </ul>
    <jsp:include page="_row.jsp" />
    <h2>Attributes in request 3</h2>
    <p>Request URI: <%= request.getRequestURI() %></p>
    <ul>
      <%
        Enumeration<String> names3 = request.getAttributeNames();

        while(names3.hasMoreElements()) {
            String name = names3.nextElement();
            String value = request.getAttribute(name) + "";
            out.print("<li><strong>" + name + "</strong>: " + value + "</li>");
        }
      %>
    </ul>
  </body>
</html>

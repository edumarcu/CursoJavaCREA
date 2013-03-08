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
        pageContext.setAttribute("foo", "FOO");
    %>
    <h2>Attributes in page 1</h2>
    <ul>
      <%
        Enumeration<String> names1 =
                pageContext.getAttributeNamesInScope(
                PageContext.PAGE_SCOPE);

        while(names1.hasMoreElements()) {
            String name = names1.nextElement();
            String value = pageContext.getAttribute(name) + "";
            out.print("<li><strong>" + name + "</strong>: " + value + "</li>");
        }
      %>
    </ul>
    <jsp:include page="_row.jsp" />
    <%@include file="_row.jsp" %>
  </body>
</html>

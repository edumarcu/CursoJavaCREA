<%--
    Document   : index_c
    Created on : 07-mar-2013, 10:10:51
    Author     : EM
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>JSP Objects</h1>
        <%
            pageContext.setAttribute("foo", "FOO");
        %>
        <ul>
            <%
                Enumeration<String> names = pageContext.getAttributeNamesInScope(PageContext.PAGE_SCOPE);
                 while (names.hasMoreElements()) {
                     String name = names.nextElement();
                     String value = pageContext.getAttribute(name) + " ";
                     out.print("<li><strong>" + name + "</strong>: " + value + "</li>");
                 }
            %>
        </ul>
        <jsp:include page="_row.jsp" />
        <%@include file="_row.jsp" %>
    </body>
</html>

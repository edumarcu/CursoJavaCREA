<%--
    Document   : _row
    Created on : 07-mar-2013, 10:11:26
    Author     : EM
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Attributes in page 2</h2>
 <ul>
    <%
        Enumeration<String> names2 = pageContext.getAttributeNamesInScope(PageContext.PAGE_SCOPE);
         while (names2.hasMoreElements()) {
             String name = names2.nextElement();
             String value = pageContext.getAttribute(name) + " ";
             out.print("<li><strong>" + name + "</strong>: " + value + "</li>");
         }
    %>
</ul>

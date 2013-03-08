<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
    <h2>Attributes in page 2</h2>
    <ul>
      <%
        Enumeration<String> names2 =
                pageContext.getAttributeNamesInScope(
                PageContext.PAGE_SCOPE);

        while(names2.hasMoreElements()) {
            String name = names2.nextElement();
            String value = pageContext.getAttribute(name) + "";
            out.print("<li><strong>" + name + "</strong>: " + value + "</li>");
        }
      %>
    </ul>
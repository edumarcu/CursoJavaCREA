<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
    <h2>Attributes in request 2</h2>
    <p>Request URI: <%= request.getRequestURI() %></p>
    <ul>
      <%
        Enumeration<String> names2 = request.getAttributeNames();

        while(names2.hasMoreElements()) {
            String name = names2.nextElement();
            String value = request.getAttribute(name) + "";
            out.print("<li><strong>" + name + "</strong>: " + value + "</li>");
        }
      %>
    </ul>
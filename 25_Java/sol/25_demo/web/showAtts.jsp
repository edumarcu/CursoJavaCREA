<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <ul>
      <li>URI: <%= request.getRequestURI() %></li>
      <%
          Enumeration<String> attNames = request.getAttributeNames();
          while(attNames.hasMoreElements()) {
              String attName = attNames.nextElement();
      %>
      <li><%= attName %>: <%= request.getAttribute(attName) %></li>
      <%
          }
      %>
    </ul>

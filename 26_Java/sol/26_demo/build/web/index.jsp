<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie chips = new Cookie("chips", "Ahoy!");
    chips.setComment("OLA KE ASE");
    // chips.setDomain("");
    // chips.setPath("");
    // chips.setHttpOnly(true);
    // chips.setSecure(false);
    chips.setMaxAge(10);

    response.addCookie(chips);

    Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page - Cookies!</title>
  </head>
  <body>
    <h1>Cookies!</h1>
    <% if (cookies == null) { %>
    <p>No Cookies</p>
    <% } else { %>
    <ul>
      <% for (Cookie cookie : cookies) { %>
      <li><%= cookie.getName() %>: <%= cookie.getValue() %></li>
      <% } %>
    </ul>
    <% } %>
  </body>
</html>

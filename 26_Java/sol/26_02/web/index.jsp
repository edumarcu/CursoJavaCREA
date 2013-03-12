<%@page import="curso.ej26_02.User"%>
<%@page import="curso.ej26_02.UserStorage"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%
    String login = (String) session.getAttribute("login");
    User user = UserStorage.getUserByLogin(login);
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exercise 26_02 Session</title>
  </head>
  <body>
    <h1>The most awesome example about sessions</h1>
    <% if (user == null) { %>
    <form action="login" method="POST">
      Login: <input type="text" name="login" /><br />
      Password: <input type="password" name="passw" /><br/>
      <input type="submit" value="Login!" />
    </form>
    <% } else { %>
    <img src="avatars/user_<%= user.getLogin() %>.jpg" />
    <h2>Welcome, <%= user.getFullName() %></h2>
    <form action="logout" method="POST">
      <input type="submit" value="Logout!" />
    </form>
    <% } %>
  </body>
</html>

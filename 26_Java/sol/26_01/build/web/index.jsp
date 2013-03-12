<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Default Style
    String style = "black";
    // Valid Styles
    List<String> validStyles = new ArrayList<String>();
    validStyles.add("black");
    validStyles.add("red");
    validStyles.add("green");
    validStyles.add("blue");

    // User Style
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
          if (cookie.getName().equalsIgnoreCase("stylePref")) {
              String cookieStyle = cookie.getValue();
              if (validStyles.contains(cookieStyle)) {
                  style = cookieStyle;
                  break;
              }
          }
      }
    }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exercise 26_01 Cookies</title>
    <link rel="stylesheet" type="text/css" href="css/<%= style %>.css">
  </head>
  <body>
    <h1>Cookies</h1>
    <h2>Choose a style</h2>
    <form action="savePrefs" method="POST">
      <select name="styleParam">
        <option value="black" <%= "black".equals(style) ? "selected" : "" %> >Black</option>
        <option value="red" <%= "red".equals(style) ? "selected" : "" %> >Red</option>
        <option value="green"  <%= "green".equals(style) ? "selected" : "" %> >Green</option>
        <option value="blue" <%= "blue".equals(style) ? "selected" : "" %> >Blue</option>
      </select>
      <input type="submit" value="Save" />
    </form>
    <p>
      <a href="clearPrefs">Clear Preferences</a>
    </p>
  </body>
</html>
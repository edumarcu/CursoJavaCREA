<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <% request.setAttribute("title", "Task List"); %>
  <%@include file="_headers.jsp" %>
  <script type="text/javascript" src="${base}/js/index.js"></script>
</head>
<body>
  <h1>Task List</h1>
  <div class="menu">
    <ul>
      <li><a href="${base}/add">Add task</a></li>
    </ul>
  </div>

  <h2>To do</h2>
  <table class="todo">
  </table>

  <h2>Done</h2>
  <table class="done">
  </table>
</body>
</html>

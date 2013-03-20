<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <% request.setAttribute("title", "Task List - Add Task"); %>
  <%@include file="_headers.jsp" %>
  <script type="text/javascript" src="${base}/js/edit_form.js"></script>
</head>
<body>
  <h1>Task List</h1>
  <div class="menu">
    <ul>
      <li><a href="${base}/index">Task List</a></li>
    </ul>
  </div>

  <h2>Add Task</h2>
  <form class="post" action="${base}/rest/task" method="POST">
    <input type="text" size="80" name="text" /><br />
    <input type="submit" value="Create New Task" />
  </form>
</body>
</html>

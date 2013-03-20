<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <% request.setAttribute("title", "Task List - Edit Task"); %>
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

  <h2>Edit Task</h2>
  <form class="put" action="${base}/rest/task" method="PUT">
    <input type="hidden" name="id" value="${task.id}" />
    <input type="text" size="80" name="text" value="${task.text}" /><br />
    <input type="submit" value="Save Task" />
  </form>
</body>
</html>

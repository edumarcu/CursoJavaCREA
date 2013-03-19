<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="${base}/css/style.css" />
  <title>Task List - Edit Task</title>
</head>
<body>
  <h1>Task List</h1>
  <div class="menu">
    <ul>
      <li><a href="${base}/index">Task List</a></li>
    </ul>
  </div>

  <h2>Edit Task</h2>
  <form action="${base}/edit" method="POST">
    <input type="hidden" name="id" value="${task.id}" />
    <input type="text" size="100" name="text" value="${task.text}" /><br />
    <input type="submit" value="Save Task" />
  </form>
</body>
</html>

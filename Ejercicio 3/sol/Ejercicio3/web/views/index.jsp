<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="${base}/css/style.css" />
  <title>Task List</title>
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
    <c:forEach var="task" items="${todo}">
    <tr>
      <td>${task.text}</td>
      <td><a href="${base}/done?id=${task.id}">Done</a></td>
      <td><a href="${base}/edit?id=${task.id}">Edit</a></td>
      <td><a href="${base}/delete?id=${task.id}">Delete</a></td>
    </tr>
    </c:forEach>
  </table>

  <h2>Done</h2>
  <table class="done">
    <c:forEach var="task" items="${done}">
    <tr>
      <td>${task.text}</td>
      <td><a href="${base}/undone?id=${task.id}">Undone</a></td>
      <td><a href="${base}/edit?id=${task.id}">Edit</a></td>
      <td><a href="${base}/delete?id=${task.id}">Delete</a></td>
    </tr>
    </c:forEach>
</body>
</html>

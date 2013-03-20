<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include  file="_layout/header.jsp"%>
<h2>Apartado C</h2>
<p>
  Cree un filtro para registrar en la base de datos todos los accesos al servidor.
</p>
<h3>Accesos al servidor</h3>
<table>
  <thead>
    <tr>
      <th>Date</th>
      <th>IP</th>
      <th>Method</th>
      <th>Path</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="entry" items="${entries}">
      <tr>
        <td>${entry.createdAt}</td>
        <td>${entry.ip}</td>
        <td>${entry.method}</td>
        <td>${entry.path}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="_layout/header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach var="logEntry" items="${entries}">
        <tr>
            <td>${logEntry.getCreatedAt()}</td>
            <td>${logEntry.getIp()}</td>
            <td>${logEntry.getMethod()}</td>
            <td>${logEntry.getPath()}</td>
        </tr>
        </c:forEach>
</tbody>
</table>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include  file="_layout/header.jsp"%>
<h2>Apartado B</h2>
<p>
  Guarde en la variable de sesión una serie de números y calcule su suma.
</p>
<h3>Números</h3>
<p>
<ul>
  <c:forEach var="n" items="${numbers}">
    <li>${n}</li>
  </c:forEach>
</ul>
<form action="${base}/b" method="POST">
  <input type="hidden" name="action" value="add" />
  <input type="input" name="number" size="3"/>
  <input type="submit" value="Añadir" />
</form>
<br/>
<strong>SUMA: ${total}</strong>
</p>
<%@include  file="_layout/footer.jsp"%>
<p>
<form action="${base}/b" method="POST">
  <input type="hidden" name="action" value="reset" />
  <input type="submit" value="Reset Numbers" />
</form>
</p>
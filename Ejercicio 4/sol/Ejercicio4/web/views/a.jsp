<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include  file="_layout/header.jsp"%>
<h2>Apartado A</h2>
<p>
  Muestre por pantalla los divisores de un número dado.
</p>
<form action="${base}/a" method="GET">
<p>
  Los divisores de
  <input type="input" name="number" value="${number}" size="3"/>
  son:
  <br/>
  <input type="submit" value="Calcular" />

  <ul>
    <c:forEach var="divisor" items="${divisors}">
      <li>${divisor}</li>
    </c:forEach>
  </ul>
</p>
</form>
<%@include  file="_layout/footer.jsp"%>
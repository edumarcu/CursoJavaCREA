<%--
    Document   : index_b
    Created on : 07-mar-2013, 9:57:22
    Author     : EM
    Pattern Composite View
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:include page="_variables.jsp" />
        <%--
        el de jsp include inserta el resultado de ejecutar la pagina, include inserta la pagina
            por lo que solo puede estar declarado una vez la variable en el @include
         --%>
        <%--
        <jsp:include page="_variables.jsp" />
         <%--
        <%@include file="_variables.jsp" %>
        --%>
        <%@include file="_variables.jsp" %>
    </body>
</html>

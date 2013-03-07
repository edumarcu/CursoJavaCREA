<!--
Ejercicio 03_03
===============

En este ejercicio comenzará a poner en práctica los conocimientos de la sintaxis
de JSP.

Cada apartado se deberá completar en el lugar correspondiente en este
fichero index.php

 a) Almacene el resultado de operar 3 * 4 en una variable.
    Imprima el valor de esa variable.

 b) Almacene el resultado de operar 3.33 * 4.33 en una variable.
    Imprima el resultado con una precision de 3 decimales.

 b.1) El resultado real es 14.4189. ¿Ha impreso el mismo resultado? ¿Por qué?

 c) Compruebe si 9.95 * 100 es igual a 995 y escríbalo.

 c.1) Puede que el resultado salga que es desigual.
      En este caso, pruebe a mostrar el resultado con 30 decimales y
      repita este apartado arreglando el error.

-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ejercicio 03_03: Variables</title>
    <style type="text/css">
        html {
            background-color: #f0f7ff;
            font-family: 'Helvetica', sans-serif;
            color: #777A75;
            font-size: 10pt;
            text-shadow: 0px 1px 0px white;
        }
        body {
            width: 720px;
            border: 1px solid #d3d7cf;
            margin: 90px auto 40px auto;
            padding: 10px 30px 20px 30px;
            background-color: #fefefe;
            border-radius: 15px;
            box-shadow: 0px 1px 10px #d3d7cf;
        }
        h1:first-of-type {
            top: 25px;
            position: absolute;
            text-align: center;
            width: 720px;
        }
        h1 {
            text-shadow: 0px 2px 0px white;
            font-size: 14pt;
        }
        h2 {
            font-size: 12pt;
            margin: 20px 0px 10px 0px;
        }
        h3 {
            font-size: 10pt;
        }
        h2, strong, th, dt {
            color: #555753;
        }
    </style>
</head>
<body>
    <h1>Ejercicio 03_03: Variables</h1>
    <h2>Parte A</h2>
    <%
        int resa = 3 * 4;
    %>
    <p>3 * 4 = <%= resa %></p>

    <h2>Parte B</h2>
    <%
        float resb = 3.33f * 4.33f;
    %>
    <p>3.33 * 4.33 = <%= String.format("%.3f", resb) %></p>

    <h2>Parte C</h2>
    <%
        boolean resc= 9.95 * 100 == 995.0;
    %>
    <p>¿ 9.95 * 100 == 995 ? <%= resc %></p>
    <p>9.95 * 100 = <%= 9.95 * 100 %>
</body>
</html>

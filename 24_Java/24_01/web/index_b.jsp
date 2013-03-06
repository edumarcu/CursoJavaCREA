<%--
Ejercicio 24_01_b
===============

En este ejercicio va a continuar probando los fundamentos de la sintaxis de JSP.

 a) Cree tres variables que contengan la siguiente información:

     * nombre
     * apellido
     * año de nacimiento

 b) Muestre la información usando una tabla HTML.

    Debe ser similar a esta:

      +====================+=====================+============================+
      |       Nombre       |      Apellido       |       Edad en 2012         |
      +====================+=====================+============================+
      |  <nombre alumno>   |  <apellido alumno>  | <2012 – año de nacimiento> |
      +====================+=====================+============================+

--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ejercicio 24_01_b: Variables</title>
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
    <style type="text/css">
        table, td {
            border: 1px solid grey;
            min-width: 100px;
            min-height: 20px;
            text-align: center;
            padding: 2px;
        }
    </style>
</head>
<body>
    <h1>Ejercicio 24_01_b: Variables</h1>
    <%
        String nombre = "Eduardo";
        String apellido = "Marcuello";
        int añoDeNacimiento = 1982;
    %>
    <table style="margin: 0 auto;">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Edad en 2013</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><%= nombre %></td>
                <td><%= apellido %></td>
                <td><%= 2013 -  añoDeNacimiento %></td>
            </tr>
        </tbody>
    </table>
</body>
</html>

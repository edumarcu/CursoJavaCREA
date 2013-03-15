<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Front Controller</title>
    </head>
    <body>
        <h1>Nos han subido loshh chucheshh!</h1>
        <p>Your name is: ${name}</p>
        <form name="input" action="${base}/html/rename" method="post" >
            Enter your name: <input type="text" name="name" >
            <input type="submit" value="Rename!">
        </form>
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Hello!</h1>
    <p>Your Name is: ${name}</p>
    <h2>Change Name</h2>
    <form action="${base}/html/update" method="POST" >
      <input type="text" name="name" value="${name}"/><br />
      <input type="submit" value="Change!" />
    </form>
  </body>
</html>

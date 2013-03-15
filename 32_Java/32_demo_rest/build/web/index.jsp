<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>User List</title>

  <script type="text/javascript" src="jquery.js"></script>
  <script type="text/javascript" >
    $(function() {
      $.ajax( {
              url: "servlet/user",
              dataType: "json",
              async: false
              }
            ).done(function(json) {
                $("#list").html("");
                json.forEach(function(user) {
                  $("#list").append("<li>" + user.id + ":" + user.name + "</li>");
                });
            });
    });
  </script>
</head>
<body>
  <h1>User List</h1>
  <ul id="list">

  </ul>
</body>
</html>

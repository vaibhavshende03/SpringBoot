<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/style.css" />
    <title>Login</title>
  </head>
  <body>
    <h1>Login</h1>

    <c:if test="${not empty errorMsg}">
      <h4 style="color: red">${errorMsg}</h4>
    </c:if>
    <form action="/LoginForm" method="post">
      <label for="email">Email:</label>
      <input type="text" id="email" name="email" required />
      <br /><br />
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required />
      <br /><br />

      <input type="submit" value="Login" />
    </form>
    <br />
    <br />

    If Not Registered <a href="regPage"><b>Click Here to Register..</b></a>
  </body>
</html>

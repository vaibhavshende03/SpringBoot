<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/style.css" />
    <title>Register</title>
  </head>
  <body>
    <h1>Register</h1>

    <c:if test="${not empty successMsg}">
      <h4 style="color: green">${successMsg}</h4>
    </c:if>
    <c:if test="${not empty errorMsg}">
      <h4 style="color: red">${errorMsg}</h4>
    </c:if>
    <form action="/registerForm" method="post">
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" required />
      <br /><br />
      <label for="email">Email:</label>
      <input type="text" id="email" name="email" required />
      <br /><br />
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required />
      <br /><br />
      <label for="name">Phone No.:</label>
      <input type="text" id="phoneno" name="phoneno" required />

      <br /><br />
      <input type="submit" value="Register" />
    </form>
    <br />
    <br />

    If Already Registered <a href="loginpage"><b>Click Here to Login..</b></a>
  </body>
</html>

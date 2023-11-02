<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

<div class="login-container">
  <h2>Login</h2>
  <form:form id="loginForm" modelAttribute="User" action="createlogin" method="post">
    <div class="input-group">
      <form:label path="emailId">Email</form:label>
      <form:input path="emailId" type="email" id="email" required="true" />
    </div>
    <div class="input-group">
      <form:label path="password">Password</form:label>
      <form:password path="password" id="password" required="true" />
    </div>
    <button type="submit">Login</button>
  </form:form>
</div>

    </body>
</html>
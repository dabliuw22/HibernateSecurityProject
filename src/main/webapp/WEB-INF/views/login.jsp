<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
	</head>
	<body>
		<form action="${ loginUrl }" method="POST">
			<label>Username</label>
			<input type="text" id="username" name="username"/>
			<label>Password</label>
			<input type="password" id="password" name="password"/>
			<label>Remember Me</label>
			<input type="checkbox" id="remember" name="remember"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Login"/>
		</form>
		<a href="<c:url value='/'/>">Inicio</a>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>nuevo usuario</title>
	</head>
	<body>
		<h1>Registro Usuario</h1>
		<form:form method="POST" modelAttribute="user" action="registro">
			<div class="row">
				<label>Nombre</label>
				<form:input type="text" path="nombre" id="nombre" />
				<form:errors path="nombre"></form:errors>
			</div>
			<div class="row">
				<label>Apellidos</label>
				<form:input type="text" path="apellidos" id="apellidos" />
				<form:errors path="apellidos"></form:errors>
			</div>
			<div class="row">
				<label>Username</label>
				<form:input type="text" path="username" id="username" />
				<form:errors path="username"></form:errors>
			</div>
			<div class="row">
				<label>Email</label>
				<form:input type="text" path="email" id="email" />
				<form:errors path="email"></form:errors>
			</div>
			<div class="row">
				<label>Password</label>
				<form:password path="password" id="password" />
				<form:errors path="password"></form:errors>
			</div>
			
			<input type="submit" value="Registro"/>
		</form:form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User View</title>
	</head>
	<body>
		<sec:authentication property="principal.username" var="u"/>
		<sec:authentication property="principal.authorities" var="roles"/>
		<h1>Welcome ${u} User View</h1>
		<c:forEach items="${roles}" var="rol">
			<p>${rol}</p>
		</c:forEach>
		<a href="<c:url value='/user'/>">User</a>
		<a href="<c:url value='/admin'/>">Admin</a>
		<a href="<c:url value='/'/>">Inicio</a>
		<form:form action="logout" method="POST">
			<input type="submit" value="Salir"/>
			<sec:csrfInput/>
		</form:form>
	</body>
</html>
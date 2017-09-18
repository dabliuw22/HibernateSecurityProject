<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
	</head>
	<body>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" var="u"/>
			<sec:authentication property="principal.authorities" var="roles"/>
			<p>Welcome</p> <h1>${u}</h1> <p>Index</p>
			<c:forEach items="${roles}" var="rol" >
				<p>${rol}</p>
			</c:forEach>
			<a href="<c:url value='/user'/>">User</a>
			<a href="<c:url value='/admin'/>">Admin</a>
			<form:form action="logout" method="POST">
				<input type="submit" value="Salir"/>
				<sec:csrfInput/>
			</form:form>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<a href="<c:url value='/login'/>">Login</a>
			<a href="<c:url value='/form-user'/>">Sing Up</a>
		</sec:authorize>
	</body>
</html>
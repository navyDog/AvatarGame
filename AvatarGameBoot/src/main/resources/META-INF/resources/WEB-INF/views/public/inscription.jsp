<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>

<div class="container">
		<h1>creation users</h1>
		<form:form method="post" action="${ctx}/inscription"
			modelAttribute="compte">
			<div class="form-group">
				<form:label path="login">login:</form:label>
				<form:input path="login" class="form-control" />
				<form:errors path="login" element="div" class="alert alert-danger"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="password">password:</form:label>
				<form:input path="password" class="form-control" />
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-outline-success">enregistrer</button>
				<a href="${ctx}/home" class="btn btn-outline-warning">annuler</a>
			</div>
		</form:form>
	</div>



</body>
</html>
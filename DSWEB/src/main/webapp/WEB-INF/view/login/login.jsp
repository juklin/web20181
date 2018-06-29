<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<l:url var "url_base" value="/" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Store</title>
<link rel="stylesheet" href="${url_base}css/bootstrap.min.css"/>
</head>
<body>
	<div class="container">
		<h1>Realizar Login</h1>
		<c:if test="${not empty msg}">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<p>${msg}</p>
			</div>
		</c:if>
		<jsp:include page="form_login.jsp"></jsp:include>
		<form action="${url_base}/usuarios/add">
			<button type="submit" class="btn btn-default">Cadastrar-se</button>
		</form>
	</div>
	<script src="${url_base}js/jquery-3.2.1.min.js"></script>
	<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>
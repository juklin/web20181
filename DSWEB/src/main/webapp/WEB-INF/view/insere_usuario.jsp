<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Cadastrar Usuário</title>
	<u:url var="url_base" value="/" />
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>

<div class="container">
	<h1>Cadastrar Usuário</h1>
	
	<u:if test="${not empty msg}">
		<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<p>${msg}</p>
		</div>
	</u:if>

	<jsp:include page="form_usuario.jsp" />
</div>
<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
<script src="${url_base}js/jquery-3.2.1.min.js"></script>
<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Altera Produto</title>
	<p:url var="url_base" value="/" />
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
	<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>

	<div class="container">
		<h1>Altera Produto</h1>
		<jsp:include page="form_produto.jsp" />
	</div>
<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>	
<script src="${url_base}js/jquery-3.2.1.min.js"></script>
<script src="${url_base}js/bootstrap.min.js"></script>
</body>
</html>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<p:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Histórico</title>
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
	<h1>Alo mundo</h1>
<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>	
</body>
</html>
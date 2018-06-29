<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core"%>
<u:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Lista de Usuários</title>
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>

<div class="container">
	<h1>Lista de Usuários</h1>
	<u:if test="${not empty msg}">
		<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<p>${msg}</p>
		</div>
	</u:if>
	<u:if test="${not empty usuarios}">
	<table id="tabela_usarios" class="table table-hover">
		<thead>
			<tr><th>Nome</th><th>CPF</th><th>Data de Nascimento</th><th>Endereço</th><th>Login</th>
			<th>Ação</th></tr>
		</thead>
		<tbody>
		<u:forEach var="p" items="${usuarios}">
			<tr><td>${p.nome}</td><td>${p.cpf}</td><td>${p.dataNasc}</td><td>${p.endereco}</td><td>${p.login}</td>
			<td><a href="${url_base}usuarios/${p.login}/delete" class="btn btn-danger" onclick="return confirm('Confirma remoção?')" >Deleta</a></td>
			</tr>
		</u:forEach>
		</tbody>
	</table>
	</u:if>
</div>

<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
<script src="${url_base}js/jquery-3.2.1.min.js"></script>
<script src="${url_base}js/bootstrap.min.js"></script>
<script>
</script>
</body>
</html>
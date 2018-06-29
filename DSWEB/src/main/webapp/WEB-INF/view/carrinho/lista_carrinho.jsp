<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<p:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Carrinho de Compras</title>
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>

<div class="container">
	<h1>Carrinho de Compras</h1>
	<p:if test="${not empty msg}">
		<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<p>${msg}</p>
		</div>
	</p:if>
	<p:if test="${empty carrinho}">Carrinho vazio</p:if>
	<p:if test="${not empty carrinho}">
	<table id="tabela_carrinho" class="table table-hover">
		<thead>
			<tr><th>Nome</th><th>Preço</th><th>Ação</th></tr>
		</thead>
		<tbody>
		<p:forEach var="p" items="${carrinho.produtos}">
			<tr><td>${p.nome}</td><td>${p.preco}</td>
				<td><a href="${url_base}carrinho/${p.id}/deletar" class="btn btn-danger" onclick="return confirm('Confirma remoção?')" >Remover do carrinho</a></td>
			</tr>
		</p:forEach>
		</tbody>
	</table>
	<td><a href="${url_base}carrinho/finalizar_compra" class="btn btn-success">Finalizar compra</a></td>
	</p:if>
</div>
<script src="${url_base}js/jquery-3.2.1.min.js"></script>
<script src="${url_base}js/bootstrap.min.js"></script>
<script>
</script>
</body>
</html>
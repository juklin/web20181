<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<p:url var="url_base" value="/" />
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Lista de Produtos</title>
	<link rel="stylesheet" href="${url_base}css/bootstrap.min.css" />
</head>
<body>
	<jsp:include page="${url_base}WEB-INF/view/header.jsp"></jsp:include>
	
	<div class="container">
		<h1>Lista de Produtos</h1>
		<p:if test="${not empty msg}">
			<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<p>${msg}</p>
			</div>
		</p:if>
		<p:if test="${usuario_logado.login eq 'admin'}">
			<a href="/produtos/add" class="btn btn-primary">Adicionar produto</a>
		</p:if>
		<p:if test="${not empty produtos}">
		<table id="tabela_produtos" class="table table-hover">
			<thead>
				<tr><th>Nome</th><th>Preço</th><th>Ação</th></tr>
			</thead>
			<tbody>
			<p:forEach var="p" items="${produtos}">
				<tr><td>${p.nome}</td><td>${p.preco}</td>
				<p:if test="${usuario_logado.login eq 'admin'}">
					<td><a href="${url_base}produtos/${p.id}/update" class="btn btn-primary">Alterar</a></td>
					<td><a href="${url_base}produtos/${p.id}/delete" class="btn btn-danger" onclick="return confirm('Confirma remoção?')" >Deleta</a></td>
				</p:if>
				<p:if test="${empty usuario_logado}">
					<td><a href="${url_base}login" class="btn btn-success">Comprar</a></td>
				</p:if>
				<p:if test="${not empty usuario_logado}">
					<p:if test="${usuario_logado.login ne 'admin'}">
						<td><a href="${url_base}carrinho/${p.id}/comprar" class="btn btn-success">Comprar</a></td>
					</p:if>
				</p:if>
				</tr>
			</p:forEach>
			</tbody>
			
		</table>
		</p:if>
	</div>
	

<jsp:include page="${url_base}WEB-INF/view/footer.jsp"></jsp:include>
<script src="${url_base}js/jquery-3.2.1.min.js"></script>
<script src="${url_base}js/bootstrap.min.js"></script>
<script>
</script>
</body>
</html>
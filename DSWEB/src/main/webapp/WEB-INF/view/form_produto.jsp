<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="post" modelAttribute="produto" action="${url_base}/produtos" acceptCharset="UTF-8" enctype="multipart/form-data">
	<form:input path="id" type="hidden"  />
	
	<spring:bind path="nome">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="nome">Nome</form:label>
		<form:input path="nome" type="text" cssClass="form-control" />
		<form:errors path="nome" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="preco">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="preco">Preço</form:label>
		<form:input path="preco" type="text" cssClass="form-control" />
		<form:errors path="preco" class="control-label" />
	</div>
	</spring:bind>
	
	
	<button type="submit" class="btn btn-primary">Salvar</button>
</form:form>
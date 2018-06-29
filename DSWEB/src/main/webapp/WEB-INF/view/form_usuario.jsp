<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="post" modelAttribute="usuario" action="${url_base}/usuarios">
	
	<spring:bind path="nome">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="nome">Nome</form:label>
		<form:input path="nome" type="text" cssClass="form-control" />
		<form:errors path="nome" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="cpf">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="cpf">CPF</form:label>
		<form:input path="cpf" type="text" cssClass="form-control" />
		<form:errors path="cpf" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="dataNasc">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="dataNasc">Data de Nascimento</form:label>
		<form:input path="dataNasc" type="date" cssClass="form-control" />
		<form:errors path="dataNasc" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="endereco">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="endereco">Endereço</form:label>
		<form:input path="endereco" type="text" cssClass="form-control" />
		<form:errors path="endereco" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="login">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="login">Login</form:label>
		<form:input path="login" type="text" cssClass="form-control" />
		<form:errors path="login" class="control-label" />
	</div>
	</spring:bind>
	
	<spring:bind path="senha">
	<div class="form-group ${status.error ? 'has-error' : ''}">
		<form:label path="senha">Senha</form:label>
		<form:input path="senha" type="password" cssClass="form-control" />
		<form:errors path="senha" class="control-label" />
	</div>
	</spring:bind>
	
	<button type="submit" class="btn btn-primary">Salvar</button>
</form:form>
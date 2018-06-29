<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="url_base" value="/" />
<nav class="navbar navbar-inverse" style="background-color:#FFE4E1">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#" style="color:Black">Store</a>
		</div>
		
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${not empty usuario_logado}">
				<li><a href="${url_base}carrinho" style="color:Black" ><span
						class="glyphicon glyphicon-shopping-cart"></span> Meu carrinho</a></li>
				<li><a href="#" style="color:Black" ><span
						class="glyphicon glyphicon-user"></span> ${login}</a></li>
				
				<li><a href="${url_base}logout" style="color:Black"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>					
			</c:if>
			<c:if test="${empty usuario_logado}">
				<li><a href="${url_base}usuarios/add"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${url_base}login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
				
			</c:if>
		</ul>
	</div>
</nav>
<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<!-- bootstrap -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap-theme.min.css'/>">

<!-- style -->
<link rel="stylesheet" href="<c:url value='/assets/css/index.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/forms.css'/>">
<jsp:invoke fragment="extraStyles" />
</head>

<body>

	<!-- INICIO NAV (alterar pra include)-->

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#menu" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<c:url value="/login" var="loginLink" />
				<a class="navbar-brand" href="${loginLink}"> Logar-se!</a>

			</div>
			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#menu" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<c:url value="/user/cadastro_usuario" var="cadastroLink" />
				<a class="navbar-brand" href="${cadastroLink}"> Cadastrar-se!</a>

			</div>
			<sec:authorize access="isAuthenticated()">
				<div class="navbar-header">

					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#menu" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<c:url value="/product" var="productLink" />
					<a class="navbar-brand" href="${productLink}"> Produtos</a>

				</div>
				</sec:authorize>
				 <sec:authorize access="hasRole('ROLE_ADMIN')">
				<div class="navbar-header">

					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#menu" aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<c:url value="/category" var="categoryLink" />
					<a class="navbar-brand" href="${categoryLink}"> Categorias</a>

				</div>
			</sec:authorize>
		</div>
	</nav>

	<!-- FINAL NAV -->
	<jsp:doBody />

	<script src="<c:url value='/assets/js/jquery-2.1.4.min.js'/>"></script>
	<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
	<jsp:invoke fragment="extraScripts" />

</body>
</html>

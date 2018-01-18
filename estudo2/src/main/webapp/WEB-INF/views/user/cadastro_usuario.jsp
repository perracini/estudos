<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Usuário</title>

</head>
<body>

	<form:form action="${spring:mvcUrl('UC#save').build()}" method="post" commandName="user">
		<div>
			<label for="name">Nome</label>
			<form:input path="name" id="name" />
			<form:errors path="name" />
		</div>
		<div>
			<label for="username">Login</label>
			<form:input path="username" id="username" />
			<form:errors path="username" />
		</div>
		<div>
			<label for="password">Senha</label>
			<form:input path="password" id="password" />
			<form:errors path="password" />
		</div>
		<div>
			<label for="passwordConfirm">Confirmar Senha</label>
			<form:input path="passwordConfirm" id="passwordConfirm" />
			<form:errors path="passwordConfirm" />
		</div>
		<div>
			<input name="submit" type="submit" value="Cadastrar" />
		</div>

	</form:form>
</body>
</html>
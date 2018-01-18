<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Product Details</title>
</head>
<body>
	<form:form servletRelativeAction="/shopping" method="post"
		commandName="product">
		<input type="hidden" value="${product.id}" name="productId" />
		<table>
			<tr>
				<td>
					<p>${product.description}<br /></p>
				</td>
			</tr>
			<tr>
				<td><label for="category">category -
						${product.category.name}</label></td>
			</tr>
			<tr>
				<td><label for="price">price - ${product.price}</label></td>
			</tr>
		</table>
		<sec:authorize access="isAuthenticated()">
		<input type="submit" alt="Compre agora" title="Compre agora '${product.name}'!" value="comprar" />
		</sec:authorize>
	</form:form>

</body>
</html>
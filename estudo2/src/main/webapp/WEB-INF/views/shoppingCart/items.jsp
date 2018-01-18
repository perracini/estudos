<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>


</head>

<body class="cart">

	<header id="layout-header">
		<div class="clearfix container">
			<a href="/" id="logo"></a>
			<div id="header-content">
				<nav id="main-nav">
					<ul class="clearfix">
						<li><a href="${shoppingCartUrl}" rel="nofollow">Seu carrinho (${shoppingCart.quantity})</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	<section class="container middle">
		<h2 id="cart-title">Seu carrinho de compras</h2>
		<table id="cart-table">
			<colgroup>
				<col class="item-price-col">
				<col class="item-quantity-col">
				<col class="line-price-col">
			</colgroup>

			<tr>
				<th width="70%">Item</th>
				<th width="10%">Preço</th>
				<th width="10%">Quantidade</th>
				<th width="10%">Total</th>
			</tr>

			<c:forEach items="${shoppingCart.list}" var="item">
				<tr>
					<td>${item.product.name}-${item.category}</td>
					<td>${item.price}</td>
					<td>${shoppingCart.getQuantity(item)}</td>
					<td>${shoppingCart.getTotal(item)}</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="2"><c:url value="/shopping/checkout" var="checkoutUrl" /> 
				<form:form servletRelativeAction="/shopping/checkout" method="post">
						<input type="submit" class="checkout" name="checkout" value="Finalizar compra" id="checkout" />
				</form:form></td>
				<td></td>
				<td class="numeric-cell">${shoppingCart.total}</td>
			</tr>
		</table>

	</section>
</body>
</html>

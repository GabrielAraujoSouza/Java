<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Minha Página</title>

<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/sticky-footer.css">
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="container">
		<!-- 		<ol class="breadcrumb"> -->
		<!-- 			<li class="active">Inicio</li> -->
		<!-- 		</ol> -->
		<c:if test="${not empty msg }">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:out escapeXml="false" value="${msg }" />
			</div>
		</c:if>
		<c:choose>
			<c:when test="${not empty ItensCarrinho}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Produto</th>
							<th class="text-center">Quant.</th>
							<th class="text-right">Preço</th>
							<th class="text-right">Total</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${ItensCarrinho}">
							<tr>
								<td>${item.indice}</td>
								<td>${item.produto}</td>
								<td class="text-center">${item.quantidade}</td>
								<td class="text-right"><fmt:setLocale value="pt_BR" /> <fmt:formatNumber
										value="${item.preco.number}" type="currency"/></td>
								<td class="text-right"><fmt:setLocale value="pt_BR" /> <fmt:formatNumber
										value="${item.total.number}" type="currency"/></td>
								<td class="text-center"><a href="?Remove=${item.id}"><span
										class="glyphicon glyphicon-remove" style="color: #FF0000;"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2"><a href="?Clear=true" class="btn btn-primary continue-button">Esvaziar carrinho</a></td>
							<td colspan="4" class="text-right"><h4>
									Total de Compras:
									<fmt:setLocale value="pt_BR" />
									<fmt:formatNumber value="${TotalProdutos.number}"
										type="currency" />
								</h4></td>
						</tr>
					</tfoot>
				</table>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="col-md-8 col-md-offset-2 empty-cart-wrapper">
						<div class="col-md-2 empty-cart-sign">:(</div>
						<article class="col-md-10 empty-cart-message">
							<div class="empty-cart-header-message">Ops! Seu carrinho
								está vazio.</div>
							<div class="empty-cart-content-message">
								Para inserir produtos no carrinho, navegue pelo shopping ou
								utilize a busca do site. Ao encontrar os produtos desejados,
								clique no botão <span class="green-text">Comprar</span>.
							</div>
							<div class="back-shopping-buttons buttons-wrapeer">
								<a href="ofertas" class="btn btn-primary continue-button">Continuar
									comprando</a>
							</div>
						</article>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">Stationery.Store &#169 2017</p>
		</div>
	</footer>
	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
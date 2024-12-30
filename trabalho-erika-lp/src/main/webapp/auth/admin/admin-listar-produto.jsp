<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>


<link
	href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>


</head>
<body>
	<jsp:include page="/publica/publica-nav.jsp" />

	<div class="container">
		<div class="row">
			
		<div class="col">
				<h2>
					Produtos
				</h2>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Descrição</th>
							<th>Categoria</th>
							<th>Data de Entrada</th>
							<th>Preço de Custo</th>
							<th>Preço de Venda</th>
							<th>Quantidade</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="produto" items="${listaProdutos}">
							<tr>
								<td><c:out value="${produto.id}" /></td>
								<td><c:out value="${produto.descricao}" /></td>
								<td><c:out value="${produto.categoria}" /></td>
								<td><fmt:formatDate value='${produto.dataEntrada}'
										type='date' pattern='dd/MM/yyyy' /></td>
								<td><c:out value="${produto.preco_custo}" /></td>
								<td><c:out value="${produto.preco_venda}" /></td>
								<td><c:out value="${produto.quantidade}" /></td>
																
								<td> 																			
									<a class="btn btn-outline-danger btn-sm"
									onclick="return confirm('Você deseja apagar?');"
									href="${pageContext.request.contextPath}/auth/admin?acao=apagar&id=<c:out value="${produto.id}" />">
									Apagar</a>
								</td>	
									
									
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>

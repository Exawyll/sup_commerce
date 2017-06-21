<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.imie.supcommerce.model.Product"
	import="fr.imie.supcommerce.dao.ProductDao"%>
<%@include file="header.jsp"%>

<table class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Delete</th>
		</tr>
	</thead>
	<c:forEach items="${products}" var="p">
		<tr>
			<td><c:out value="${p.name}" /></td>
			<td><c:out value="${p.description}" /></td>
			<td><c:out value="${p.price}" /></td>
			<td>
				<form action="/SupCommerce/auth/removeProduct" method="post">
					<input type="hidden" name="id" value="${p.id}" />
					<button class="btn btn-danger glyphicon glyphicon-trash" aria-hidden="true"></button>
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

<%@include file="footer.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.imie.supcommerce.entity.Category"
	import="fr.imie.supcommerce.dao.CategoryDao"%>
<%@include file="../header.jsp"%>

<h1>List of categories</h1>

<table class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Actions</th>
		</tr>
	</thead>
	<c:forEach items="${categories}" var="cat">
		<tr>
			<td><c:out value="${cat.name}" /></td>
			<td>
				<form action="/SupCommerce/auth/removeCategory" method="post">
					<input type="hidden" name="id" value="${cat.id}" />
					<button class="btn btn-danger glyphicon glyphicon-trash" aria-hidden="true"></button>
				</form>
			</td>
		</tr>
		
	</c:forEach>
</table>

<%@include file="../footer.jsp"%>
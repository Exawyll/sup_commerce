<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.imie.supcommerce.entity.Category"
	import="fr.imie.supcommerce.dao.CategoryDao"%>
<%@include file="header.jsp"%>

<table class="table">
	<thead>
		<tr>
			<th>Name</th>
		</tr>
	</thead>
	<c:forEach items="${categories}" var="cat">
		<tr>
			<td><c:out value="${cat.name}" /></td>
		</tr>
	</c:forEach>
</table>

<%@include file="footer.jsp"%>
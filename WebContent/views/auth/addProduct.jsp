<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.imie.supcommerce.entity.Category"%>
<%@include file="../header.jsp"%>

<h1>ADD A PRODUCT</h1>

<form action="/SupCommerce/auth/basicInsert" method="post">
	<div class="form-group">
		<label for="prodName">Name</label> 
		<input id="prodName" class="form-control" type="text" value="" name="name">
	</div>
	
	<div class="form-group">
		<label for="prodDesc">Description</label> 
		<textarea id="prodDesc" class="form-control" type="text" value="" name="description" row="2"></textarea>
	</div>
	
	<div class="form-group">
		<label for="prodPrice">Price</label> 
		<input id="prodPrice" class="form-control" type="number" value="" name="price">
	</div>
	
	<div class="form-group">
		<label for="prodCat">Category</label> 
		<select id="prodCat" class="form-control" name="category">
			<c:forEach var="item" items="${categories}">
				<option value="${item.id}">${item.name}</option>
			</c:forEach>
		</select>
	</div>
	
	<button type="submit" class="btn btn-default">Submit</button>
</form>

<%@include file="../footer.jsp"%>
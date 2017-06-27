<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.imie.supcommerce.entity.Product"
	import="fr.imie.supcommerce.dao.ProductDao"%>
<%@include file="../header.jsp"%>

<h1>
	<c:out value="${p.name}" />
</h1>

<img src="..." alt="..." class="img-thumbnail productPicture">

<div class="form-group">
	<h3>Description</h3>
	<textarea class="form-control">
		<c:out value="${p.description}" />
	</textarea>
</div>

<hr>

<div class="form-group">
	<h3>
		Price :
		<c:out value="${p.price}" />
		 &#8364
	</h3>
</div>

<hr>

<div class="form-group">
	<h3>Categorie</h3>
	<select id="prodCat" multiple class="form-control" name="category">
		<option value=""><c:out value="${p.category.name}" /></option>
	</select>
</div>

<button type="button" name="back" class="btn btn-default"
	onclick="history.back()">back</button>

<%@include file="../footer.jsp"%>
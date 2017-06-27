<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../header.jsp"%>

<h1>ADD A CATEGORY</h1>

<form action="/SupCommerce/auth/addCategory" method="post">
	<div class="form-group">
		<label for="catName">Name</label> 
		<input id="catName" class="form-control" type="text" value="" name="name">
	</div>
	<button type="submit" class="btn btn-default">Submit</button>
</form>

<%@include file="../footer.jsp"%>
<%@include file=".././header.jsp" %>

	<form action="/SupCommerce/auth/addProduct" method="post">
		Name:<br> <input type="text" value="" name="name"><br>
		Description:<br> <input type="text" value="" name="description"><br>
		Price:<br> <input type="number" value="" name="price"><br>
		<input type="submit" value="Submit">
	</form>
	
<%@include file=".././footer.jsp" %>
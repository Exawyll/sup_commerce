<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.imie.supcommerce.model.Product"
    import="fr.imie.supcommerce.dao.ProductDao"%>
<%@include file="header.jsp" %>
	
	<c:out value="${p.name}" />
	<c:out value="${p.description}" />
	<c:out value="${p.price}" />

<%@include file="footer.jsp" %>
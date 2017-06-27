<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My SupCommerce</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/css/main.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.0/angular-material.min.css">
</head>

<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><img style="height: 100%;"
				src="http://formation.softeam.fr/sites/default/files/java-jeelogo_0.png"
				title="Java JEE" alt="logo java jee" /></a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">

				<li
					class="<c:if test="${fn:contains(uri, 'listProduct')}">active</c:if>"><a
					href="/SupCommerce/listProduct">List of products</a></li>
				<li
					class="<c:if test="${fn:contains(uri, 'listCategory')}">active</c:if>"><a
					href="/SupCommerce/listCategory">List of categories</a></li>
				<%
					if (session.getAttribute("username") != null) {
				%>
				<li
					class="<c:if test="${fn:contains(uri, 'addProduct')}">active</c:if>"><a
					href="/SupCommerce/auth/basicInsert">Add Product</a></li>
				<li
					class="<c:if test="${fn:contains(uri, 'addCategory')}">active</c:if>"><a
					href="/SupCommerce/auth/addCategory">Add Category</a></li>
				
				<%
					}
				%>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
					if (session.getAttribute("username") == null) {
				%>
				<li><a href="/SupCommerce/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<%
					} else {
				%>
				<li><a href="/SupCommerce/logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<p>
					<a href="#">Link</a>
				</p>
				<p>
					<a href="#">Link</a>
				</p>
				<p>
					<a href="#">Link</a>
				</p>
			</div>
			<div class="col-sm-8 text-left">
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item List</title>
</head>
<body>
<%@ include file="menu.jsp"%>
<div class="container">
<h3 class="h1 text-center">Item List</h3>
<table class="table">
	<thead class="table-header bg-success">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
			<th>QTY</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ items }" var="item" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td><img src="./images/${item.photoPath }" name="${item.name }" width="100" height="100"/></td>
				<td>${item.price }</td>
				<td>${item.category.name }</td>
				<td>${item.qty }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>
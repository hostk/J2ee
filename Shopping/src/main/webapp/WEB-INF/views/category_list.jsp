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
<h3>Item List</h3>
<a href="newItem.htm">New Student</a>
<table>
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Price</th>
			<th>Category</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ items }" var="item" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td>${item.category.name }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>
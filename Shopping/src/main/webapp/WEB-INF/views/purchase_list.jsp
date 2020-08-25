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
<h3 class="h1 text-center">Purchase Item List</h3>
<table class="table text-center">
	<thead class="table-header bg-success">
		<tr>
			<th>No</th>
			<th>Item Name</th>
			<th>QTY</th>
			<th>Date</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ purchases }" var="pur" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td>${pur.item.name }</td>
				<td>${pur.qty }</td>
				<td>${pur.purchaseDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>
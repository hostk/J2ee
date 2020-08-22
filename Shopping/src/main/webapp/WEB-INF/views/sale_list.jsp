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
<h3>SaleItem List</h3>
<a href="new_sale.htm">New Sale</a>
<table>
	<thead>
		<tr>
			<th>No</th>
			<th>QTY</th>
			<th>Item Name</th>
			<th>Date</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ sales }" var="pur" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td>${pur.qty }</td>
				<td>${pur.item.name }</td>
				<td>${pur.saleDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>
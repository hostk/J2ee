<%@ include file="/WEB-INF/views/user_include.jsp"%>
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
<%@ include file="user_menu.jsp" %>
<div class="container">
				<ul id="mySearch" class="stype-none">
          		<c:forEach items="${ items }" var="item" varStatus="row">
          		<li>
          		<div class="row" id="list">
          		<div class="cols-lg-4 p-3">
				<img src="./images/${item.photoPath }" name="${item.name }" width="150"/>
				</div>
				<div class="cols-lg-4 p-3 ml-5">
				<p>Product Name: ${item.name }<br>
				Price : ${item.price }
				<br>Category Type : ${item.category.name }<br>
				<p>Product Amount : ${item.qty }</p>
				</div>
				</div>
				</li>
			</c:forEach>
			</ul>
</div>
</body>
</html>
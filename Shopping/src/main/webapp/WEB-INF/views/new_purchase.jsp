<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp"%>
<div class="container">
<h1 class="h1 text-center">Add New Purchase Item</h1>
<form:form class="form" action="new_purchase.htm" method="post" modelAttribute="purchases">
<form:select path="item.id" class="form-control">
	<c:forEach items="${items}" var="cl">
	<form:option value="${cl.id }">${cl.name }</form:option>
	</c:forEach>
</form:select><br>
<form:input path="qty" class="form-control" placeholder="Enter the purchase amount"/> <br>
<form:input path="purchaseDate" class="form-control" type="date"/> <br>
<input type="submit" value="Save" class="btn btn-success form-control"/>
</form:form>
</div>
</body>
</html>
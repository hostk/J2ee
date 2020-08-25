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
<h1 class="h1 text-center">Add New Sale</h1>
<form:form class="form" action="new_sale.htm" method="post" modelAttribute="sales">
<form:select class="form-control" path="item.id">
	<c:forEach items="${items}" var="cl">
	<form:option value="${cl.id }">${cl.name }</form:option>
	</c:forEach>
</form:select><br>
<form:input path="qty" class="form-control" placeholder="Enter the sale amount"/><br>
<form:input path="saleDate" placeholder="Select the date" type="date" class="form-control" /><br>
<input type="submit" value="Save" class="btn btn-success form-control"/>
</form:form>
</div>
</body>
</html>
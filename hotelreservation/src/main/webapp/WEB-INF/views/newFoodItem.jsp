<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Food Item add Page</title>
</head>
<body>
<h1>Add new Food Item</h1>
<form:form action="newFoodItem.htm" method="post" enctype="multipart/form-data" modelAttribute="foodList">
<label>Food Name</label>
<form:input path="name" /> <br>
<form:select path="category.id">
	<c:forEach items="${categoryList}" var="cl">
	<form:option value="${cl.id }">${cl.foodType }</form:option>
	</c:forEach>
</form:select><br>
<label>Price</label><form:input path="price" /><br>
<label>Image:</label><form:input type="file" path="file"/><br>
<input type="submit" value="Save" />
</form:form>
</body>
</html>
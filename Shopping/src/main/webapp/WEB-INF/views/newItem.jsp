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
<form:form action="newItem.htm" method="POST" enctype="multipart/form-data" modelAttribute="iList">
<label>Name</label>
<form:input path="name" /> <br>
<form:select path="category.id">
	<c:forEach items="${cList}" var="cl">
	<form:option value="${cl.id }">${cl.name }</form:option>
	</c:forEach>
</form:select><br>
<label>QTY : </label>
<form:input path="qty" /> <br>
<label>Price</label><form:input path="price" /><br>
<label>Image:</label><form:input type="file" path="file" /><br>
<input type="submit" value="Save" />
</form:form>
</body>
</html>
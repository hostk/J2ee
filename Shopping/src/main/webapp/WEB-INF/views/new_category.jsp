<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<h1 class="h1 text-center">Add New Category</h1>
<form:form class="form text-center" action="new_category.htm" method="post" modelAttribute="categoryList">
<label class="col-3 h4">Category Name</label>
<form:input path="name" class="col-4"/>
<input type="submit" value="Save" class="btn btn-success"/>
</form:form>
</div>
</body>
</html>
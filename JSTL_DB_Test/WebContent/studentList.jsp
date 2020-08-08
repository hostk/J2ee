<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>Student ID</td>
<td>Name</td>
<td>Roll No</td>
<td>Phone No</td>
</tr>
<c:forEach var="std" items="${stdList}" varStatus="row">
<tr>
<td>${row.count}</td>
<td>${std.name }</td>
<td>${std.rollNo }</td>
<td>${std.phoneNo }</td>
</c:forEach>
</table>
</body>
</html>
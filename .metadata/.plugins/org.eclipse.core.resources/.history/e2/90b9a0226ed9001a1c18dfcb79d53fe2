<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>StudentList</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">
	<h1>Student Lists</h1>
<table class="table table-light">
<tr scope="row">
<td scope="col">Student Id</td>
<td scope="col">Name</td>
<td scope="col">Roll No</td>
<td scope="col">Phone No</td>
<td scope="col">Grade</td>
</tr>
<c:forEach var="std" items="${studentList}">
<tr scope="row">
<td scope="col">${std.id}</td>
<td scope="col">${std.name }</td>
<td scope="col">${std.rollNo }</td>
<td scope="col">${std.phoneNo }</td>
<td scope="col">${std.gradeId}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.io.*,java.util.*,java.sql.*,javax.servlet.*" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body>
<%@ include file="menu.jsp"%>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost/StudentManagment" user="root" password="minkoko"/>
<sql:query dataSource="${db }" var="rs">
	SELECT b.bid as bookId,b.name as bookName,b.author as author,b.isbn as isbn,b.price as p,b.qty as q,c.name as cname FROM Book b left join category c on b.category_id=c.id;
</sql:query>
<div class="container">
<div class="table-responsive">
<table class="table table-dark">
<tr>
<th>Book Id</th>
<th>Book Name</th>
<th>Author</th>
<th>ISBN</th>
<th>Price</th>
<th>QTY</th>
<th>Book Type</th>
</tr>
<c:forEach var="table" items="${rs.rows }">
<tr>
<td>${table.bid}</td>
<td>${table.name }</td>
<td>${table.author }</td>
<td>${table.isbn }</td>
<td>${table.price }</td>
<td>${table.qty }</td>
<td>${table.name }</td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>
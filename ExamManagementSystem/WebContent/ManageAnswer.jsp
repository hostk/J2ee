<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="ems.*" %>
    <%@ page import="java.io.*,java.util.*,java.sql.*" %>
             <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
             <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Answer Manage JSP Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="menu.jsp" %>		
<div class="container">
<form action="manageAnswer" method="post" class="form">
<h1 class="h2 text-primary">Add New Answer</h1>
<div class="form-group" id="list">
<label>Answer</label>
<input type="text" name="answer" id="aa" class="form-control">
<!-- 
<input type="button" name="addAnswer" class="btn btn-success" id="add">
<script>
	$(document).ready(function(){
		$("#add").click(function(){
			var n= $('aa').text();
			$("#list").append("<input type='checkbox' value='"+n+'>");
		});
	});
</script> -->
</div>
<div class="form-group">
<label>Status</label>
<input type="text" name="status" class="form-control">
</div>
<div class="form-group">
	<label> Question Id</label>
	<input type="text" class="form-control" name="qid">
</div>
<input type="submit" value="Add" class="btn btn-success btn-block mt-3">
</form>
<div class="table-responsive mt-3">
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/ExamManagementSystem"  
     user="root"  password="minkoko"/>  
     <sql:query dataSource="${db}" var="rs">  
	select s.id,s.name,s.status,e.name from answer s left join question e on s.question_id=e.qid;  
</sql:query> 
<table class="table table-dark">
<tr>
<th>Answer ID</th>
<th>Name</th>
<th>Status</th>
<th>Question ID</th>
</tr>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td>${table.id }</td>
<td>${table.name }</td>
<td>${table.status }</td>
<td>${table.questionId }</td>
<td><button class="delete" id="${table.id }">DELETE</button></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>
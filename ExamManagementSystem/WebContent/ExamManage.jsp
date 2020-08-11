<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="ems.*" %>
    <%@ page import="java.io.*,java.util.*,java.sql.*" %>
             <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exam Manage JSP Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%@ include file="menu.jsp" %>
<%
	

	try{
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/ExamManagementSystem","root","minkoko");
				String sql ="select * from exam";
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				
				List<Exam> examList=new ArrayList<Exam>();
				
				while(rs.next()){
					Exam ex = new Exam(rs.getInt(1),rs.getString(2),rs.getInt(3));
					examList.add(ex);
				}
				con.close();
				request.setAttribute("ExamList", examList);
			}catch(SQLException e){
				e.printStackTrace();
			}
	}catch(Exception e){
		e.printStackTrace();
	}
%>				
<div class="container">
<form action="manageExam" method="post" class="form">
<h1 class="h2 text-primary">Add New Exam</h1>
<div class="form-group">
<label>Name</label> 
<input type="text" name="name" class="form-control">
</div>
<div class="form-group">
<label>Total Mark</label> 
<input type="text" name="totalmark" class="form-control">
</div>
<input type="submit" value="Add" class="btn btn-success btn-block">
</form>

<div class="table-responsive mt-3">
<table class="table table-dark">
<tr>
<th>Exam ID</th>
<th>Exam Name</th>
<th>Total Mark</th>
</tr>
<c:forEach var="exams" items="${ExamList }">
<tr>
<td>${exams.id }</td>
<td>${exams.name }</td>
<td>${exams.totalMark }</td>
<td><button class="delete" id="${exams.id }">DELETE</button></td>
</tr>
</c:forEach>
</table>
</div>
<script>
	$(document).ready(function(){
		$(".delete").click(function(){
			var id = +this.id;
			
			$.ajax({
				url:"delete-ajaxAction.jsp",
				type:"post",
				data:{
					id:id,
				},
				success: function(data){
					alert(data);
					location.reload();
				}
			});
		});
	});
</script>
</div>
</body>
</html>
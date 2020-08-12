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
<title>Question Manage JSP Page</title>
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
				
				String question ="select * from question";
				Statement qq = con.createStatement();
				ResultSet rr = qq.executeQuery(question);
				
				List<Question> questList = new ArrayList<Question>();
				
				while(rr.next()){
					Question quest = new Question(rr.getInt(1),rr.getString(2),rr.getInt(3),rr.getInt(4));
					questList.add(quest);
				}
				
				con.close();
				request.setAttribute("questList",questList);
				request.setAttribute("ExamList", examList);
			}catch(SQLException e){
				e.printStackTrace();
			}
	}catch(Exception e){
		e.printStackTrace();
	}
%>				
<div class="container">
<form action="manageQuestion" method="post" class="form">
<h1 class="h2 text-primary">Add New Question</h1>
<div class="form-group">
<label>Name</label> 
<input type="text" name="name" class="form-control">
</div>
<div class="form-group">
<label>Mark</label> 
<input type="text" name="mark" class="form-control">
</div>

<select name="elist" class="form-control">
<c:forEach var="exams" items="${ExamList}">
<option value="${exams.id }">${exams.name}</option>
</c:forEach>
</select>
<input type="submit" value="Add" class="btn btn-success btn-block mt-3">
</form>

<div class="table-responsive mt-3">
<table class="table table-dark">
<tr>
<th>Question ID</th>
<th>Question Name</th>
<th>Mark</th>
<th>Exam Name</th>
</tr>
<c:forEach var="qq" items="${questList }">
<tr>
<td>${qq.id }</td>
<td>${qq.name }</td>
<td>${qq.mark }</td>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/ExamManagementSystem"  
     user="root"  password="minkoko"/>  
     <sql:query dataSource="${db}" var="rs">  
	SELECT name from exam where eid=${qq.examId};  
</sql:query> 
<c:forEach var="table" items="${rs.rows }">
<td>${table.name }</td>
</c:forEach>
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
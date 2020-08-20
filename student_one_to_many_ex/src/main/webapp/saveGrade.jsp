 <%@ page isELIgnored="false" %>
<%@ page import="com.minko.otm.model.*" %>
    <%@ page import="java.io.*,java.util.*,java.sql.*" %>
             <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
             <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<html>
<head>
	<title>Insert Student</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/customer_dd"  
     user="root"  password="minkoko"/>  
     <sql:query dataSource="${db}" var="rs">  
		select * from Grade;
</sql:query> 
<div class="container">
<form action="SaveGradeByYear" method="post" class="form">
              
	<label>Grade Name</label><input type="text" name="stdName" class="form-control" placeholder="Enter the stdudent' Name" >
	
	<select name="grade" class="form-control">
	<c:forEach var="grade" items="${rs.rows}">
		<option value="${grade.id }">${grade.name }</option>
	</c:forEach>
	</select>
	<input type="submit" value="save" class="btn btn-primary btn-block">
</form>
</div> 
</body>
</html>

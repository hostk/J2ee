 <%@ page isELIgnored="false" %>
<%@ page import="com.minko.otm.model.*" %>
    <%@ page import="java.io.*,java.util.*,java.sql.*" %>
             <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
             <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  <html>
<head>
	<title>Insert Student</title>
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"  
     url="jdbc:mysql://localhost/customer_dd"  
     user="root"  password="minkoko"/>  
     <sql:query dataSource="${db}" var="rs">  
		select * from Grade;
</sql:query>
<sql:query dataSource="${db}" var="rss">  
		select * from Section;
</sql:query> 
<div class="container">
<c:if test="${student != null}">
<form action="update" method="post" class="form">
 </c:if>
        <c:if test="${student == null}">
<form action="save" method="post" class="form">
</c:if>
<h2>
              <c:if test="${student != null}">
               Edit User
              </c:if>
              <c:if test="${student == null}">
               Add New User
              </c:if>
             </h2>
             <c:if test="${student != null}">
           <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
          </c:if>  
	<label>Name</label><input type="text" name="stdName" class="form-control" placeholder="Enter the stdudent' Name" value="<c:out value='${student.name}'/>">
	<br/>
	<label>Roll No</label><input type="text" name="rollno" class="form-control" placeholder="Enter the stdudent' Roll No" value="<c:out value='${student.rollno}' />">
	<br/>
<select name="sect" class="form-control">
	<c:forEach var="section" items="${rss.rows}">
		<option value="${section.id}">${section.name }</option>
	</c:forEach>
	
	</select>
	<br/>
	<select name="grad" class="form-control">
	<c:forEach var="grade" items="${rs.rows}">
		<option value="${grade.id }">${grade.name }</option>
	</c:forEach>
	</select>	
	<br/>
	<input type="submit" value="save" class="btn btn-primary btn-block">
</form>
</div> 
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<form action="saveStudent.jsp">
Name : <input type="text" name="name"><br>
Roll No : <input type="text" name="rollno"><br>
Phone No : <input type="text" name="phoneno"><br>
<input type="submit" value="Add Student">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="library.*" %>
    <%@ page import="java.io.*,java.util.*,java.sql.*" %>
             <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<%
try{

	try{Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagment","root","minkoko");
	
	System.out.print("Connection is successful!");
	
	String sql ="select * from grade";
	
	Statement stm = con.createStatement();
	ResultSet rs=stm.executeQuery(sql);
	List<Grade> gradeList = new ArrayList<Grade>();
	while(rs.next()){
		Grade grade= new Grade(rs.getInt("id"),rs.getString("name"));
		gradeList.add(grade);
		}
	con.close();
	request.setAttribute("gradeList",gradeList);
	//RequestDispatcher rd = request.getRequestDispatcher("insertStudent.jsp");
	//rd.forward(request,response);
	}catch (SQLException e){
		e.printStackTrace();
	}
}catch(Exception e){
	e.printStackTrace();
}
	%>
<form action="saveStudent.jsp">
<h1>Add New Student</h1>
Name : <input type="text" name="name"><br>
Roll No : <input type="text" name="rollno"><br>
Phone No : <input type="text" name="phoneno"><br>
<select name="grade">
<c:forEach var="gd" items="${gradeList}">
<option value="${gd.id}">${gd.name}</option>
</c:forEach>
</select><br>
<input type="submit" value="Add">
</form>
</body>
</html>
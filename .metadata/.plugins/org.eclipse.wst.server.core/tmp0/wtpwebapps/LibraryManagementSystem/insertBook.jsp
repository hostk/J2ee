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
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<%
try{

	try{Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagment","root","minkoko");
	
	System.out.print("Connection is successful!");
	
	String sql ="select * from category";
	
	Statement stm = con.createStatement();
	ResultSet rs=stm.executeQuery(sql);
	List<Category> catList = new ArrayList<Category>();
	while(rs.next()){
		Category cat= new Category(rs.getInt("id"),rs.getString("name"));
		catList.add(cat);
		}
	con.close();
	request.setAttribute("catList",catList);
	//RequestDispatcher rd = request.getRequestDispatcher("insertBook.jsp");
	//rd.forward(request,response);
	}catch (SQLException e){
		e.printStackTrace();
	}
}catch(Exception e){
	e.printStackTrace();
}
	%>
<form action="saveBook.jsp">
Book : <input type="text" name="bname"><br>
Author : <input type="text" name="author"><br>
ISBN : <input type="text" name="isbn"><br>
Price : <input type="text" name="price"><br>
QTY : <input type="text" name="qty"><br>
<select name="category">
<c:forEach var="cat" items="${catList}">
<option value="${cat.catId }">${cat.name}</option>
</c:forEach> 
</select><br>
<input type="submit" value="Add Book">
</form>

</body>
</html>
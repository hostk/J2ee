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
<%@ include file="menu.jsp" %>
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
<div class="container">	
<form action="insertBook.jsp" class="form">
<div class="form-group">
<label>Book</label> <input type="text" name="bname" class="form-control"><br>
</div>
<div class="form-group">

</div>
<label>Author</label> <input type="text" name="author" class="form-control"><br>
<div class="form-group">
ISBN : <input type="text" name="isbn" class="form-control"><br>

</div>
<div class="form-group">
Price : <input type="text" name="price" class="form-control"><br>

</div>
<div class="form-group">
QTY: <input type="text" name="qty" class="form-control"><br>

</div>
<select name="category">
<c:forEach var="cat" items="${catList}">
<option value="${cat.catId }">${cat.name}</option>
</c:forEach> 
</select><br>
<input type="submit" value="Add Book">
</form>
</div>
<%
try{
	String name = request.getParameter("bname");
	String author = request.getParameter("author");
	String isbn = request.getParameter("isbn");
	double price = Double.parseDouble(request.getParameter("price"));
	int qty = Integer.parseInt(request.getParameter("qty"));
	int category = Integer.parseInt(request.getParameter("category"));
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagment","root","minkoko");
	
	System.out.print("Connection is successful!");
	
	
	String sql ="insert into Book(bid,name,author,isbn,price,qty,category_id) values(null,?,?,?,?,?,?)";
	
	
	
	try{
		if(name!="" && price!=0){
			Statement stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,author);
			ps.setString(3,isbn);
			ps.setDouble(4, price);
			ps.setInt(5,qty);
			ps.setInt(6,category);
			int status = ps.executeUpdate();
			if(status>0){
				System.out.println("Insert is successful!");
			}
			
			//String destination ="bookList.jsp";
			
			//RequestDispatcher rd = request.getRequestDispatcher(destination);
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("select * from Book");
			
			List<Book> bookList = new ArrayList<Book>();
			
			while(rs.next()){
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getInt(7));
				bookList.add(book);
			}
			con.close();
			request.setAttribute("bookList",bookList);
			//rd.forward(request,response);
		}
		}catch (SQLException e){
		e.printStackTrace();
		}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<div class="table-responsive">
<table class="table table-bordered">
<tr>
<td>#</td>
<td>Name</td>
<td>Author</td>
<td>ISBN</td>
<td>Price</td>
<td>QTY</td>
<td>category_id</td>
</tr>
<c:forEach var="book" items="${bookList}" varStatus="row">
<tr>
<td>${row.count }</td>
<td>${book.bname }</td>
<td>${book.author }</td>
<td>${book.isbn }</td>
<td>${book.price }</td>
<td>${book.qty }</td>
<td>${book.cat }</td>
</c:forEach>
</table>
</div>
</div>
</body>
</html>
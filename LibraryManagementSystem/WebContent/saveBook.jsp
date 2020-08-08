<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="library.*" %>
    <%@ page import="java.io.*,java.util.*,java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
			
			String destination ="bookList.jsp";
			
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("select * from Book");
			
			List<Book> bookList = new ArrayList<Book>();
			
			while(rs.next()){
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getInt(7));
				bookList.add(book);
			}
			con.close();
			request.setAttribute("bookList",bookList);
			rd.forward(request,response);
		}
		}catch (SQLException e){
		e.printStackTrace();
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
%>
</body>
</html>
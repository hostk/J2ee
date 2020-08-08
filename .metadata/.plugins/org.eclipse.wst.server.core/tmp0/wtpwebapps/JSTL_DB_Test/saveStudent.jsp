<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="student.*" %>
    <%@ page import="java.sql.*,java.util.*,java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
try{
	String name = request.getParameter("name");
	String rollNo = request.getParameter("rollno");
	String phoneNo = request.getParameter("phoneno");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagment","root","minkoko");
	
	System.out.print("Connection is successful!");
	
	String sql ="insert into student(id,name,rollNo,phoneNo) values(null,?,?,?)";
	try{
		if(name!="" && rollNo!="" && phoneNo!=""){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,rollNo);
			ps.setString(3,phoneNo);
			int status = ps.executeUpdate();
			if(status>0){
				System.out.println("Insert is successful!");
			}
			
			String destination ="studentList.jsp";
			
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("select * from student");
			
			List<Student> stdList = new ArrayList<Student>();
			
			while(rs.next()){
				Student std = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				stdList.add(std);
			}
			con.close();
			request.setAttribute("stdList",stdList);
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
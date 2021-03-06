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
	String name = request.getParameter("name");
	String roll = request.getParameter("rollno");
	String phone = request.getParameter("phoneno");
	int grade = Integer.parseInt(request.getParameter("grade"));
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagment","root","minkoko");
	
	System.out.print("Connection is successful!");
	
	
	String sql ="insert into student(id,name,rollno,phoneno,gid) values(null,?,?,?,?)";
	
	
	
	try{
		if(name!="" && grade!=0){
			Statement stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,roll);
			ps.setString(3,phone);
			ps.setDouble(4, grade);
			int status = ps.executeUpdate();
			if(status>0){
				System.out.println("Insert is successful!");
			}
			
			String destination ="studentList.jsp";
			
			RequestDispatcher rd = request.getRequestDispatcher(destination);
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("select * from student");
			
			List<Student> studentList = new ArrayList<Student>();
			
			while(rs.next()){
				Student std = new Student(rs.getInt("id"),rs.getString("name"),rs.getString("rollno"),rs.getString("phoneno"),rs.getInt("gid"));
				studentList.add(std);
			}
			con.close();
			request.setAttribute("studentList",studentList);
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
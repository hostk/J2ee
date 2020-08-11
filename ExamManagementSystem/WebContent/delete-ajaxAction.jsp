<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>

<%
	int id = Integer.parseInt(request.getParameter("id"));
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/ExamManagementSystem","root","minkoko");
		
		Statement stm = con.createStatement();
		int i=stm.executeUpdate("delete form student where id="+id);
		out.println("Delete successful");
		
	}catch(Exception e){
		System.out.println(e);
		e.printStackTrace();
	}
%>
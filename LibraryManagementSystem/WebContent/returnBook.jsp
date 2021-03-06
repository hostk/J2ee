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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

  <script src="https://code.jquery.com/jquery-1.12.4.js (https://code.jquery.com/jquery-1.12.4.js)"></script>

  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js (https://code.jquery.com/ui/1.12.1/jquery-ui.js)"></script>

  <script>

  $( function() {

    $( "#returnDatePicker" ).datepicker();

  } );

  </script>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
<h1 class="h1 text-light bg-dark mt-4 p-2">Book Return</h1>
<form action="returnBook.jsp">
<div class="form-group">
<label for="bookId">Book Id</label>
<input type="text" class="form-control" name="bookId" placeholder="Enter the book Id"/>
</div>
<div class="form-group">
<label for="studentId">Student Id</label>
<input type="text" class="form-control" name="studentId" placeholder="Enter the student Id"/>
</div>
<div class="form-group">
<label for="returnDate">Date</label>
<input type="date" id="returnDatePicker" name="returnDate" class="form-control"/>
</div>
<div class="text-right">
<input type="submit" value="Return" class="btn btn-primary">
</div>
</form>
<%
	try{
		int student_Id=Integer.parseInt(request.getParameter("studentId"));
		int book_Id=Integer.parseInt(request.getParameter("bookId"));
		String returnDateString = request.getParameter("returnDate");
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		//Date returnDate = sdf.parse();
        //Date date = new Date();
       try{
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagment","root","minkoko");
			String update ="update Book set qty=qty+1 where bid='"+book_Id+"'";
        	String sql = "insert into RentReturn(id,student_Id,book_Id,rent_Date,return_Date,book_Rent,book_Return) values(null,?,?,?,?,?,?)"; 
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,student_Id);
			ps.setInt(2,book_Id);
			ps.setString(3,"null");
			ps.setString(4,returnDateString);
			ps.setString(5,"0");
			ps.setString(6, "1");
			int status = ps.executeUpdate();
			
			if(status>0){
				
				Statement updateStm = con.createStatement();
				updateStm.execute(update);
				System.out.println("Insert is successful!");

			}
			
			//String destination ="ReturnList.jsp";
			
			//RequestDispatcher rd = request.getRequestDispatcher(destination);
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("select * from RentReturn where book_Return='1'");
			
			List<RentReturn> RRList = new ArrayList<RentReturn>();
			
			while(rs.next()){
				RentReturn rr = new RentReturn(rs.getInt("student_Id"),rs.getInt("book_Id"),rs.getString("rent_Date"),rs.getString("return_Date"),rs.getString("book_Rent"),rs.getString("book_Return"));
				RRList.add(rr);
			}
			con.close();
			request.setAttribute("RentReturnList",RRList);
			//rd.forward(request,response);
			
       // System.out.println(sql);
        
       }catch(SQLException e){
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
<td>StudentID</td>
<td>BookID</td>
<td>rentDate</td>
<td>returnDate</td>
<td>book_Rent</td>
<td>book_Return</td>
</tr>
<c:forEach var="rr" items="${RentReturnList}" varStatus="row">
<tr>
<td>${row.count }</td>
<td>${rr.studentId }</td>
<td>${rr.bookId }</td>
<td>${rr.rentDate}</td>
<td>${rr.retrunDate }</td>
<td>${rr.bookRent }</td>
<td>${rr.bookReturn }</td>
</c:forEach>
</table>
</div>
</div>
</body>
</html>
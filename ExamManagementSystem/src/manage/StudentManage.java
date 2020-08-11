package manage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ems.*;
import java.io.*;
import java.sql.*;
import java.util.*;
/**
 * Servlet implementation class StudentManage
 */
@WebServlet("/StudentManage")
public class StudentManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String name = request.getParameter("name");
			String roll = request.getParameter("rollNo");
			String nrc = request.getParameter("nrc");
			String phone = request.getParameter("phone");
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost/ExamManagementSystem","root","minkoko");
					String insert="insert into student(sid,name,rollNo,nrc,phone) values(null,?,?,?,?)";
					
					if(name !="" && roll !="" && nrc !=""){
						PreparedStatement ps = con.prepareStatement(insert);
						ps.setString(1, name);
						ps.setString(2,roll);
						ps.setString(3,nrc);
						ps.setString(4,phone);
						int status = ps.executeUpdate();
						if(status>0){
							System.out.print("Insert successful");
						}
						String sql ="select * from student";
						Statement stm=con.createStatement();
						ResultSet rs=stm.executeQuery(sql);
						
						List<Student> stdList=new ArrayList<Student>();
						
						while(rs.next()){
							Student std = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
							stdList.add(std);
						}
						con.close();
						request.setAttribute("StudentList", stdList);
						RequestDispatcher rd = request.getRequestDispatcher("StudentManage.jsp");
						rd.forward(request, response);
					
				}
				
			}catch (SQLException e){
				e.printStackTrace();
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}

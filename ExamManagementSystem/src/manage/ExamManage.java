package manage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.*;
import ems.*;
/**
 * Servlet implementation class ExamManage
 */
@WebServlet("/ExamManage")
public class ExamManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String name = request.getParameter("name");
			int tmark = Integer.parseInt(request.getParameter("totalmark"));
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost/ExamManagementSystem","root","minkoko");
					String insert="insert into exam(eid,name,total_mark) values(null,?,?)";
					
					if(name !="" && tmark!=0){
						PreparedStatement ps = con.prepareStatement(insert);
						ps.setString(1, name);
						ps.setInt(2,tmark);
						int status = ps.executeUpdate();
						if(status>0){
							System.out.print("Insert successful");
						}
						String sql ="select * from exam";
						Statement stm=con.createStatement();
						ResultSet rs=stm.executeQuery(sql);
						
						List<Exam> examList=new ArrayList<Exam>();
						
						while(rs.next()){
							Exam ex = new Exam(rs.getInt(1),rs.getString(2),rs.getInt(3));
							examList.add(ex);
						}
						con.close();
						request.setAttribute("ExamList", examList);
						RequestDispatcher rd = request.getRequestDispatcher("ExamManage.jsp");
						rd.forward(request, response);
				}
				
			}catch (SQLException e){
				e.printStackTrace();
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}	}

}

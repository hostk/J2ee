package manage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ems.Exam;

/**
 * Servlet implementation class QuestionManage
 */
@WebServlet("/QuestionManage")
public class QuestionManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String name = request.getParameter("name");
			int mark = Integer.parseInt(request.getParameter("mark"));
			int eid = Integer.parseInt(request.getParameter("elist"));
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost/ExamManagementSystem","root","minkoko");
					String insert="insert into question(qid,name,mark,exam_id) values(null,?,?,?)";
					
					if(name !="" && mark!=0){
						PreparedStatement ps = con.prepareStatement(insert);
						ps.setString(1, name);
						ps.setInt(2,mark);
						ps.setInt(3, eid);
						int status = ps.executeUpdate();
						if(status>0){
							System.out.print("Insert successful");
						}
						String sql ="select * from question";
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
		}		}

}

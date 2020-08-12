package manage;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ems.*;
/**
 * Servlet implementation class ManageAnswer
 */
@WebServlet("/ManageAnswer")
public class ManageAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String answer = request.getParameter("answer");
			Boolean status = Boolean.parseBoolean(request.getParameter("status"));
			int qid = Integer.parseInt(request.getParameter("qid"));
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost/ExamManagementSystem","root","minkoko");
				ResultSet rs = null;
			String asql = "insert into answer(id,name,status,question_id) values(null,?,?,?)";
			if(answer !="") {
			PreparedStatement pp = con.prepareStatement(asql);
			pp.setString(1, answer);
			pp.setBoolean(2, status);		
			pp.setInt(3, qid);
			int st = pp.executeUpdate();
			if(st>0) {
				System.out.println("Answer insert is successful");
			}
			
			Statement stm = con.createStatement();
			rs = stm.executeQuery("select * from answer");
			List<Answer> ansList = new ArrayList<Answer>();
			
			while(rs.next()) {
				Answer ans= new Answer(rs.getInt(1),rs.getString(2),rs.getBoolean(3),rs.getInt(4));
				ansList.add(ans);
			}
			con.close();
			RequestDispatcher rd = request.getRequestDispatcher("ManageAnswer.jsp");
			rd.forward(request, response);
			
			
		}

		
	
}catch (SQLException e){
	e.printStackTrace();
}

}catch (Exception e){
e.printStackTrace();
}		}

}

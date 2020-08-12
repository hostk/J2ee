package manage;

import java.sql.*;
import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ems.*;
/**
 * Servlet implementation class DAO
 */
@WebServlet("/DAO")
public class DAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("input"));

		ExamManager em = new ExamManager();
		
		em.getQuestionWithAnswerByExam(id);
		
		request.setAttribute("list", em.getQuestionWithAnswerByExam(id));
		System.out.println(em.getQuestionWithAnswerByExam(id));
		RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
		rd.forward(request, response);
		
		
	}

}

package com.minko.otm.services;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.minko.otm.dao.StudentDao;
import com.minko.otm.model.Grade;
import com.minko.otm.model.Section;
import com.minko.otm.model.Student;

@SuppressWarnings("serial")
@WebServlet("/")
public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDao studentDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	@Override
	public void init() throws ServletException {
		 this.studentDao=new StudentDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  action = request.getServletPath();
		try {
		switch(action) {
		case "/save":
			addStudentForm(request,response);
			break;
		case "/new":
			showStudentForm(request,response);
			break;
		case "/edit":
			showEditForm(request,response);
			break;
		case "/update":
			updateStudent(request,response);
			break;
		case "/delete":
			deleteStudent(request,response);
			break;
		default:
			listStudent(request,response);
			break;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String roll = request.getParameter("rollno");
		String section = request.getParameter("section");
		
		String year = request.getParameter("year");
		Section sect=studentDao.getSect(section);
		Grade grade = studentDao.getGrad(year);
		Student student = new Student(name,roll);
		student.setSection(sect);
		student.setGrade(grade);
		studentDao.updateStudent(student);
		response.sendRedirect("studentList");
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList = studentDao.getAllStudent();
		request.setAttribute("studentList", studentList);
		RequestDispatcher rd = request.getRequestDispatcher("student_list.jsp");
		rd.forward(request, response);
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDao.deleteStudent(id);
		response.sendRedirect("studentList");		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student student = studentDao.getStudent(id);
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("student_form.jsp");
		rd.forward(request,response);		
	}

	private void showStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("student_form.jsp");
		rd.forward(request, response);		
	}

	private void addStudentForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("stdName");
		String roll = request.getParameter("rollno");
		String section = request.getParameter("sect");
		
		String year = request.getParameter("grad");
		Section sect=studentDao.getSect(section);
		Grade grade =studentDao.getGrad(year);
		Student student = new Student(name,roll);
		student.setSection(sect);
		student.setGrade(grade);
		studentDao.SaveStudent(student);
		response.sendRedirect("studentList");		
	}

}

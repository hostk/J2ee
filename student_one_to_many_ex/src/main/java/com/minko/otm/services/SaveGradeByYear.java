package com.minko.otm.services;

import java.io.IOException;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.minko.otm.model.Grade;
import com.minko.otm.model.Section;
import com.minko.otm.utl.HibernateUtil;

/**
 * Servlet implementation class SaveGradeByYear
 */
public class SaveGradeByYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveGradeByYear() {
        super();
        // TODO Auto-generated constructor stub
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
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		Transaction tx= null;
		try(Session session=HibernateUtil.sessionFactory().openSession()){
			tx=session.beginTransaction();
			Section section = new Section();
			section.setGrade(getGrade(grade));
			session.save(section);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
		}
	}
	public Grade getGrade(String name) {
		
		Grade grade = null;
		try(Session session=HibernateUtil.sessionFactory().openSession()){
			Criteria cr = session.createCriteria(Grade.class);
			cr.add(Restrictions.eq("name", name));
			grade = (Grade) cr.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grade;
	}

}

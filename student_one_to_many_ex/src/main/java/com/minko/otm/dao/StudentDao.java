package com.minko.otm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.minko.otm.model.Grade;
import com.minko.otm.model.Section;
import com.minko.otm.model.Student;
import com.minko.otm.utl.HibernateUtil;

public class StudentDao {
	
	public void SaveStudent(Student student) {
		Transaction tx = null;
		try(Session session = HibernateUtil.sessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		
	}
	public Grade getGrad(String name) {
		Grade grade = null;
		try(Session session = HibernateUtil.sessionFactory().openSession()) {
			Criteria cr = session.createCriteria(Grade.class);
			cr.add(Restrictions.eq("name", name));
			Grade grad =  (Grade) cr.uniqueResult();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return grade;
		
	}
	public Section getSect(String name) {
		Section section = null;
		try(Session session = HibernateUtil.sessionFactory().openSession()) {
			Criteria cr = session.createCriteria(Section.class);
			cr.add(Restrictions.eq("name", name));
			section = (Section)cr.uniqueResult();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return section;
		
	}
	public void updateStudent(Student student) {
		Transaction tx = null;
		try(Session session = HibernateUtil.sessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.update(student);
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	public void deleteStudent(int student_id) {
		Transaction tx = null;
		try(Session session = HibernateUtil.sessionFactory().openSession()) {
			tx = session.beginTransaction();
			Student student = session.get(Student.class,student_id);
			if(student!=null) {
				session.delete(student);
				System.out.println("Student deleted");
			}
			tx.commit();
			
		}catch(Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	public Student getStudent(int student_id) {
		Student student = null;
		try(Session session = HibernateUtil.sessionFactory().openSession()) {
			Criteria cr = session.createCriteria(Student.class);
			cr.add(Restrictions.eq("id", student_id));
			student = (Student) cr.list();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return student;
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Student> getAllStudent(){
		List<Student> studentList = null;
		try(Session session = HibernateUtil.sessionFactory().openSession()) {
			Criteria cr = session.createCriteria(Student.class);
			studentList = cr.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return studentList;
		
	}
}

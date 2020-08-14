package hibernate_jsp_example.usermanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate_jsp_example.usermanagement.model.User;
import hibernate_jsp_example.usermanagement.utl.HibernateUtl;

public class UserDao {
	public void saveUser(User user) {
		Transaction tx =null;
		try(Session session= HibernateUtl.sessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	public void updateUser(User user) {
			Transaction tx =null;
			try(Session session= HibernateUtl.sessionFactory().openSession()) {
				tx = session.beginTransaction();
				session.update(user);
				tx.commit();
			}catch(Exception e) {
				if(tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
	}
	public void deleteUser(int id) {
		Transaction tx =null;
		try(Session session= HibernateUtl.sessionFactory().openSession()) {
			tx = session.beginTransaction();
			User user = session.get(User.class,id);
			if(user != null) {
				session.delete(user);
				System.out.println("User is deleted");
			}
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	public User getUser(int id) {
		Transaction tx =null;
		User user = null;
		try(Session session= HibernateUtl.sessionFactory().openSession()) {
			tx = session.beginTransaction();
			 user = session.get(User.class,id);
				System.out.println("User is deleted");
			
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return user;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser(){
		Transaction tx =null;
		List<User> listOfUser = null;
		try(Session session= HibernateUtl.sessionFactory().openSession()) {
			tx = session.beginTransaction();
			listOfUser = session.createQuery("from User").getResultList();
			System.out.println("Userlist get");
			
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
		
	}
}

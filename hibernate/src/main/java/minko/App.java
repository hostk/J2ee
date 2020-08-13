package minko;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jboss.jandex.ThrowsTypeTarget;
import minko.Employee;
public class App implements Serializable{
	public static SessionFactory factory;
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable th) {
			System.err.print("Failed to create Session  Factory"+th);
			throw new ExceptionInInitializerError(th);
		}
		App app = new App();
		
		Integer emp1 = app.addEmployee("Min","Ko",22200.0);
		Integer emp2= app.addEmployee("Ko","Ko",200.0);
		Integer emp3 = app.addEmployee("Min","Min",222.0);

		app.listEmployee();
		
		//app.updateEmployee(emp1,2000);
		
		//app.deleteEmployee(emp2);
		
		//app.listEmployee();
	}

	/*
	 * private void deleteEmployee(Integer emp2) { // TODO Auto-generated method
	 * stub
	 * 
	 * } private void updateEmployee(Integer emp1, int i) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */
	private void listEmployee() {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
		List employees = session.createQuery("FROM Employee").list();
		for(Iterator iterator= employees.iterator();iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("First Name: "+employee.getFirstName());
			System.out.println("Last Name : "+ employee.getLastName());
			System.out.println("Salary : "+employee.getSalary());
		}
		tx.commit();
		}catch(HibernateException he) {
			if(tx!=null) tx.rollback();
			he.printStackTrace();
		}finally {
			session.close();
		}
	}
	private Integer addEmployee(String fname, String lname, double salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		
		try {
			tx = session.beginTransaction();
	         Employee employee = new Employee(fname, lname, salary);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
		}catch(HibernateException he) {
			if(tx != null) tx.rollback();
			he.printStackTrace();
		}finally {
			session.close();
		}
		return employeeID;
	}
	

}

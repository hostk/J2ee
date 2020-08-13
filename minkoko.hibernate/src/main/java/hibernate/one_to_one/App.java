package hibernate.one_to_one;

import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernate.one_to_one.model.Employee;
import hibernate.one_to_one.model.Phone;

public class App {
	static Session sessionObj;
	static SessionFactory sessionFactoryObj;
	
	public static SessionFactory getSessionFactory() {
		
		try {
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactoryObj=metadata.getSessionFactoryBuilder().build();

		}catch(Throwable th) {
			System.err.println("Initialize session factory failed"+th);
			throw new ExceptionInInitializerError(th);
			}
		return sessionFactoryObj;
		
	}
	public static void main(String[] args) {
		createEmployee();
	}
	private static void createEmployee() {

		System.out.println("***********Creating Employee*******");
		Employee emp = new Employee("Min Ko Ko",25);
		Phone phone=new Phone();
		phone.setNo("09977264873");
		phone.setEmployee(emp);
		emp.setPhone(phone);
		
		Session session = getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
		System.out.print("Employee created successfully"+emp.toString());
	}
	
}

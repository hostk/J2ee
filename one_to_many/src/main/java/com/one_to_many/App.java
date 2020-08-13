package com.one_to_many;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.HibernateUtilities;

public class App {
	static Session session;
	static SessionFactory sessionFactoryObj;
	public static SessionFactory factory() {
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(registry).getMetadataBuilder().build();
			sessionFactoryObj = metaData.getSessionFactoryBuilder().build();
			
		}catch(Throwable th) {
			System.err.println("Failed SessionFactory creating "+th);
			throw new ExceptionInInitializerError(th);
		}
		
		return sessionFactoryObj;
		
	}
	
	public static void main(String[] args) {
		System.out.println("******Hibernate One To Many Mapping Example********");
		try {
		 session= factory().openSession();
		 session.beginTransaction();
		Department d1 = new Department("IT Department");
		
		Employee e1 = new Employee("Min","Ko","09977264873");
		e1.setDepartment(d1);
		Employee e2 = new Employee("Ko","Ko","09969237161");
		e2.setDepartment(d1);
		Set<Employee> elist = new HashSet<Employee>();
		
		elist.add(e1);
		elist.add(e2);
		
		//Employee e3 = new Employee("Thiri","Taw","09256195",d1);  
        
        //session.save(e1);

        //Employee e4 = new Employee("Mi","Mi","09799",d1);  
       
       // session.save(e2);
		d1.setEmployeeList(elist);
		
		session.save(d1);
		session.getTransaction().commit();
		System.out.println("********Recorded save Successfully*******");
		}catch(Exception e) {
			if(null!= session.getTransaction()) {
				System.out.println("\n ******Transaction is rolled back *******");
				session.beginTransaction().rollback();
			}
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
	}
	
}

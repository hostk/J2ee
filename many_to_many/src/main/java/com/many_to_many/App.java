package com.many_to_many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
	static Session session;
	static SessionFactory factory;
	
	public static SessionFactory Factory() {
		
		
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			
			Metadata meta = new MetadataSources(registry).getMetadataBuilder().build();
			
			factory = meta.getSessionFactoryBuilder().build();
			
		}catch(Throwable th) {
			System.err.println("Initialize Session Factory failed "+th);
			throw new ExceptionInInitializerError(th);
		}
		
		return factory;
	}
	public static void main(String[] args) {
		
		System.out.println("Successfully");

		try{
		session = Factory().openSession();
		session.beginTransaction();
		
		Post p1 = new Post("Love Section");
		Post p2 = new Post("What is love?");
		
		Tag t1 = new Tag("Love");
		Tag t2 = new Tag("Question");
	
		p1.addTag(t1);
		p1.addTag(t2);
		
		p2.addTag(t1);
		session.save(p1);
		session.save(p2);
		System.out.println("\n.......Records Saved Successfully To The Database.......");
		
		p2.removeTag(t2);
		
		System.out.println("\nSuccesgul");
		session.getTransaction().commit();
		
		}catch(Exception e) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
	}
	
}

package com.minko.otm.utl;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFac;
	
	public HibernateUtil(SessionFactory sessionF) {
		this.sessionFac = sessionF;
		
	}
	public static SessionFactory sessionFactory() {
		try {
			StandardServiceRegistry registry  = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata medata = new MetadataSources(registry).getMetadataBuilder().build();
			sessionFac = medata.buildSessionFactory();
			
		}catch(Exception th){
			System.out.println("Intialization Session Factory failed "+th);
		}
		
		return sessionFac;
		
	}
	
}

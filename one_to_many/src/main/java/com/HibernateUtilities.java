package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilities {
	static Session session;
	static SessionFactory sessionFactoryObj;
	public SessionFactory factory() {
		try {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(registry).getMetadataBuilder().build();
			sessionFactoryObj = metaData.buildSessionFactory();
			
		}catch(Throwable th) {
			System.err.println("Failed SessionFactory creating "+th);
			throw new ExceptionInInitializerError(th);
		}
		
		return sessionFactoryObj;
		
	}
	
}

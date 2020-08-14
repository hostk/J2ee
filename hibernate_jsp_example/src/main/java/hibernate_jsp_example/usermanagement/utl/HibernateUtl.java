package hibernate_jsp_example.usermanagement.utl;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import hibernate_jsp_example.usermanagement.model.User;

public class HibernateUtl {
	private static Session sessionObj;
	private static SessionFactory factoryObj;
	
	public static SessionFactory sessionFactory() {
		
		if(factoryObj==null) {
			try {
				
			    StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			    
			    Metadata metaData = new MetadataSources(registry).getMetadataBuilder().build();
			    System.out.println("Hibernate Java Config serviceRegistry created");
			    
			    factoryObj = metaData.getSessionFactoryBuilder().build();
				return factoryObj;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return factoryObj;
		
	}
	

}

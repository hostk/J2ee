package com.spring.test2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainApp2 {

	public static void main(String[] args) {
		Resource r = new ClassPathResource("Beans2.xml");
		BeanFactory factory=new XmlBeanFactory(r);
		Employee e = (Employee) factory.getBean("employee");
		
		e.show();
	}

}

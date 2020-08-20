package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.setMessage("Min Ko Ko");
		
		obj.getMessage();
		
		HelloWorld bj2 = (HelloWorld) context.getBean("helloWorld");
		
		bj2.getMessage();
		
	}

}

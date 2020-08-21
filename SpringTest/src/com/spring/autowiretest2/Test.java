package com.spring.autowiretest2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean6.xml");
		Student studen=(Student) context.getBean("student");
		System.out.println("Name : "+studen.getName());
		System.out.println("Age : "+studen.getAge());
		
	}

}

package com.spring.autowiretest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean5.xml");
		A a = context.getBean("a",A.class);
		a.display();
	}
}

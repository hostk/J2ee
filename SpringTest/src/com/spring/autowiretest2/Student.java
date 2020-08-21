package com.spring.autowiretest2;

import org.springframework.beans.factory.annotation.Required;

public class Student {
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	@Required
	public void setAge(int age) {
		this.age = age;
	}
	
}

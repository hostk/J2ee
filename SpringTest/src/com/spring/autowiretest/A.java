package com.spring.autowiretest;

public class A {
	private B b;
	public A() {
		System.out.println("A is created.");
	}
	public void print() {
		System.out.println("Hello A");
	}
	
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
	public void display() {
		print();
		b.print();
	}
}

package com.spring.test3;

public class Answer {
	private int id;
	private String name;
	private String by;
	public Answer(int id, String name, String by) {
		super();
		this.id = id;
		this.name = name;
		this.by = by;
	}
	public Answer() {
		
	}
	public String toString() {
		return id+" "+name+" "+by;
		
	}
}

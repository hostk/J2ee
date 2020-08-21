package com.spring.test3;

import java.util.Iterator;
import java.util.List;

public class Question {
	private int id;
	private String name;
	private List<Answer> answer;
	
	public Question(int id, String name, List<Answer> answer) {
		super();
		this.id = id;
		this.name = name;
		this.answer = answer;
	}
	public Question() {
		
	}
	public void displayInfo() {
		System.out.println(id + " : "+name);
		System.out.println("Answers are :");
		Iterator<Answer> tr = answer.iterator();
		while(tr.hasNext()) {
			System.out.println(tr.next());
		}
	}
}

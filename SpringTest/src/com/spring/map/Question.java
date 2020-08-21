package com.spring.map;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question {
	private int id;
	private String name;
	private Map<String,String> answer;
	
	public Question(int id, String name, Map<String,String> answer) {
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
		Set<Entry<String,String>> set =answer.entrySet();
		Iterator<Entry<String,String>> tr = set.iterator();
		while(tr.hasNext()) {
			Entry<String,String> entry=tr.next();
			System.out.println("Answer:"+entry.getKey()+" Posted by : "+entry.getValue());
		}
	}
}

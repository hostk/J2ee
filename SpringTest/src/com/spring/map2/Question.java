package com.spring.map2;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question {
	private int id;
	private String name;
	private Map<Answer,User> answer;
	
	public Question(int id, String name, Map<Answer,User> answer) {
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
		Set<Entry<Answer,User>> set =answer.entrySet();
		Iterator<Entry<Answer,User>> tr = set.iterator();
		while(tr.hasNext()) {
			Entry<Answer,User> entry=tr.next();
			Answer ans=entry.getKey();  
	        User user=entry.getValue();  
	        System.out.println("Answer Information:");  
	        System.out.println(ans);  
	        System.out.println("Posted By:");  
	        System.out.println(user);  
			
		}
	}
}

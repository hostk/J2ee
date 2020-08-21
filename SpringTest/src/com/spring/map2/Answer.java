package com.spring.map2;

import java.util.Date;

public class Answer {
	private int id;
	private String name;
	private Date postedDate;
	
	public Answer(int id, String name, Date postedDate) {
		super();
		this.id = id;
		this.name = name;
		this.postedDate = postedDate;
	}
	public Answer() {
		
	}
	public String toString() {
		return "ID: "+id+" Answer :"+name+" Posted Date: "+postedDate;
		
	}
}

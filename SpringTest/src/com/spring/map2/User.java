package com.spring.map2;

public class User {
	private int id;
	private String name;
	private String email;
	public User(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public User() {
		
	}
	public String toString() {
		return "User Id :"+id+" User Name: "+name+" Email:"+email;
	}
}

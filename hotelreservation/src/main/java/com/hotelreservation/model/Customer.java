package com.hotelreservation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String phoneNo;
	private String email;
	public Customer(Integer id, String name, String phoneNo, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	public Customer(String name, String phoneNo, String email) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	public Customer() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

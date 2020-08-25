package com.springmvc.Shopping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Privilege")
public class Privilege implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="RollCode")
	private String rollCode;
	
	@Column(name="PrivilegeName")
	private String privilegeName;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="privilegeList")
	private List<UserRole> users= new ArrayList<UserRole>();

	public Privilege(Long id, String rollCode, String privilegeName, List<UserRole> users) {
		super();
		this.id = id;
		this.rollCode = rollCode;
		this.privilegeName = privilegeName;
		this.users = users;
	}

	public Privilege(String rollCode, String privilegeName) {
		super();
		this.rollCode = rollCode;
		this.privilegeName = privilegeName;
	}

	public Privilege() {
		super();
	}

	public Privilege(String rollCode, String privilegeName, List<UserRole> users) {
		super();
		this.rollCode = rollCode;
		this.privilegeName = privilegeName;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRollCode() {
		return rollCode;
	}

	public void setRollCode(String rollCode) {
		this.rollCode = rollCode;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public List<UserRole> getUsers() {
		return users;
	}

	public void setUsers(List<UserRole> users) {
		this.users = users;
	}
	
}

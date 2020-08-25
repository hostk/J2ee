package com.springmvc.Shopping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserRole")
public class UserRole implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="UserRole_Privilege",
	joinColumns= {@JoinColumn(name="role_id",nullable=false)}
	,inverseJoinColumns= {@JoinColumn(name="privilege_id",nullable=false)})
	private List<Privilege> privilegeList= new ArrayList<Privilege>();

	public UserRole(Long id, String name, List<Privilege> privilegeList) {
		super();
		this.id = id;
		this.name = name;
		this.privilegeList = privilegeList;
	}

	public UserRole(String name, List<Privilege> privilegeList) {
		super();
		this.name = name;
		this.privilegeList = privilegeList;
	}

	public UserRole(String name) {
		super();
		this.name = name;
	}

	public UserRole() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Privilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
	}
	
	
	
}

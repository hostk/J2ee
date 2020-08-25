package com.springsecurity.exe.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Role")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	public Role() {
		super();
	}
	
	@ManyToMany(mappedBy="user")
	private Collection<User> user;

	
	@ManyToMany
	@JoinTable(name="role_privileges",joinColumns=@JoinColumn(name="role_id",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="privilege_id",referencedColumnName="id"))
	private Collection<Privilege> privilege;

	public Role(String name) {
		super();
		this.name = name;
	}
	
	public Role(String name, Collection<User> user, Collection<Privilege> privilege) {
		super();
		this.name = name;
		this.user = user;
		this.privilege = privilege;
	}
	
	public Role(Long id, String name, Collection<User> user, Collection<Privilege> privilege) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.privilege = privilege;
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


	public Collection<User> getUser() {
		return user;
	}

	public void setUser(Collection<User> user) {
		this.user = user;
	}

	public Collection<Privilege> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Collection<Privilege> privilege) {
		this.privilege = privilege;
	}
	
	
	
}

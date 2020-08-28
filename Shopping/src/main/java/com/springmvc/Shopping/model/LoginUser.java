package com.springmvc.Shopping.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class LoginUser implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String email;
	private String password;
	
	@OneToOne
	@JoinColumn(name="role_id")
	private UserRole userRole=new UserRole();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public LoginUser(Long id, String name, String email, String password, UserRole userRole) {
		super();
		this.id = id;
		this.username = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}

	public LoginUser() {
		super();
	}

	public LoginUser(String name, String email, String password) {
		super();
		this.username = name;
		this.email = email;
		this.password = password;
	}

	public LoginUser(String name, String email, String password, UserRole userRole) {
		super();
		this.username = name;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}
	
	
	
	
}

package com.springsecurity.exe.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
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
	private String name;
	
	public Privilege() {
		super();
	}

	@ManyToMany(mappedBy="privilege")
	private Collection<Role> role;

	public Privilege(Long id, String name, Collection<Role> role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public Privilege(String name, Collection<Role> role) {
		super();
		this.name = name;
		this.role = role;
	}

	public Privilege(String name) {
		super();
		this.name = name;
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

	public Collection<Role> getRole() {
		return role;
	}

	public void setRole(Collection<Role> role) {
		this.role = role;
	}
	
	
}

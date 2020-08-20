package com.minko.otm.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Grade")
public class Grade {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy="grade",targetEntity=Student.class,cascade=CascadeType.ALL)
	private Set<Student> stdList;	
	

	public Grade() {
		super();
	}


	public Grade(Integer id, String name, Set<Student> stdList) {
		super();
		this.id = id;
		this.name = name;
		this.stdList = stdList;
	}

	public Grade(String name, Set<Student> stdList) {
		super();
		this.name = name;
		this.stdList = stdList;
	}

	public Grade(String name) {
		super();
		this.name = name;
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

	public Set<Student> getStdList() {
		return stdList;
	}

	public void setStdList(Set<Student> stdList) {
		this.stdList = stdList;
	}
	
	
}

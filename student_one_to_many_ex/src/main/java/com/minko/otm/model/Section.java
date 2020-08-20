package com.minko.otm.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Section")
public class Section {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	
	public Section() {
		// TODO Auto-generated constructor stub
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
	

	public Section(String name, Grade grade, Set<Student> studentList) {
		super();
		this.name = name;
		this.studentList = studentList;
	}

	public Section(String name) {
		super();
		this.name = name;
	}

	
	@OneToMany(mappedBy="section",targetEntity=Student.class,cascade=CascadeType.ALL)
	private Set<Student> studentList;


	public Set<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Set<Student> stdList) {
		this.studentList = stdList;
	}
	
	
}

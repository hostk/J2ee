package com.minko.otm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String rollNo;
	
	@JoinColumn(name="grade_id")
	@ManyToOne()
	private Grade grade;
	
	@JoinColumn(name="section_id")
	@ManyToOne()
	private Section section;
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Student() {
		
	}
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, String rollNo, Grade grade) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.grade = grade;
	}

	public Student(String name, String rollNo, Section section) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.section = section;
	}

	public Student(String name, String rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}

	public Student(Integer id, String name, String rollNo, Grade grade, Section section) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.grade = grade;
		this.section = section;
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
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
	
}

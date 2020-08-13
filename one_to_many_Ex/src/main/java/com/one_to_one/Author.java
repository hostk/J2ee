package com.one_to_one;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String phone;
	
	@OneToMany(mappedBy="author",targetEntity=Book.class,cascade=CascadeType.ALL)
	private Set<Book> bookList;
	
	public Author(int id, String name, String phone, Set<Book> bookList) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.bookList = bookList;
	}
	public Set<Book> getBookList() {
		return bookList;
	}
	public void setBookList(Set<Book> bookList) {
		this.bookList = bookList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Author() {
		
	}
	public Author(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
}

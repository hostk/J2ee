package com.one_to_one;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Book implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String isbn;
	
	@JoinColumn(name="author_id")
	@ManyToOne
	private Author author;
	
	public Book() {
		super();
	}

	public Book(int id, String name, String isbn, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.author = author;
	}

	public Book(String name, String isbn, Author author) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.author = author;
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

	public Book(String name, String isbn) {
		super();
		this.name = name;
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	
}

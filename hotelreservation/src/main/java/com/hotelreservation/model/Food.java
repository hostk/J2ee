package com.hotelreservation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Food")
public class Food implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private double price;
	private String photoPath;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category=new Category();

	public Food(String name, double price, String photoPath) {
		super();
		this.name = name;
		this.price = price;
		this.photoPath = photoPath;
	}

	public Food(String name, double price, String photoPath, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.photoPath = photoPath;
		this.category = category;
	}

	public Food(Integer id, String name, double price, String photoPath, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.photoPath = photoPath;
		this.category = category;
	}

	public Food() {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	
	
}

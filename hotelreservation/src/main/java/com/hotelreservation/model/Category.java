package com.hotelreservation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String foodType;
	public Category(Integer id, String foodType) {
		super();
		this.id = id;
		this.foodType = foodType;
	}
	public Category(String foodType) {
		super();
		this.foodType = foodType;
	}
	public Category() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
}

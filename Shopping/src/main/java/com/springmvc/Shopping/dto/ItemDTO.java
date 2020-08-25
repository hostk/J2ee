package com.springmvc.Shopping.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.Shopping.model.Category;

public class ItemDTO implements Serializable {
	
	private Integer id;
	@NotEmpty(message = "Please fill your name")
	private String name;
	private String photoPath;
	private Integer qty;
	private Double price;
	private MultipartFile file;
	private Category category = new Category();
	public ItemDTO(Integer id, String name, String photoPath, Integer qty, Double price, MultipartFile file,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.photoPath = photoPath;
		this.qty = qty;
		this.price = price;
		this.file = file;
		this.category = category;
	}
	public ItemDTO(String name, String photoPath, Integer qty, Double price, MultipartFile file) {
		super();
		this.name = name;
		this.photoPath = photoPath;
		this.qty = qty;
		this.price = price;
		this.file = file;
	}
	public ItemDTO(String name, String photoPath, Integer qty, Double price, MultipartFile file, Category category) {
		super();
		this.name = name;
		this.photoPath = photoPath;
		this.qty = qty;
		this.price = price;
		this.file = file;
		this.category = category;
	}
	public ItemDTO() {
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
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	

}

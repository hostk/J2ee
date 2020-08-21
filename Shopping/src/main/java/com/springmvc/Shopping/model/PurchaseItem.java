package com.springmvc.Shopping.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="PurchaseItem")
public class PurchaseItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private Date purchaseDate;
	private Integer qty;
	private Double TatolAmount;
	
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

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getTatolAmount() {
		return TatolAmount;
	}

	public void setTatolAmount(Double tatolAmount) {
		TatolAmount = tatolAmount;
	}
	
	@OneToMany
	@JoinColumn(name="item_id")
	private List<Item> item;

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public PurchaseItem(Integer id, String name, Date purchaseDate, Integer qty, Double tatolAmount, List<Item> item) {
		super();
		this.id = id;
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.qty = qty;
		TatolAmount = tatolAmount;
		this.item = item;
	}

	public PurchaseItem(String name, Date purchaseDate, Integer qty, Double tatolAmount) {
		super();
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.qty = qty;
		TatolAmount = tatolAmount;
	}
	
	
}

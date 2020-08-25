package com.springmvc.Shopping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="PurchaseItem")
public class PurchaseItem implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer qty;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date purchaseDate;
	
	public PurchaseItem(Integer id, Integer qty, Date purchaseDate, Item item) {
		super();
		this.id = id;
		this.qty = qty;
		this.purchaseDate = purchaseDate;
		this.item = item;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	
	


	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item=new Item();

	

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public PurchaseItem() {
		
	}

	
	
	
}

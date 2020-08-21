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
@Table(name="SaleItem")
public class SaleItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer qty;
	private Date saleDate;
	private Double totalPrice;
	
	
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


	public Date getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
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


	public SaleItem(Integer id, Integer qty, Date saleDate, Double totalPrice, Item item) {
		super();
		this.id = id;
		this.qty = qty;
		this.saleDate = saleDate;
		this.totalPrice = totalPrice;
		this.item = item;
	}


	public SaleItem(Integer qty, Date saleDate, Double totalPrice) {
		super();
		this.qty = qty;
		this.saleDate = saleDate;
		this.totalPrice = totalPrice;
	}


	public SaleItem() {
		// TODO Auto-generated constructor stub
	}
	

	
}

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
@Table(name="SaleItem")
public class SaleItem implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer qty;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date saleDate;
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item = new Item();
	
	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public SaleItem(Integer id, Integer qty, Date saleDate, Item item) {
		super();
		this.id = id;
		this.qty = qty;
		this.saleDate = saleDate;
		this.item = item;
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


	public Date getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public SaleItem(Integer qty, Date saleDate, Double totalPrice) {
		super();
		this.qty = qty;
		this.saleDate = saleDate;
	}


	public SaleItem() {
		// TODO Auto-generated constructor stub
	}
	

	
}

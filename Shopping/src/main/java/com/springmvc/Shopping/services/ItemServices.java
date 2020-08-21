package com.springmvc.Shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Shopping.dao.ItemDao;
import com.springmvc.Shopping.model.Category;
import com.springmvc.Shopping.model.Item;
import com.springmvc.Shopping.model.PurchaseItem;
import com.springmvc.Shopping.model.SaleItem;

@Service
@Transactional
public class ItemServices {
	@Autowired
	ItemDao itemDao;
	
	@Transactional
	public void saveCategory(Category category) throws Exception{
		try {
			itemDao.saveCategory(category);
		}catch(Exception ex) {
			throw ex;
		}
	}
	public List<Category> getCatList(){
		return itemDao.getCatList();
	}
	public void saveItem(Item item) throws Exception{
		try {
			itemDao.saveItem(item);
		}catch(Exception e){
			throw e;
		}
	}
	public List<Item> getItemList(){
		return itemDao.getItemList();
	}
	public void savePurchase(PurchaseItem purchase) throws Exception{
		try {
			itemDao.savePurchase(purchase);
		}catch(Exception e){
			throw e;
		}
	}
	public List<PurchaseItem> getPurchaseItem(){
		return itemDao.getPurchaseItem();
	}
	public void saveSaleItem(SaleItem sale) throws Exception{
		try {
			itemDao.saveSale(sale);
		}catch(Exception e){
			throw e;
		}
	}
	public List<SaleItem> getSaleItem(){
		return itemDao.getSaleItem();
	}
	
}

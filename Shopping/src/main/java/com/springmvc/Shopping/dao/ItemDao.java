package com.springmvc.Shopping.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.Shopping.model.Category;
import com.springmvc.Shopping.model.Item;
import com.springmvc.Shopping.model.PurchaseItem;
import com.springmvc.Shopping.model.SaleItem;

@Repository
public class ItemDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void saveCategory(Category category) {
		getSession().save(category);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getCatList(){
		Criteria cr = getSession().createCriteria(Category.class);
		return (List<Category>) cr.list();
	}
	
	public void saveItem(Item item) {
		getSession().save(item);
	}
	@SuppressWarnings("unchecked")
	public List<Item> getItemList(){
		Criteria cr = getSession().createCriteria(Item.class);
		return (List<Item>)cr.list();
	}
	public void savePurchase(PurchaseItem purchase) {
		getSession().save(purchase);
	}
	public List<PurchaseItem> getPurchaseItem(){
		Criteria cr = getSession().createCriteria(PurchaseItem.class);
		return (List<PurchaseItem>)cr.list();
	}
	public void saveSale(SaleItem sale) {
		getSession().save(sale);
	}
	public List<SaleItem> getSaleItem(){
		Criteria cr = getSession().createCriteria(SaleItem.class);
		return (List<SaleItem>)cr.list();
	}
	
	public boolean updateItemByPurchase(int id,int qty) {
		Query query= getSession().createQuery("UPDATE Item SET qty=qty+:qty WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("qty", qty);
		query.executeUpdate();
		return true;

	}
	
	public boolean updateItemBySale(int id,int qty) {
		Query query= getSession().createQuery("UPDATE Item SET qty=qty-:qty WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("qty", qty);
		query.executeUpdate();
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> getItemBySearch(String search) {
		if(search=="") {
			Criteria cr = getSession().createCriteria(Item.class);
			return (List<Item>) cr.list();
		}else{
		Criteria cr = getSession().createCriteria(Item.class);
		cr.add(Restrictions.like("name", search+"%"));
		return (List<Item>) cr.list();
		}
	}
	
	public List<Item> getItemListByCategory(int name) {
		if(name!=0) {
			String sql = "FROM Item WHERE category_id=:id";
			Query query = getSession().createQuery(sql);
			query.setParameter("id", name);
			return (List<Item>) query.list();
		}else {
			Criteria cr = getSession().createCriteria(Item.class);
			return (List<Item>) cr.list();
		}
	}

	
}

package com.hotelreservation.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelreservation.model.Category;
import com.hotelreservation.model.Food;

@Repository
public class FoodItemDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void saveCategory(Category category) {
		getSession().save(category);
	}
	@SuppressWarnings("unchecked")
	public List<Category> getCategoryList(){
		Criteria cr = getSession().createCriteria(Category.class);
		return (List<Category>) cr.list();
	}
	
	public void saveFoodItem(Food item) {
		getSession().save(item);
	}	
	
	@SuppressWarnings("unchecked")
	public List<Food> getFoodItemList(){
		Criteria cr = getSession().createCriteria(Food.class);
		return (List<Food>) cr.list();
	}
}

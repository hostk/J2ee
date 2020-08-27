package com.springmvc.Shopping.services;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Shopping.dao.ItemDao;
import com.springmvc.Shopping.model.Category;
import com.springmvc.Shopping.model.Item;

@Service
@Transactional
public class UserViewService {
	@Autowired
	ServletContext serveletContext;
	
	@Autowired
	ItemDao itemDao;

	@Transactional
	public List<Category> getCatList(){
		return itemDao.getCatList();
	}
	
	public List<Item> getItemBySearch(String serach){
		return itemDao.getItemList();
	}
}

package com.springmvc.Shopping.services;

import java.util.List;

import com.springmvc.Shopping.model.Item;

public interface UserServiceInterface{
	
	public List<Item> listAll(String keyword);
}

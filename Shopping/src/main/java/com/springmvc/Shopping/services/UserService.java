package com.springmvc.Shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Shopping.dao.ItemDao;
import com.springmvc.Shopping.model.Item;
@Service
public class UserService{
	@Autowired
	private ItemDao repo;
	
	

}

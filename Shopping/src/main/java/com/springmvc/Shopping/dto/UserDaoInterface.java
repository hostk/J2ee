package com.springmvc.Shopping.dto;

import java.util.List;

import com.springmvc.Shopping.model.User;
import com.springmvc.Shopping.model.UserRole;

public interface UserDaoInterface {
	
	public User findUserbyUserName(String name);
	public void saveUser(User user);
	public List<UserRole> gettUserRoleList();
}	

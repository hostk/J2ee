package com.springmvc.Shopping.dao;

import java.util.List;

import com.springmvc.Shopping.model.LoginUser;
import com.springmvc.Shopping.model.UserRole;

public interface UserDaoInterface {
	
	public LoginUser findUserbyUserName(String name);
	public void saveUser(LoginUser user);
	public List<UserRole> gettUserRoleList();
}	

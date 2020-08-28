package com.springmvc.Shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Shopping.dao.UserDao;
import com.springmvc.Shopping.dto.UserDTO;
import com.springmvc.Shopping.model.LoginUser;
import com.springmvc.Shopping.model.UserRole;

@Service
@Transactional
public class UserInfoService implements UserServiceInterface {
	@Autowired
	UserDao userDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	public void saveUser(UserDTO user) {
		// TODO Auto-generated method stub
		LoginUser loginUser=new LoginUser();
		loginUser.setName(user.getUsername());
		loginUser.setPassword(passwordEncoder.encode(user.getPassword()));
		loginUser.getUserRole().setId(user.getRoleId());
		userDao.saveUser(loginUser);
	}
	public List<UserRole> getUserRoles() {
		// TODO Auto-generated method stub
		return userDao.gettUserRoleList();
	}

}

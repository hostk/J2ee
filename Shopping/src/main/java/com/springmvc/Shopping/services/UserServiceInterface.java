package com.springmvc.Shopping.services;

import java.util.List;

import com.springmvc.Shopping.dto.UserDTO;
import com.springmvc.Shopping.model.UserRole;

public interface UserServiceInterface {
	public void saveUser(UserDTO user);
	public List<UserRole> getUserRoles();
}

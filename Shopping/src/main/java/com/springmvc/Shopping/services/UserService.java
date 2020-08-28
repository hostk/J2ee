package com.springmvc.Shopping.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Shopping.dao.UserDao;
import com.springmvc.Shopping.model.LoginUser;
import com.springmvc.Shopping.model.Privilege;

@Service
@Transactional
public class UserService implements UserDetailsService {
	@Autowired
	UserDao userDao;
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LoginUser user=userDao.findUserbyUserName(name);
		List<GrantedAuthority> authories=new ArrayList<GrantedAuthority>();
		for(Privilege p : user.getUserRole().getPrivilegeList()){
			GrantedAuthority authority = new SimpleGrantedAuthority(p.getRollCode());
			authories.add(authority);
		}		
		UserDetails userDetails = (UserDetails)new User(user.getName(),
				user.getPassword(), authories);
		return userDetails;
	}

}
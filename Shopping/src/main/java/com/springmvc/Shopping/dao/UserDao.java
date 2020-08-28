package com.springmvc.Shopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.Shopping.model.LoginUser;
import com.springmvc.Shopping.model.UserRole;

@Repository
public class UserDao implements UserDaoInterface{

	@Autowired
	SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public LoginUser findUserbyUserName(String name) {
		Criteria cr = getSession().createCriteria(LoginUser.class).createAlias("userRole","r",JoinType.LEFT_OUTER_JOIN)
				.createAlias("r.privilegeList", "p",JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("name", name));
		LoginUser user =(LoginUser) cr.uniqueResult();
		return user;
	}

	@Override
	public void saveUser(LoginUser user) {
		getSession().save(user);
	}

	@Override
	public List<UserRole> gettUserRoleList() {
		Criteria cr = getSession().createCriteria(UserRole.class);
		
		return (List<UserRole>) cr.list();
	}

}

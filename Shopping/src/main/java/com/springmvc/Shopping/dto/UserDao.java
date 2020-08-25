package com.springmvc.Shopping.dto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.Shopping.model.User;
import com.springmvc.Shopping.model.UserRole;

@Repository
public class UserDao implements UserDaoInterface{

	@Autowired
	SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public User findUserbyUserName(String name) {
		Criteria cr = getSession().createCriteria(User.class).createAlias("userRole","r",JoinType.LEFT_OUTER_JOIN)
				.createAlias("r.privilegeList", "p",JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("name", name));
		User user =(User) cr.uniqueResult();
		return user;
	}

	@Override
	public void saveUser(User user) {
		getSession().save(user);
	}

	@Override
	public List<UserRole> gettUserRoleList() {
		Criteria cr = getSession().createCriteria(UserRole.class);
		
		return (List<UserRole>) cr.list();
	}

}

package com.mindfire.marketplace.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mindfire.marketplace.dao.UserDao;
import com.mindfire.marketplace.model.UserModel;

@Transactional
public class DefaultUserDao implements UserDao {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public UserModel fetchUserByUsername(String username) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  UserModel u where u.userID = :username");
		query.setParameter("username", username);
		List<UserModel> list = query.list();
		return (list.isEmpty() ? null : list.get(0));
	}

}

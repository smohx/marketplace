package com.mindfire.marketplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindfire.marketplace.dao.UserDao;
import com.mindfire.marketplace.model.UserModel;
import com.mindfire.marketplace.service.UserService;

public class DefaultUserService implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public UserModel fetchUserByUsername(String username) {
		
		return userDao.fetchUserByUsername(username);
	}

}

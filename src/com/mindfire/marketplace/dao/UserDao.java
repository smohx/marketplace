package com.mindfire.marketplace.dao;

import com.mindfire.marketplace.model.UserModel;

public interface UserDao {

	UserModel fetchUserByUsername(String username);
}

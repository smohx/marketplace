package com.mindfire.marketplace.service;

import com.mindfire.marketplace.model.UserModel;

public interface UserService {
	
	UserModel fetchUserByUsername(String username);

}

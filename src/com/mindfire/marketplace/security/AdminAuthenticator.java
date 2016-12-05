package com.mindfire.marketplace.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mindfire.marketplace.model.UserModel;
import com.mindfire.marketplace.service.UserService;

public class AdminAuthenticator implements UserDetailsService{

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userService.fetchUserByUsername(username);
		Set<GrantedAuthority>  grantedAuthorities = new HashSet<GrantedAuthority>();
		if(null != userModel){
			grantedAuthorities.add(new SimpleGrantedAuthority(userModel.getRole()));
		}
		else{
			throw new UsernameNotFoundException(username);
		}
		return new User(userModel.getUserID(), userModel.getPasswordEncoded(), grantedAuthorities);
	}

}

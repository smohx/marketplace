package com.mindfire.marketplace.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.marketplace.model.UserModel;
import com.mindfire.marketplace.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value ={"/adminLogin"})
	public ModelAndView adminLogin() {

		ModelAndView model = new ModelAndView();
		model.setViewName("adminLogin");

		return model;

	}
	@RequestMapping(value ={"/logout"})
	public ModelAndView adminLogout() {

		ModelAndView model = new ModelAndView();
		model.setViewName("logout");

		return model;

	}
	@RequestMapping(value ={"/adminPanel"})
	public ModelAndView adminPanel(HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(null != auth){
			String name = auth.getName();
			UserModel userModel = userService.fetchUserByUsername(name);
			if(null!=userModel){
				request.getSession().setAttribute("name", userModel.getFullName());
				request.getSession().setAttribute("image", userModel.getImageURL());
			}
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("adminPanel");

		return model;

	}

}

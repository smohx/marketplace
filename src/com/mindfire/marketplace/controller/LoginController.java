package com.mindfire.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value ={"/adminLogin"})
	public ModelAndView loginPage() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("adminLogin");

		return model;

	}

}

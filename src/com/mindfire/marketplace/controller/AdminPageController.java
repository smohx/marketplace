package com.mindfire.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminPageController {
	
	@RequestMapping(value ={"/addProduct"})
	public ModelAndView addProduct() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("snippet", "newProduct.jsp");
		model.addObject("nav", "Add Product");
		model.setViewName("adminPanel");

		return model;

	}
	@RequestMapping(value ={"/editProduct"})
	public ModelAndView editProduct(String code) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("snippet", "editProduct.jsp");
		model.addObject("nav", "Edit Product");
		model.addObject("code", code);
		model.setViewName("adminPanel");

		return model;

	}
	@RequestMapping(value ={"/editCategory"})
	public ModelAndView editCategory(String code) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("snippet", "editCategory.jsp");
		model.addObject("nav", "Add Category");
		model.addObject("code", code);
		model.setViewName("adminPanel");

		return model;

	}
	@RequestMapping(value ={"/productList"})
	public ModelAndView productList() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("nav", "Product List");
		model.addObject("snippet", "productList.jsp");
		model.setViewName("adminPanel");

		return model;

	}
	@RequestMapping(value ={"/addCategory"})
	public ModelAndView addCategory() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("nav", "Add Category");
		model.addObject("snippet", "newCategory.jsp");
		model.setViewName("adminPanel");

		return model;

	}
	@RequestMapping(value ={"/categoryList"})
	public ModelAndView categoryList() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("nav", "Category List");
		model.addObject("snippet", "categoryList.jsp");
		model.setViewName("adminPanel");

		return model;

	}
	@RequestMapping(value ={"/productDetails"})
	public ModelAndView productDetails(String code) {
		
		ModelAndView model = new ModelAndView();
		model.addObject("snippet", "productDetails.jsp");
		model.addObject("nav", "Product Details");
		model.addObject("code", code);
		model.setViewName("adminPanel");

		return model;

	}
	@RequestMapping(value ={"/categoryDetails"})
	public ModelAndView adminLogin(String code) {
		ModelAndView model = new ModelAndView();
		model.addObject("snippet", "categoryDetails.jsp");
		model.addObject("nav", "Category Details");
		model.addObject("code", code);
		model.setViewName("adminPanel");

		return model;

	}

}

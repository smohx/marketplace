package com.mindfire.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@ResponseBody
	@RequestMapping(value ="fetchCategoryDetails", method=RequestMethod.GET)
	public CategoryData fetchCategoryDetails(@RequestParam(value = "categoryCode", required = true) String code) {
		
		return categoryService.fetchCategoryDetails(code);

	}
	
	@ResponseBody
	@RequestMapping(value ="fetchAllCategories", method=RequestMethod.GET)
	public List<CategoryData> fetchAllCategories() {
		
		return categoryService.fetchAllCategories();

	}
	
	@ResponseBody
	@RequestMapping(value ="fetchTopCategories", method=RequestMethod.GET)
	public List<CategoryData> fetchTopCategories() {
		
		return categoryService.fetchTopCategories();

	}
	
	@ResponseBody
	@RequestMapping(value ="fetchSubCategories", method=RequestMethod.GET)
	public List<CategoryData> fetchSubCategories(@RequestParam(value = "categoryCode", required = true) String code) {
		
		return categoryService.fetchSubCategories(code);

	}
}

package com.mindfire.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.data.CategoryRequestData;
import com.mindfire.marketplace.data.ProductRequestData;
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
	@ResponseBody
	@RequestMapping(value ="addIcon", method=RequestMethod.POST)
	public String addMedia(@RequestParam(value = "iconData", required = true) String iconData) {

		return categoryService.saveTempIcon(iconData);
	}
	@ResponseBody
	@RequestMapping(value ="addNewCategory", method=RequestMethod.POST)
	public String addNewCategory(@RequestBody CategoryRequestData categoryData) {

		return categoryService.addNewCategory(categoryData);
	}
	
	@ResponseBody
	@RequestMapping(value ="modifyCategory", method=RequestMethod.POST)
	public String modifyCategory(@RequestBody CategoryRequestData categoryData) {

		return categoryService.modifyCategory(categoryData);
	}
}

package com.mindfire.marketplace.service;

import java.util.List;

import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.data.CategoryRequestData;


public interface CategoryService {

	CategoryData fetchCategoryDetails(String code);
	
	List<CategoryData> fetchAllCategories();
	
	List<CategoryData> fetchTopCategories();
	
	List<CategoryData> fetchSubCategories(String code);
	
	String saveTempIcon(String iconData);
	
	String addNewCategory(CategoryRequestData categoryData);
	
	String modifyCategory(CategoryRequestData categoryData);
	
	
}

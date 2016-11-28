package com.mindfire.marketplace.service;

import java.util.List;

import com.mindfire.marketplace.data.CategoryData;

public interface CategoryService {

	CategoryData fetchCategoryDetails(String code);
	
	List<CategoryData> fetchAllCategories();
	
	List<CategoryData> fetchTopCategories();
	
	List<CategoryData> fetchSubCategories(String code);
	
	
}

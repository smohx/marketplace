package com.mindfire.marketplace.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindfire.marketplace.dao.CategoryDao;
import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.populator.CategoryPopulator;
import com.mindfire.marketplace.service.CategoryService;

public class DefaultCategoryService implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	CategoryPopulator categoryPopulator;
	
	@Override
	public CategoryData fetchCategoryDetails(String code) {
		
		CategoryData categoryData = new CategoryData();
		categoryPopulator.populate(categoryDao.fetchCategoryByCode(code),categoryData);
		return categoryData;
	}

	@Override
	public List<CategoryData> fetchAllCategories() {
		List<CategoryData> categoryList = new ArrayList<CategoryData>();
		categoryPopulator.populate(categoryDao.fetchAllCategories(),categoryList);
		return categoryList;
	}

	@Override
	public List<CategoryData> fetchTopCategories() {
		List<CategoryData> categoryList = new ArrayList<CategoryData>();
		categoryPopulator.populate(categoryDao.fetchCategoriesByLevel("L1"),categoryList);
		return categoryList;
	}

	@Override
	public List<CategoryData> fetchSubCategories(String code) {
		
		List<CategoryData> categoryList = new ArrayList<CategoryData>();
		categoryPopulator.populate(categoryDao.fetchSubCategories(code),categoryList);
		return categoryList;
	}

}

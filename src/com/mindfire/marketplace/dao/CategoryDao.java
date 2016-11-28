package com.mindfire.marketplace.dao;

import java.util.List;
import com.mindfire.marketplace.model.CategoryModel;
import com.mindfire.marketplace.model.ProductCategoryRelationModel;

public interface CategoryDao {
	
	CategoryModel fetchCategoryByCode(String code);

	List<CategoryModel> fetchAllCategories();
	
	List<CategoryModel> fetchCategoriesByLevel(String level);
	
	List<CategoryModel> fetchSubCategories(String code);
	
	List<CategoryModel> fetchLowestCategories(String code);
	
	List<CategoryModel> fetchCategoriesForProduct(String code);
	
	void saveCategory(CategoryModel categoryModel);
	
	void saveCategoryProductRelation(ProductCategoryRelationModel productCategoryRelationModel);
	
}

package com.mindfire.marketplace.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindfire.marketplace.dao.CategoryDao;
import com.mindfire.marketplace.dao.ProductDao;
import com.mindfire.marketplace.data.ProductData;
import com.mindfire.marketplace.model.CategoryModel;
import com.mindfire.marketplace.populator.ProductPopulator;
import com.mindfire.marketplace.service.ProductService;

public class DefaultProductService implements ProductService {

	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductPopulator productPopulator;
	
	
	@Override
	public ProductData fetchProductDetail(String code) {
		
		ProductData productData = new ProductData();
		productPopulator.populate(productDao.fetchProductByCode(code),productData);
		return productData;
	}


	@Override
	public List<ProductData> fetchAllProducts() {
		List<ProductData> productDataList = new ArrayList<ProductData>();
		productPopulator.populate(productDao.fetchAllProducts(),productDataList);
		return productDataList;
	}


	@Override
	public List<ProductData> fetchProductsForCategory(String code) {
		
		List<ProductData> productDataList = new ArrayList<ProductData>();
		if(code.equalsIgnoreCase("all")){
			productPopulator.populate(productDao.fetchAllProducts(),productDataList);
		}
		else{
			CategoryModel categoryModel = categoryDao.fetchCategoryByCode(code);
			
			if(null != categoryModel){
				if(null != categoryModel.getLevel() && categoryModel.getLevel().equalsIgnoreCase("L2")){
					productPopulator.populate(productDao.fetchProductsByCategory(code),productDataList);
				}
				else if(null != categoryModel.getLevel() && categoryModel.getLevel().equalsIgnoreCase("L1")){
					List<CategoryModel> subcategoryList = categoryDao.fetchSubCategories(code);
					for(CategoryModel subCategory:subcategoryList){
						List<ProductData> categoryProductDataList = new ArrayList<ProductData>();
						productPopulator.populate(productDao.fetchProductsByCategory(subCategory.getCode()),categoryProductDataList);
						productDataList.addAll(categoryProductDataList);
					}
				}
			}
		}
		return productDataList;
	}

}

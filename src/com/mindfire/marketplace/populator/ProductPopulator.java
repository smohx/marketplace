package com.mindfire.marketplace.populator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindfire.marketplace.dao.CategoryDao;
import com.mindfire.marketplace.dao.ProductDao;
import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.data.ProductData;
import com.mindfire.marketplace.data.ProductMediaData;
import com.mindfire.marketplace.model.ProductModel;

public class ProductPopulator {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;

	public void populate(ProductModel source,ProductData target){
		target.setCode(source.getCode());
		target.setDescription(source.getDescription());
		target.setName(source.getName());
		target.setPrice(source.getPrice());
		target.setDefaultImageURL(source.getDefaultImageURL());
		List<CategoryData> categoryList = new ArrayList<CategoryData>();
		new CategoryPopulator().populate(categoryDao.fetchCategoriesForProduct(source.getCode()), categoryList);
		List<ProductMediaData> productMediaList = new ArrayList<ProductMediaData>();
		new ProductMediaPopulator().populate(productDao.fetchMediaForProduct(source.getCode()), productMediaList);
	}
	public void populate(List<ProductModel> sourceList,List<ProductData> targetList){
		for(ProductModel source:sourceList){
			ProductData target = new ProductData();
			target.setCode(source.getCode());
			target.setDescription(source.getDescription());
			target.setName(source.getName());
			target.setPrice(source.getPrice());
			target.setDefaultImageURL(source.getDefaultImageURL());
			List<CategoryData> categoryList = new ArrayList<CategoryData>();
			new CategoryPopulator().populate(categoryDao.fetchCategoriesForProduct(source.getCode()), categoryList);
			List<ProductMediaData> productMediaList = new ArrayList<ProductMediaData>();
			new ProductMediaPopulator().populate(productDao.fetchMediaForProduct(source.getCode()), productMediaList);
			targetList.add(target);
		}
	}
}
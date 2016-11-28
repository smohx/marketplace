package com.mindfire.marketplace.populator;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.mindfire.marketplace.dao.ProductDao;
import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.data.CategoryProductData;
import com.mindfire.marketplace.data.ProductData;
import com.mindfire.marketplace.model.CategoryModel;
import com.mindfire.marketplace.model.ProductModel;



public class CategoryProductPopulator {
	
	@Autowired
	ProductDao productDao;
	
	public void populate(CategoryModel source,CategoryProductData target){

		target.setCode(source.getCode());
		target.setDescription(source.getDescription());
		target.setIconURL(source.getIconURL());
		target.setLevel(source.getLevel());
		target.setName(source.getName());
		target.setSuperCategory(source.getSuperCategory());
		List<ProductData> productDataList = new ArrayList<ProductData>();
		List<ProductModel> productModelList = productDao.fetchProductsByCategory(source.getCode());
		for(ProductModel productModel:productModelList){
			ProductData productData = new ProductData();
			productData.setCode(productModel.getCode());
			productData.setDescription(productModel.getDescription());
			productData.setName(productModel.getName());
			productData.setProductSKU(productModel.getProductSKU());
			productData.setDefaultImageURL(productModel.getDefaultImageURL());
			productDataList.add(productData);
		}
		
	}
	public void populate(List<CategoryModel> sourceList,List<CategoryData> targetList){

		for(CategoryModel source:sourceList){
			CategoryData target = new CategoryData();
			target.setCode(source.getCode());
			target.setDescription(source.getDescription());
			target.setIconURL(source.getIconURL());
			target.setLevel(source.getLevel());
			target.setName(source.getName());
			target.setSuperCategory(source.getSuperCategory());
			List<ProductData> productDataList = new ArrayList<ProductData>();
			List<ProductModel> productModelList = productDao.fetchProductsByCategory(source.getCode());
			for(ProductModel productModel:productModelList){
				ProductData productData = new ProductData();
				productData.setCode(productModel.getCode());
				productData.setDescription(productModel.getDescription());
				productData.setName(productModel.getName());
				productData.setProductSKU(productModel.getProductSKU());
				productData.setDefaultImageURL(productModel.getDefaultImageURL());
				productDataList.add(productData);
			}
			targetList.add(target);
		}
	}

}

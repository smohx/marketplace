package com.mindfire.marketplace.dao;

import java.util.List;
import com.mindfire.marketplace.model.ProductMediaModel;
import com.mindfire.marketplace.model.ProductModel;

public interface ProductDao {
	
	ProductModel fetchProductByCode(String code);
	
	List<ProductMediaModel> fetchMediaForProduct(String code);
	
	List<ProductModel> fetchAllProducts();
	
	List<ProductModel> fetchProductsByCategory(String code);
	
	void saveProduct(ProductModel productModel);
	
	void saveProductMedia(ProductMediaModel productMediaModel);
	
	void deleteAllMediaForProduct(String code);
	
	void deleteAllCategoryForProduct(String code);
	
	String fetchPrimaryImageURL(String code);

}

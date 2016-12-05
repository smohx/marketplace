package com.mindfire.marketplace.service;

import java.util.List;

import com.mindfire.marketplace.data.ProductData;
import com.mindfire.marketplace.data.ProductRequestData;

public interface ProductService {
	
	ProductData fetchProductDetail(String code);
	
	List<ProductData> fetchAllProducts();
	
	List<ProductData> fetchProductsForCategory(String code);
	
	String saveTempImage(String imageData);
	
	String addNewProduct(ProductRequestData productData);
	
	String modifyProduct(ProductRequestData productData);

}

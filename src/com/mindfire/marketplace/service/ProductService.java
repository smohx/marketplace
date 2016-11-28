package com.mindfire.marketplace.service;

import java.util.List;

import com.mindfire.marketplace.data.ProductData;

public interface ProductService {
	
	ProductData fetchProductDetail(String code);
	
	List<ProductData> fetchAllProducts();
	
	List<ProductData> fetchProductsForCategory(String code);

}

package com.mindfire.marketplace.service;

import com.mindfire.marketplace.data.ProductData;

public interface ProductService {
	
	ProductData fetchProductDetail(String code);

}

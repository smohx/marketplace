package com.mindfire.marketplace.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindfire.marketplace.dao.ProductDao;
import com.mindfire.marketplace.data.ProductData;
import com.mindfire.marketplace.populator.ProductPopulator;
import com.mindfire.marketplace.service.ProductService;

public class DefaultProductService implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public ProductData fetchProductDetail(String code) {
		
		ProductData productData = new ProductData();
		new ProductPopulator().populate(productDao.fetchProductByCode(code),productData);
		return productData;
	}

}

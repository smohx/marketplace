package com.mindfire.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mindfire.marketplace.data.ProductData;
import com.mindfire.marketplace.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@ResponseBody
	@RequestMapping(value ="getProductsDetails", method=RequestMethod.GET)
	public ProductData getProductsForCategory(@RequestParam(value = "productCode", required = true) String code) {
		
		return productService.fetchProductDetail(code);


	}
}

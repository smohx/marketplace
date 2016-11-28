package com.mindfire.marketplace.controller;

import java.util.List;

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
	@RequestMapping(value ="fetchProductDetails", method=RequestMethod.GET)
	public ProductData fetchProductDetails(@RequestParam(value = "productCode", required = true) String code) {
		
		return productService.fetchProductDetail(code);


	}
	
	@ResponseBody
	@RequestMapping(value ="fetchProductsForCategory", method=RequestMethod.GET)
	public List<ProductData> fetchProductsForCategory(@RequestParam(value = "categoryCode", required = true) String code) {
		
		return productService.fetchProductsForCategory(code);


	}
	
	@ResponseBody
	@RequestMapping(value ="fetchAllProducts", method=RequestMethod.GET)
	public List<ProductData> fetchAllProducts() {
		
		return productService.fetchAllProducts();


	}
}

package com.mindfire.marketplace.data;

import java.util.List;

public class ProductRequestData {
	private String code;
	private String name;
	private String productSKU;
	private String description;
	private double price;
	private String defaultImageURL;
	private List<String> categoryList;
	private List<String> productMediaList;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductSKU() {
		return productSKU;
	}
	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDefaultImageURL() {
		return defaultImageURL;
	}
	public void setDefaultImageURL(String defaultImageURL) {
		this.defaultImageURL = defaultImageURL;
	}
	public List<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	public List<String> getProductMediaList() {
		return productMediaList;
	}
	public void setProductMediaList(List<String> productMediaList) {
		this.productMediaList = productMediaList;
	}
	
	

}

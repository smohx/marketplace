package com.mindfire.marketplace.data;

import java.util.List;

public class ProductData {
	private String code;
	private String name;
	private String productSKU;
	private String description;
	private double price;
	private String defaultImageURL;
	private List<CategoryData> categoryList;
	private List<ProductMediaData> productMediaList;
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
	public List<CategoryData> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryData> categoryList) {
		this.categoryList = categoryList;
	}
	public List<ProductMediaData> getProductMediaList() {
		return productMediaList;
	}
	public void setProductMediaList(List<ProductMediaData> productMediaList) {
		this.productMediaList = productMediaList;
	}
	
	

}

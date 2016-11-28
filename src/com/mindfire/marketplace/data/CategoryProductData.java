package com.mindfire.marketplace.data;

import java.util.List;

public class CategoryProductData {
	private String code;
	private String name;
	private String description;
	private String level;
	private String superCategory;
	private String iconURL;
	private List<ProductData> productList;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSuperCategory() {
		return superCategory;
	}
	public void setSuperCategory(String superCategory) {
		this.superCategory = superCategory;
	}
	public String getIconURL() {
		return iconURL;
	}
	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	public List<ProductData> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductData> productList) {
		this.productList = productList;
	}
	
	

}

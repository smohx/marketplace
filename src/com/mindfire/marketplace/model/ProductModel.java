package com.mindfire.marketplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductModel {
	@Id
	@Column(name = "p_code")
	private String code;
	
	@Column(name = "p_name")
	private String name;
	
	@Column(name = "p_productSKU")
	private String productSKU;
	
	@Column(name = "p_description")
	private String description;
	
	@Column(name = "p_defaultimageurl")
	private String defaultImageURL;
	
	@Column(name = "p_price")
	private double price;
	
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
	public String getDefaultImageURL() {
		return defaultImageURL;
	}
	public void setDefaultImageURL(String defaultImageURL) {
		this.defaultImageURL = defaultImageURL;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}

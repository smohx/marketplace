package com.mindfire.marketplace.model;

public class ProductCategoryRelationModel {
	private String code;
	private String sourceProduct;
	private String targetCategory;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSourceProduct() {
		return sourceProduct;
	}
	public void setSourceProduct(String sourceProduct) {
		this.sourceProduct = sourceProduct;
	}
	public String getTargetCategory() {
		return targetCategory;
	}
	public void setTargetCategory(String targetCategory) {
		this.targetCategory = targetCategory;
	}
	
	

}

package com.mindfire.marketplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prod2catrel")
public class ProductCategoryRelationModel {
	
	@Id
	@Column(name = "p_code")
	private String code;
	
	@Column(name = "p_sourceproduct")
	private String sourceProduct;
	
	@Column(name = "p_targetcategory")
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

package com.mindfire.marketplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class CategoryModel {
	
	@Id
	@Column(name = "p_code")
	private String code;
	
	@Column(name = "p_name")
	private String name;
	
	@Column(name = "p_description")
	private String description;
	
	@Column(name = "p_level")
	private String level;
	
	@Column(name = "p_supercategory")
	private String superCategory;
	
	@Column(name = "p_iconurl")
	private String iconURL;
	
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
	
	

}

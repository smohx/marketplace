package com.mindfire.marketplace.populator;

import java.util.List;

import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.model.CategoryModel;

public class CategoryPopulator {

	public void populate(CategoryModel source,CategoryData target){

		if(null != source){
			target.setCode(source.getCode());
			target.setDescription(source.getDescription());
			target.setIconURL(source.getIconURL());
			target.setLevel(source.getLevel());
			target.setName(source.getName());
			target.setSuperCategory(source.getSuperCategory());
		}
	}
	public void populate(List<CategoryModel> sourceList,List<CategoryData> targetList){

		if(!sourceList.isEmpty()){
			for(CategoryModel source:sourceList){
				CategoryData target = new CategoryData();
				target.setCode(source.getCode());
				target.setDescription(source.getDescription());
				target.setIconURL(source.getIconURL());
				target.setLevel(source.getLevel());
				target.setName(source.getName());
				target.setSuperCategory(source.getSuperCategory());
				targetList.add(target);
			}
		}
	}
}

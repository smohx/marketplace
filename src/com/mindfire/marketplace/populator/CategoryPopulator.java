package com.mindfire.marketplace.populator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindfire.marketplace.dao.CategoryDao;
import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.model.CategoryModel;

public class CategoryPopulator {

	@Autowired
	CategoryDao categoryDao;

	public void populate(CategoryModel source,CategoryData target){

		if(null != source){
			target.setCode(source.getCode());
			target.setDescription(source.getDescription());
			target.setIconURL(source.getIconURL());
			target.setLevel(source.getLevel());
			target.setName(source.getName());
			target.setSuperCategory(source.getSuperCategory());
			if(null != source.getSuperCategory() &&!source.getSuperCategory().isEmpty()){
				CategoryModel superCategory = categoryDao.fetchCategoryByCode(source.getSuperCategory());
				if(null != superCategory){
					target.setSuperCategoryName(superCategory.getName());
				}
			}
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
				if(null != source.getSuperCategory() &&!source.getSuperCategory().isEmpty()){
					CategoryModel superCategory = categoryDao.fetchCategoryByCode(source.getSuperCategory());
					if(null != superCategory){
						target.setSuperCategoryName(superCategory.getName());
					}
				}
				targetList.add(target);
			}
		}
	}
}

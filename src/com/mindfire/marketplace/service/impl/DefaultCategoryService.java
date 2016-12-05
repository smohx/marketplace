package com.mindfire.marketplace.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindfire.marketplace.dao.CategoryDao;
import com.mindfire.marketplace.dao.SequenceDao;
import com.mindfire.marketplace.data.CategoryData;
import com.mindfire.marketplace.data.CategoryRequestData;
import com.mindfire.marketplace.model.CategoryModel;
import com.mindfire.marketplace.populator.CategoryPopulator;
import com.mindfire.marketplace.service.CategoryService;

public class DefaultCategoryService implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	CategoryPopulator categoryPopulator;
	
	@Autowired
	SequenceDao sequenceDao;
	
	@Override
	public CategoryData fetchCategoryDetails(String code) {
		
		CategoryData categoryData = new CategoryData();
		categoryPopulator.populate(categoryDao.fetchCategoryByCode(code),categoryData);
		return categoryData;
	}

	@Override
	public List<CategoryData> fetchAllCategories() {
		List<CategoryData> categoryList = new ArrayList<CategoryData>();
		categoryPopulator.populate(categoryDao.fetchAllCategories(),categoryList);
		return categoryList;
	}

	@Override
	public List<CategoryData> fetchTopCategories() {
		List<CategoryData> categoryList = new ArrayList<CategoryData>();
		categoryPopulator.populate(categoryDao.fetchCategoriesByLevel("L1"),categoryList);
		return categoryList;
	}

	@Override
	public List<CategoryData> fetchSubCategories(String code) {
		
		List<CategoryData> categoryList = new ArrayList<CategoryData>();
		categoryPopulator.populate(categoryDao.fetchSubCategories(code),categoryList);
		return categoryList;
	}
	@Override
	public String saveTempIcon(String iconData) {
		String base64Image = iconData.split(",")[1];


		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);


		int value = sequenceDao.getTempImageSequence();

		try {
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageBytes));

			File imageFile = new File("Webcontent/resources/images/CI"+value+".png");
			File targetImageFile = new File("target/marketplace-0.0.1-SNAPSHOT/resources/images/CI"+value+".png");
			ImageIO.write(bufferedImage, "png", imageFile);
			ImageIO.write(bufferedImage, "png", targetImageFile);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return "CI"+value+".png";
	}

	@Override
	public String addNewCategory(CategoryRequestData categoryData) {
		
		String code = "C"+sequenceDao.getCategorySequence();
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setCode(code);
		categoryModel.setDescription(categoryData.getDescription());
		categoryModel.setIconURL(categoryData.getIconURL());
		categoryModel.setLevel(categoryData.getLevel());
		categoryModel.setName(categoryData.getName());
		categoryModel.setSuperCategory(categoryData.getSuperCategory());
		categoryDao.saveCategory(categoryModel);
		return code;
	}

	@Override
	public String modifyCategory(CategoryRequestData categoryData) {

		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setCode(categoryData.getCode());
		categoryModel.setDescription(categoryData.getDescription());
		categoryModel.setIconURL(categoryData.getIconURL());
		categoryModel.setLevel(categoryData.getLevel());
		categoryModel.setName(categoryData.getName());
		categoryModel.setSuperCategory(categoryData.getSuperCategory());
		categoryDao.saveCategory(categoryModel);
		return categoryData.getCode();
	}


}

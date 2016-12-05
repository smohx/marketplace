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
import com.mindfire.marketplace.dao.ProductDao;
import com.mindfire.marketplace.dao.SequenceDao;
import com.mindfire.marketplace.data.ProductData;
import com.mindfire.marketplace.data.ProductRequestData;
import com.mindfire.marketplace.model.CategoryModel;
import com.mindfire.marketplace.model.ProductCategoryRelationModel;
import com.mindfire.marketplace.model.ProductMediaModel;
import com.mindfire.marketplace.model.ProductModel;
import com.mindfire.marketplace.populator.ProductPopulator;
import com.mindfire.marketplace.service.ProductService;

public class DefaultProductService implements ProductService {


	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SequenceDao sequenceDao;

	@Autowired
	ProductPopulator productPopulator;


	@Override
	public ProductData fetchProductDetail(String code) {

		ProductData productData = new ProductData();
		productPopulator.populate(productDao.fetchProductByCode(code),productData);
		return productData;
	}


	@Override
	public List<ProductData> fetchAllProducts() {
		List<ProductData> productDataList = new ArrayList<ProductData>();
		productPopulator.populate(productDao.fetchAllProducts(),productDataList);
		return productDataList;
	}


	@Override
	public List<ProductData> fetchProductsForCategory(String code) {

		List<ProductData> productDataList = new ArrayList<ProductData>();
		if(code.equalsIgnoreCase("all")){
			productPopulator.populate(productDao.fetchAllProducts(),productDataList);
		}
		else{
			CategoryModel categoryModel = categoryDao.fetchCategoryByCode(code);

			if(null != categoryModel){
				if(null != categoryModel.getLevel() && categoryModel.getLevel().equalsIgnoreCase("L2")){
					productPopulator.populate(productDao.fetchProductsByCategory(code),productDataList);
				}
				else if(null != categoryModel.getLevel() && categoryModel.getLevel().equalsIgnoreCase("L1")){
					List<CategoryModel> subcategoryList = categoryDao.fetchSubCategories(code);
					for(CategoryModel subCategory:subcategoryList){
						List<ProductData> categoryProductDataList = new ArrayList<ProductData>();
						productPopulator.populate(productDao.fetchProductsByCategory(subCategory.getCode()),categoryProductDataList);
						productDataList.addAll(categoryProductDataList);
					}
				}
			}
		}
		return productDataList;
	}


	@Override
	public String saveTempImage(String imageData) {
		String base64Image = imageData.split(",")[1];


		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);


		int value = sequenceDao.getTempImageSequence();

		try {
			BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageBytes));

			File imageFile = new File("Webcontent/resources/images/PM"+value+".jpeg");
			File targetImageFile = new File("target/marketplace-0.0.1-SNAPSHOT/resources/images/PM"+value+".jpeg");
			ImageIO.write(bufferedImage, "jpeg", imageFile);
			ImageIO.write(bufferedImage, "jpeg", targetImageFile);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return "PM"+value+".jpeg";
	}


	@Override
	public String addNewProduct(ProductRequestData productData) {
		String code = "P"+sequenceDao.getProductSequence();
		ProductModel productModel = new ProductModel();
		if(null != productData){
			productModel.setName(productData.getName());
			productModel.setDefaultImageURL(productData.getDefaultImageURL());
			productModel.setDescription(productData.getDescription());
			productModel.setProductSKU(productData.getProductSKU());
			productModel.setPrice(productData.getPrice());
			productModel.setCode(code);
			
			for(String s:productData.getProductMediaList()){
				ProductMediaModel productMediaModel = new ProductMediaModel();
				productMediaModel.setProductCode(code);
				productMediaModel.setMediaType(s.split("\\.")[1]);
				productMediaModel.setMediaCode(s.split("\\.")[0]);
				productMediaModel.setMediaURL(s);
				productDao.saveProductMedia(productMediaModel);
			}
			for(String s:productData.getCategoryList()){
				ProductCategoryRelationModel relation = new ProductCategoryRelationModel();
				relation.setCode("R"+sequenceDao.getC2PRelationSequence());
				relation.setSourceProduct(code);
				relation.setTargetCategory(s);
				categoryDao.saveCategoryProductRelation(relation);
				
			}
			if(productModel.getDefaultImageURL() == null){
				productModel.setDefaultImageURL(productDao.fetchPrimaryImageURL(code));
			}
			productDao.saveProduct(productModel);
		}
		return code;
	}


	@Override
	public String modifyProduct(ProductRequestData productData) {
		String code = productData.getCode();
		ProductModel productModel = new ProductModel();
		if(null != productData){
			productModel.setCode(code);
			productModel.setName(productData.getName());
			productModel.setDefaultImageURL(productData.getDefaultImageURL());
			productModel.setDescription(productData.getDescription());
			productModel.setProductSKU(productData.getProductSKU());
			productModel.setPrice(productData.getPrice());
			productModel.setCode(code);
			
			productDao.deleteAllCategoryForProduct(code);
			productDao.deleteAllMediaForProduct(code);
			for(String s:productData.getProductMediaList()){
				ProductMediaModel productMediaModel = new ProductMediaModel();
				productMediaModel.setProductCode(code);
				productMediaModel.setMediaType(s.split("\\.")[1]);
				productMediaModel.setMediaCode(s.split("\\.")[0]);
				productMediaModel.setMediaURL(s);
				productDao.saveProductMedia(productMediaModel);
			}
			for(String s:productData.getCategoryList()){
				ProductCategoryRelationModel relation = new ProductCategoryRelationModel();
				relation.setCode("R"+sequenceDao.getC2PRelationSequence());
				relation.setSourceProduct(code);
				relation.setTargetCategory(s);
				categoryDao.saveCategoryProductRelation(relation);
				
			}
			if(productModel.getDefaultImageURL() == null){
				productModel.setDefaultImageURL(productDao.fetchPrimaryImageURL(code));
			}
			productDao.saveProduct(productModel);
		}
		return code;
	}

}

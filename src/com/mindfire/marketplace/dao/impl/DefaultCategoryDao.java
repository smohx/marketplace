package com.mindfire.marketplace.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.mindfire.marketplace.dao.CategoryDao;
import com.mindfire.marketplace.model.CategoryModel;
import com.mindfire.marketplace.model.ProductCategoryRelationModel;

@Transactional
public class DefaultCategoryDao implements CategoryDao {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public CategoryModel fetchCategoryByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> fetchAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> fetchCategoriesByLevel(String level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> fetchSubCategories(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryModel> fetchLowestCategories(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryModel> fetchCategoriesForProduct(String code) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select c FROM  CategoryModel c, ProductCategoryRelationModel p2c where c.code = p2c.targetCategory and p2c.sourceProduct = :productCode");
		query.setParameter("productCode", code);
		return query.list();
	}

	@Override
	public void saveCategory(CategoryModel categoryModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveCategoryProductRelation(ProductCategoryRelationModel productCategoryRelationModel) {
		// TODO Auto-generated method stub

	}

}

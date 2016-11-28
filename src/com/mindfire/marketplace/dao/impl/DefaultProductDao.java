package com.mindfire.marketplace.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import com.mindfire.marketplace.dao.ProductDao;
import com.mindfire.marketplace.model.ProductMediaModel;
import com.mindfire.marketplace.model.ProductModel;

@Transactional
public class DefaultProductDao implements ProductDao {

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public ProductModel fetchProductByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ProductModel");
		//query.setParameter("code", code);
		return  (ProductModel) query.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductMediaModel> fetchMediaForProduct(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ProductMediaModel");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> fetchAllProducts() {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ProductModel");
		return query.list();
	}

	@Override
	public List<ProductModel> fetchProductsByCategory(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(ProductModel productModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveProductMedia(ProductMediaModel productMediaModel) {
		// TODO Auto-generated method stub

	}

}

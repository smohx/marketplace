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
	
	@SuppressWarnings("unchecked")
	@Override
	public ProductModel fetchProductByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ProductModel p where p.code = :productCode");
		query.setParameter("productCode", code);
		List<ProductModel> list = query.list();
		return (list.isEmpty() ? null : list.get(0));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductMediaModel> fetchMediaForProduct(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ProductMediaModel m where m.productCode = :productCode");
		query.setParameter("productCode", code);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> fetchAllProducts() {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM  ProductModel");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> fetchProductsByCategory(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select p FROM  ProductModel p,ProductCategoryRelationModel p2c  where p.code = p2c.sourceProduct and p2c.targetCategory = :categoryCode");
		query.setParameter("categoryCode", code);
		return query.list();
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

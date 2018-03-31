
package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;

@Transactional
@Repository("productDAOImpl")

public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		System.out.println("Product -> " +product.getId()+"  "+ product.getPname());

		try {
			Session session = sessionFactory.openSession();
			System.out.println("Saving Product");
			Transaction transaction=(Transaction)session.beginTransaction();
			session.saveOrUpdate(product);
			transaction.commit();
			System.out.println("Product Saved");
			session.close();
			System.out.println("Session Closed");

			return true;
		} catch (Exception e){
			
			System.out.println("Exception Occurred");
			e.printStackTrace();
			return false;
		}

	}

	

	
	public Product getProduct(int productId) {
		Session session = sessionFactory.openSession();
		Transaction transaction=(Transaction)session.beginTransaction();
		Product product = (Product) session.get(Product.class, productId);
		transaction.commit();
		session.close();
		return product;
	}

	public List<Product> listProducts() {
		Session session = sessionFactory.openSession();
		
		List<Product> listProducts=session.createQuery("from Product",Product.class).list();
		
		session.close();
		return listProducts;
	}

	public boolean deleteProduct(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction=(Transaction)session.beginTransaction();
			System.out.println("delete Product");
			session.delete(product);
			transaction.commit();
			session.close();

			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}


}
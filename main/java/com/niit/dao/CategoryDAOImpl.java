package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;

@Transactional
@Repository("categoryDAOImpl")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {

		try {

			Session session = sessionFactory.openSession();
			Transaction transaction = (Transaction) session.beginTransaction();
			session.saveOrUpdate(category);
			transaction.commit();
			session.close();

			return true;
		} catch (Exception e)

		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteCategory(Category category) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = (Transaction) session.beginTransaction();
			System.out.println("delete category");
			session.delete(category);
			transaction.commit();
			session.close();

			return true;
		} catch (Exception e)

		{
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		Category category = (Category) session.get(Category.class, categoryId);
		transaction.commit();
		session.close();
		return category;
	}

	public List<Category> listCategories() {
		Session session = sessionFactory.openSession();
		List<Category> listCategories = session.createQuery("from Category", Category.class).list();

		session.close();
		return listCategories;
	}

}

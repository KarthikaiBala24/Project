package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetails;

@Transactional

@Repository("userDetailsDAOImpl")

public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addUserDetails(UserDetails userDetails)

	{

		try {

			Session session = sessionFactory.openSession();
			Transaction transaction = (Transaction) session.beginTransaction();
			session.saveOrUpdate(userDetails);
			transaction.commit();
			session.close();

			return true;
		} catch (Exception e)

		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteUserDetails(UserDetails userDetails) {
		try {
			Session session = sessionFactory.openSession();

			Transaction transaction = (Transaction) session.beginTransaction();

			session.delete(userDetails);
			transaction.commit();
			session.close();

			return true;
		} catch (Exception e)

		{
			e.printStackTrace();
			return false;
		}
	}

	public List<UserDetails> listUserDetails() {
		Session session = sessionFactory.openSession();
		List<UserDetails> listUserDetails = session.createQuery("from UserDetails", UserDetails.class).list();

		session.close();
		return listUserDetails;
	}

	public UserDetails getUserDetails(int userdetailsId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = (Transaction) session.beginTransaction();
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, userdetailsId);
		transaction.commit();
		session.close();
		return userDetails;
	}

}

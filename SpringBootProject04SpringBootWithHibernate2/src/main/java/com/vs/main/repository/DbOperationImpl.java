package com.vs.main.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.vs.main.config.HibernateConfig;
import com.vs.main.entities.User;

@Repository
public class DbOperationImpl implements DbOperations {

	@Override
	public User getUserDetails(Long id) {

		User user = null;
		try {

			try (Session session = HibernateConfig.getSessionFactory().openSession()) {
				user = session.get(User.class, 1L);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			Transaction tx = session.beginTransaction();
			session.save(user);

			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(Long id, String name) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = session.get(User.class, id);
			if (user != null) {
				user.setName(name);
				session.update(user);
				transaction.commit();
			} else {
				System.out.println("User Not Found");
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteUser(Long id) {
		Session session=HibernateConfig.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		
		try {
			
			User user=session.get(User.class, id);
			
			if(user!=null) {
				
				
				session.delete(user);
				tx.commit();
				System.out.println("User Deleted Successfully");
			}else {
				System.out.println("User Not Found");
			}
		} catch (Exception e) {
		tx.rollback();
		e.printStackTrace();
		}

//		

	}

}

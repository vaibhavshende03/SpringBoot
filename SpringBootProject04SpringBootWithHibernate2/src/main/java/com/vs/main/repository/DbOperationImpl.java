package com.vs.main.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.vs.main.config.HibernateConfig;
import com.vs.main.entities.User;
@Repository
public class DbOperationImpl implements DbOperations{

	@Override
	public User getUserDetails(Long id) {

		User user=null;
try {
	
try (Session session=HibernateConfig.getSessionFactory().openSession()){
	user=session.get(User.class,1L);
	
} catch (Exception e) {
	e.printStackTrace();
}
	
} catch (Exception e) {
e.printStackTrace();	
}
		
		return user;
	}

}

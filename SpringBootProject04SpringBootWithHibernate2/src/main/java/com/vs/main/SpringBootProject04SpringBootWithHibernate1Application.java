package com.vs.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vs.main.config.HibernateConfig;
import com.vs.main.entities.User;
import com.vs.main.repository.DbOperations;

@SpringBootApplication
public class SpringBootProject04SpringBootWithHibernate1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProject04SpringBootWithHibernate1Application.class,
				args);

		DbOperations dbop = context.getBean(DbOperations.class);
		User user = dbop.getUserDetails(1L);

		if (user != null) {
			System.out.println(user.getName());
		} else {
			System.out.println("User Not Found");
		}

		/*
		 * //--------------Insert--------
		 * 
		 * try { User user2=new User("Amay","amay@gmail.com","000000000","Male","Pune");
		 * dbop.insertUser(user2); System.out.println("User Inserted Successfully");
		 * 
		 * } catch (Exception e) {
		 * System.out.println("User not inserted Due to some error.");
		 * e.printStackTrace(); }
		 * 
		 */
		// ------Update User------

		try {
			dbop.updateUser(3L, "Aabhas");
			System.out.println("User Updated Successfully");
		} catch (Exception e) {
			System.out.println("User not updated due to some error.");
			e.printStackTrace();

		}

		// -------Delete User---------

		try {
			dbop.deleteUser(3L);
			
		} catch (Exception e) {
			System.out.println("User not Deleted due to some error.");
			e.printStackTrace();

		}
	}
}

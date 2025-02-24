package com.vs.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vs.main.entities.User;
import com.vs.main.repository.DbOperations;



@SpringBootApplication
public class SpringBootProject04SpringBootWithHibernate1Application {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(SpringBootProject04SpringBootWithHibernate1Application.class, args);
		
		DbOperations dbop=context.getBean(DbOperations.class);
		User user=dbop.getUserDetails(1L);
		
		if (user!=null) {
			System.out.println(user.getName());
		}
		else {
			System.out.println("User Not Found");
		}
	
		
	}
}

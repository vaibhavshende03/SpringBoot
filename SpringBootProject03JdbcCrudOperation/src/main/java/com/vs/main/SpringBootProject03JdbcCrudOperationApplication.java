package com.vs.main;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.vs.main.dao.UserDao;
import com.vs.main.entity.User;

@SpringBootApplication
public class SpringBootProject03JdbcCrudOperationApplication implements CommandLineRunner {
	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject03JdbcCrudOperationApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		//------Insertion-------------
		
//		User user1=new User("Bob", "bob@gmail.com","Male","Moscow");
		User user2=new User("Amit", "amit@gmail.com","Male","pune");

		boolean status= userDao.insertUser(user2);
		if (status) {
			System.out.println("User Inserted Successfully.");
		}
		else {
			System.out.println("User not inserted due to some error.");
		}
		
		*/
		
		/*
		
		//-----------Updation 1------------
		User user3=new User("Amit", "amit@gmail.com","Male","Delhi");
		boolean status=userDao.updateUser(user3);
		if (status) {
			System.out.println("User Updated Successfully.");
		}
		else {
			System.out.println("User not Updated due to some error.");
		}
		
		*/
		
		
		
		//-----------Updation 2------------
				User userUp=userDao.getUserByEmail("amit@gmail.com");
				userUp.setCity("Surat");
				
				boolean status=userDao.updateUser(userUp);
				if (status) {
					System.out.println("User Updated Successfully.");
				}
				else {
					System.out.println("User not Updated due to some error.");
				}
				
		
		/*
		
		//-----------Deletion-----------------
		
		boolean status=userDao.deleteUserByEmailId("amit@gmail.com");
		if (status) {
			System.out.println("User Deleted Successfully.");
		}
		else {
			System.out.println("User not Deleted due to some error.");
		}
		*/
		
		/*
		
		//---select one user
		
		User user= userDao.getUserByEmail("bob@gmail.com");
		System.out.println("Name: "+user.getName());
		System.out.println("Email: "+user.getEmail());
		System.out.println("Gender: "+user.getGender());
		System.out.println("City:"+user.getCity());

		*/
		
		
		
		//list of User
		
		List<User> userList=userDao.getListOfUser();
		for (User user : userList) {
			
			System.out.println("Name: "+user.getName());
			System.out.println("Email: "+user.getEmail());
			System.out.println("Gender: "+user.getGender());
			System.out.println("City:"+user.getCity());
			
			System.out.println("------------------------");

		}
		  
		
	}

}

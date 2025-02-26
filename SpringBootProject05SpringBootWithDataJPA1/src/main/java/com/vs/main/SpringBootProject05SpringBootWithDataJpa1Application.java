package com.vs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.vs.main.services.StudentService;
import com.vs.main.services.StudentServiceImpl;

@SpringBootApplication
public class SpringBootProject05SpringBootWithDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context=  SpringApplication.run(SpringBootProject05SpringBootWithDataJpa1Application.class, args);
		
//		StudentService studentService= context.getBean(StudentServiceImpl.class);

		StudentServiceImpl studentServiceImpl= context.getBean(StudentServiceImpl.class);
	/*
		//------InsertOperation-------------
		 Student std=new Student();
		 std.setName("Vaibhav");
		 std.setRollno(101);
		 std.setMarks(93.80f);
		 boolean status=studentServiceImpl.addStudentDetails(std);
		 if (status) {
			System.out.println("Student inserted Successfully.");
		}
		 else {
			System.out.println("Student not inserted due to some error.");
		}
		 */
		 /*
		 //-----------SelectOperation1---------------
		 
		 List<Student> stdList=studentServiceImpl.getAllStudentsDetails();
		 for (Student student : stdList) {
				System.out.println("Id:"+student.getId());
			System.out.println("Name:"+student.getName());
			System.out.println("Roll No. ::"+student.getRollno());
			System.out.println("Marks:"+student.getMarks());
			System.out.println("--------------------------------");

		}
		
		*/
		
		/*
		 //-----------Select Operation2---------------
		 Student student= studentServiceImpl.getStudentDetails(2L);
			if (student!=null) {
				System.out.println("Id:"+student.getId());
				System.out.println("Name:"+student.getName());
				System.out.println("Roll No. :"+student.getRollno());
				System.out.println("Marks:"+student.getMarks());
				System.out.println("--------------------------------");			
			} else {
				System.out.println("User not found.");
			}*/
	
		
		/*
			//-------------Update--------
			
			boolean status= studentServiceImpl.updateStudent(2L, 98.99f);
			
			if (status) {
				System.out.println("User Updated Successfully.");
			} else {
				System.out.println("User not updated due to some error.");
			}
			
			*/
			
		//-------------delete--------
			
			boolean status= studentServiceImpl.deleteStdDetails(2L);
			
			if (status) {
				System.out.println("User Deleted Successfully.");
			} else {
				System.out.println("User not Deleted due to some error.");
			}
			
	}

}

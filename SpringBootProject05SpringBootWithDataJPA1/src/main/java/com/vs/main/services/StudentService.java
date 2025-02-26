package com.vs.main.services;

import java.util.List;

import com.vs.main.entities.Student;

public interface StudentService {
	
//insert
public boolean addStudentDetails(Student std);
//select
public List<Student> getAllStudentsDetails();
public Student getStudentDetails(Long id);
public boolean updateStudent(Long id,float marks);
public boolean deleteStdDetails(Long id);
	
}

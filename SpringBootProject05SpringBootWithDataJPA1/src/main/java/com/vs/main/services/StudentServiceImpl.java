package com.vs.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.main.entities.Student;
import com.vs.main.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public boolean addStudentDetails(Student std) {
		
		boolean status=false;
		
		try {
			studentRepository.save(std);
			status=true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List<Student> getAllStudentsDetails() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentDetails(Long id) {
		// TODO Auto-generated method stub
		
		  Optional<Student> optional=studentRepository.findById(id);
		  if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean updateStudent(Long id, float marks) {
		Student std= getStudentDetails(id);
		if (std!=null) {
			std.setMarks(marks);
			studentRepository.save(std);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStdDetails(Long id) {
		
		boolean status=false;
		
		try {
			studentRepository.deleteById(id);
			status=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			status=false;
		}
		
		
		return status;
	}

	
	
}

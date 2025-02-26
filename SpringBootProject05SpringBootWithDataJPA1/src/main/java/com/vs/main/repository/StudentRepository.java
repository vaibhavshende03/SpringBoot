package com.vs.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vs.main.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	
}

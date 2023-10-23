package com.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagement.student.Student;


//Repository for Database Implementation and Perform Operation
@Repository
public interface StudentRepository extends JpaRepository<Student , Long>{
	
}

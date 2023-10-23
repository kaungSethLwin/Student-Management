package com.studentmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studentmanagement.student.Student;

//Student Service Interface for Logic Implementation
public interface StudentService {
	    String showStudentForm(Model model);
	    String saveStudent(Student student, BindingResult result, RedirectAttributes redirectAttributes);
	    List<Student> getStudentList();
	    ResponseEntity<String> updateStudent(Student updatedStudent);
	    ResponseEntity<String> deleteStudent(Long id, RedirectAttributes redirectAttributes);

}

package com.studentmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.studentmanagement.repository.StudentRepository;
import com.studentmanagement.service.StudentService;
import com.studentmanagement.student.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	//Display student from thymleaf
	 @Override
	    public String showStudentForm(Model model) {
		   model.addAttribute("student", new Student());
	        return "form";
	    }
	    
	 //Saving new Student
	    @Override
	    public String saveStudent(Student student, BindingResult result, RedirectAttributes redirectAttributes) {
	    	 if (result.hasErrors()) {
	             // Validation errors exist; return to the form page
	             return "form";
	         }

	         //Successful submit
	         studentRepository.save(student);
	         log.info("Processing student: {}", student);
	         redirectAttributes.addFlashAttribute("successMessage", "Student saved successfully!");
	         return "redirect:/students"; 
	    }
	    
	    //Rreturn All Students
	    
	    @Override
	    public List<Student> getStudentList() {
	    	// Fetch the list of students from your database
	        List<Student> students = studentRepository.findAll();

	        // Return the list as JSON
	        return students;
	    }
	    
	    //Updating Student
	    @Override
	    public ResponseEntity<String> updateStudent(Student updatedStudent) {
	    	 long studentId = updatedStudent.getId();

	         // Check if the student with the given ID exists in the database
	         Optional<Student> existingStudentOptional = studentRepository.findById(studentId);

	         if (existingStudentOptional.isPresent()) {
	             Student existingStudent = existingStudentOptional.get();

	             // Update the student's information with the new data
	             existingStudent.setStudentName(updatedStudent.getStudentName());
	             existingStudent.setDob(updatedStudent.getDob());
	             existingStudent.setEmail(updatedStudent.getEmail());
	             existingStudent.setFatherName(updatedStudent.getFatherName());
	             existingStudent.setPhone(updatedStudent.getPhone());
	             existingStudent.setState(updatedStudent.getState());
	             existingStudent.setAddress(updatedStudent.getAddress());
	             existingStudent.setStudentNRC(updatedStudent.getStudentNRC());

	             // Save the updated student
	             studentRepository.save(existingStudent);

	             return ResponseEntity.ok("Student updated successfully");
	         } else {
	             // If the student with the provided ID does not exist, return an error response
	             return ResponseEntity.badRequest().body("Student not found for ID: " + studentId);
	         }
	    }
	    
	    //Deleting Student
	    @Override
	    public ResponseEntity<String> deleteStudent(Long id, RedirectAttributes redirectAttributes) {
	    	 try {
	             // Check if the student exists
	             Optional<Student> studentOptional = studentRepository.findById(id);

	             if (studentOptional.isPresent()) {
	                 // Student exists; delete it
	                 studentRepository.deleteById(id);
	                 redirectAttributes.addFlashAttribute("successMessage", "Student deleted successfully");
	                 return ResponseEntity.ok("Student deleted successfully");
	                

	             } else {
	                 return ResponseEntity.badRequest().body("Student not found");
	             }
	         } catch (Exception e) {
	             return ResponseEntity.badRequest().body("Failed to delete student: " + e.getMessage());
	         }
	    }

}

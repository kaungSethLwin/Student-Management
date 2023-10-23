package com.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.ResponseEntity;
import com.studentmanagement.student.Student;
import com.studentmanagement.service.StudentService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import jakarta.validation.Valid;

//Student API Controller for web service
@Controller
@RequestMapping("/students")
public class StudentController {

	//Auto Injection Student Service Bean
    @Autowired
    private StudentService studentService;

    //Date formating
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
    }

    //Displaying Student Form
    @GetMapping
    public String showStudentForm(Model model) {
        return studentService.showStudentForm(model);
    }

    //Adding New Student 
    @PostMapping
    public String saveStudent(@ModelAttribute @Valid Student student, BindingResult result, RedirectAttributes redirectAttributes) {
        return studentService.saveStudent(student, result, redirectAttributes);
    }

    //Getting all students
    @GetMapping("/list")
    @ResponseBody
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }

    //Updating selected Student
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateStudent(@RequestBody Student updatedStudent) {
        return studentService.updateStudent(updatedStudent);
    }

    //Deleting Selected Student
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteStudent(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        return studentService.deleteStudent(id, redirectAttributes);
    }
}

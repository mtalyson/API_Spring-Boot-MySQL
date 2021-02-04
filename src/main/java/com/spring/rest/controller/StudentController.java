package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jdbc.model.Student;
import com.spring.rest.jdbc.dao.StudentDAO;

@RestController
public class StudentController {

		@Autowired
		StudentDAO studentDAO;
		
		@GetMapping("/students")
		List<Student> getAllStudents() {
			return studentDAO.getAllStudents();
		}
		
		@PostMapping("/addStudent")
		Student addStudent(@RequestBody Student newStudent) {
			return studentDAO.addStudent(newStudent);
		}
		
		@GetMapping("/students/{id}")
		Student findStudent(@PathVariable Integer id) throws Exception {
			Student student = studentDAO.findStudentById(id);
			
			if(student == null) {
				throw new Exception("No Student found for id: " + id);
			}
			
			return student;
		}
		
		@PutMapping("/students/{id}")
		Student updateStudent(@RequestBody Student student, @PathVariable Integer id) {
			return studentDAO.updateStudent(id, student);
		}
		
		@DeleteMapping("/students/{id}")
		void deleteStudent(@PathVariable Integer id) {
			studentDAO.deleteStudent(id);
		}
}

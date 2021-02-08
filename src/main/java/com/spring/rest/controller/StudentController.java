package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.jdbc.dao.StudentDAO;
import com.spring.rest.model.Student;

@RestController
public class StudentController {

		@Autowired
		StudentDAO studentDAO;
		
		@GetMapping("/students")
		ResponseEntity<List<Student>> getAllStudents() {
			try {
				List<Student> result = studentDAO.getAllStudents();
				if(!result.isEmpty()) {
					return ResponseEntity.status(HttpStatus.OK).body(result);
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				
			} catch (IllegalStateException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
		
		@PostMapping("/students/add")
		ResponseEntity<Student> addStudent(@RequestBody Student newStudent) {
			try {
				studentDAO.addStudent(newStudent);
				return ResponseEntity.status(HttpStatus.CREATED).build();
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
		
		@GetMapping("/students/{id}")
		ResponseEntity<Student> findStudent(@PathVariable Integer id) throws Exception {
			Student student = studentDAO.findStudentById(id);
			try {
				if(student != null) {
					return ResponseEntity.status(HttpStatus.OK).body(student);
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();				
			} catch (Exception e) {
				e.getMessage();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
		
		@PutMapping("/students/{id}")
		ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
			try {
				if(studentDAO.findStudentById(id) != null) {
					Student result = studentDAO.updateStudent(id, student);
					return ResponseEntity.status(HttpStatus.OK).body(result);
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				
			} catch (Exception e) {
				e.getMessage();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}

		}
		
		@DeleteMapping("/students/{id}")
		ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
			try {
				if(studentDAO.findStudentById(id) != null) {
					studentDAO.deleteStudent(id);
					return ResponseEntity.status(HttpStatus.OK).build();
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();				
			}catch (Exception e) {
				e.getMessage();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
}

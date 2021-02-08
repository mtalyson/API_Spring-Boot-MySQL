package com.spring.rest.service;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.rest.jdbc.dao.StudentDAO;
import com.spring.rest.model.Student;

@SpringBootTest
public class DeleteStudentTest {
	
	@Autowired
	StudentDAO studentDAO;
	
	@Test
	public void deleteStudentTest() {
		studentDAO.deleteStudent(26);
		Student student = studentDAO.findStudentById(26);
			
		assertNull(student);
	}	

}

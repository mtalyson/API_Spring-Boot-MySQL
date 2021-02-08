package com.spring.rest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.rest.jdbc.dao.StudentDAO;
import com.spring.rest.model.Student;

@SpringBootTest
public class AddStudentTest {
	
	@Autowired
	StudentDAO studentDAO;
	
	@Test
	public void addStudentTest() {
		Student student = new Student("Pedro", 21, 33);
		
		studentDAO.addStudent(student);
		
		assertEquals("Pedro", student.getName());
		assertEquals(21, student.getAge());
		assertEquals(33, student.getWeight());
	}

}

package com.spring.rest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.rest.jdbc.dao.StudentDAO;
import com.spring.rest.model.Student;

@SpringBootTest
public class FindStudentByIdTest {
	
	@Autowired
	StudentDAO studentDAO;
	
	@Test
	public void findStudentByIdTest() {
		Student student = studentDAO.findStudentById(1);
		
		assertEquals(1, student.getId());
		assertEquals("teste1", student.getName());
		assertEquals(1, student.getAge());
		assertEquals(1, student.getWeight());
		
	}
	
}

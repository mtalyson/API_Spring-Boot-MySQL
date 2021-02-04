package com.spring.rest.jdbc.dao;

import java.util.List;

import com.spring.jdbc.model.Student;

public interface StudentDAO {

	List<Student> getAllStudents();
	
	public Student findStudentById(int id);
	
	public Student updateStudent(int id, Student student);
	
	public Student addStudent(Student student);
	
	public boolean deleteStudent(int id);
}

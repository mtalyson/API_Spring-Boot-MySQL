package com.spring.rest.jdbc.dao;

import java.util.List;

import com.spring.rest.model.Student;

public interface StudentDAO {

	List<Student> getAllStudents();
	
	public Student findStudentById(int id);
	
	public Student updateStudent(int id, Student student);
	
	public void addStudent(Student student);
	
	public void deleteStudent(int id);
}

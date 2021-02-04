package com.spring.rest.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbc.model.Student;
import com.spring.jdbc.model.StudentMapper;

@Component
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> getAllStudents() {
		return jdbcTemplate.query("SELECT * FROM STUDENT", new StudentMapper());
	}

	@Override
	public Student findStudentById(int id) {
		Student student = null;
		try {
			student = jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE ID = ?", new Object[] { id }, 
					new StudentMapper());
		} catch(Exception ex) {
			System.out.println("Exception:" + ex);
		}
		return student;
	}

	@Override
	public Student updateStudent(int id, Student student) {
		jdbcTemplate.update("UPDATE STUDENT SET NAME = ?, AGE = ?, WEIGHT = ?", 
				new Object[] { student.getName(), student.getAge(), student.getWeight(), id });
		return findStudentById(id);
	}

	@Override
	public Student addStudent(Student student) {
		jdbcTemplate.update("INSERT INTO STUDENT (ID,NAME,AGE,WEIGHT) VALUES (?,?,?,?)",
				new Object[] { student.getId(), student.getName(), student.getAge(), student.getWeight() });
		return findStudentById(student.getId());
	}

	@Override
	public boolean deleteStudent(int id) {
		return jdbcTemplate.update("DELETE FROM STUDENT WHERE ID = ?", new Object[] { id }) > 0;
	}
	
	
}

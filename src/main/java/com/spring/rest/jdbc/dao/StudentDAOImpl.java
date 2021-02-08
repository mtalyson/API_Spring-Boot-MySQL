package com.spring.rest.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.rest.model.Student;
import com.spring.rest.model.StudentMapper;

@Component
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
		jdbcTemplate.update("UPDATE STUDENT SET NAME = ?, AGE = ?, WEIGHT = ? WHERE ID = ?", 
				new Object[] { student.getName(), student.getAge(), student.getWeight(), id });
		return findStudentById(id);
	}

	@Override
	public void addStudent(Student student) {
		jdbcTemplate.update("INSERT INTO STUDENT (NAME, AGE, WEIGHT) VALUES (?,?,?)",
				new Object[] { student.getName(), student.getAge(), student.getWeight() });
	}

	@Override
	public void deleteStudent(int id) {
		jdbcTemplate.update("DELETE FROM STUDENT WHERE ID = ?", new Object[] { id });
	}
	
	
}

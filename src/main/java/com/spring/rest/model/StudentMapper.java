package com.spring.rest.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet resultSet, int i) throws SQLException {
		Student student = new Student();
		student.setId(resultSet.getInt("id"));
		student.setName(resultSet.getString("name"));
		student.setAge(resultSet.getInt("age"));
		student.setWeight(resultSet.getInt("weight"));
		
		return student;
	}
}

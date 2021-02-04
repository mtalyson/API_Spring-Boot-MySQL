package com.spring.rest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
@Configuration
@ComponentScan("com.spring.rest")
@PropertySource("classpath:database.properties")
public class Application {

	@Autowired
	Environment enviroment;
	
	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setUrl(enviroment.getProperty(URL));
		driverManagerDataSource.setUsername(enviroment.getProperty(USER));
		driverManagerDataSource.setDriverClassName(enviroment.getProperty(DRIVER));
		driverManagerDataSource.setPassword(enviroment.getProperty(PASSWORD));
		
		return driverManagerDataSource;
	}
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

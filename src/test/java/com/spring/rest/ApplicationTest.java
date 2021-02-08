package com.spring.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@SpringBootConfiguration
@ComponentScan("com.spring.rest")
public class ApplicationTest {
	
	@Test
	void contextLoads() {
	}

}

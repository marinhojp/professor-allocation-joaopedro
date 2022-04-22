package com.project.professorallocation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Course;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class CourseServiceTests {

	@Autowired
	CourseService service;
	
	@Test
	public void create() {
		Course courseBeingCreated = new Course();
		courseBeingCreated.setName("Front-End");
		
		courseBeingCreated = service.create(courseBeingCreated);
		
	}
	
	@Test
	public void deleteById() {
		service.deleteById(1L);
	}
}

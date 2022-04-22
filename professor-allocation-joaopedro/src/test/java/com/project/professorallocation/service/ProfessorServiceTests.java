package com.project.professorallocation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorServiceTests {
	
	@Autowired
	ProfessorService service;

	@Test
	public void create() {
		Professor professorBeingCreated = new Professor();
		professorBeingCreated.setName("Joana Martins");
		professorBeingCreated.setCpf("12233344445");
		professorBeingCreated.setDepartmentId(6L);
		
		professorBeingCreated = service.create(professorBeingCreated);
		
	}
}

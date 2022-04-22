package com.project.professorallocation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Department;



@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentServiceTests {
	
	@Autowired
	DepartmentService service;
	
	@Test
	public void create() {
		Department departmentBeingCreated = new Department();
		departmentBeingCreated.setName("Departamento de Física");
		
		departmentBeingCreated = service.create(departmentBeingCreated);
	}

}

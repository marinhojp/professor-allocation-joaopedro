package com.project.professorallocation.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Allocation;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class AllocationRepositoryTests {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");
	
	
	@Autowired
	private AllocationRepository repository;
	
	@Test
	public void create() throws ParseException {
		
		Allocation allocationBeingCreated = new Allocation();
		allocationBeingCreated.setDayOfWeek(DayOfWeek.THURSDAY);
		allocationBeingCreated.setStartHour(sdf.parse("19:00-0300"));
		allocationBeingCreated.setEndHour(sdf.parse("21:00-0300"));
		allocationBeingCreated.setProfessorId(1L);
		allocationBeingCreated.setCourseId(1L);
		
		allocationBeingCreated = repository.save(allocationBeingCreated);
		System.out.println(allocationBeingCreated);
	}

	@Test
	public void findAll() {
		
		List<Allocation> allAllocations = repository.findAll();
		
		allAllocations.forEach(System.out::println);
	}
	
	@Test
	public void findByASpecificProfessor() {
		
		List<Allocation> allocationByASpecificProfessor = repository.findByProfessorId(1L);
		
		allocationByASpecificProfessor.forEach(System.out::println);
		
		
	}
	
	@Test
	public void deleteAll() {
		
		repository.deleteAllInBatch();
	}
	
	
}

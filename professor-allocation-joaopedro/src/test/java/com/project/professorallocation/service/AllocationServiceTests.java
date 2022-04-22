package com.project.professorallocation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Allocation;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")

public class AllocationServiceTests {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");
	
	@Autowired
	AllocationService service;
	
	@Test
	public void create() throws ParseException {
		Allocation allocation = new Allocation();
		allocation.setDayOfWeek(DayOfWeek.TUESDAY);
		allocation.setProfessorId(1L);
		allocation.setCourseId(2L);
		allocation.setStartHour(sdf.parse("19:00-0300"));
		allocation.setEndHour(sdf.parse("21:00-0300"));
		
		allocation = service.create(allocation);
	}
	
	@Test
	public void update() {
		
	}

}

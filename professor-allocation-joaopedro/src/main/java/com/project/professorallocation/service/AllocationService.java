package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	private final AllocationRepository repository;

	public AllocationService(AllocationRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Allocation> findAll() {
		return repository.findAll();
	}

	public Allocation findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void deleteById(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}

	}

	public Allocation create(Allocation allocation) {
		allocation.setId(null);
		return saveInternal(allocation);
	}

	public Allocation update(Allocation allocation) {
		Long id = allocation.getId();
		if (id == null || !repository.existsById(id)) {
			return null;
		} else {
			return saveInternal(allocation);
		}

	}

	private Allocation saveInternal(Allocation allocation) {
		if (hasCollision(allocation)) {
			throw new RuntimeException("There is a collision for this allocation");
		}
		Allocation insertedAllocation = repository.save(allocation);
		return insertedAllocation;
	}

	private boolean hasCollision(Allocation newAllocation) {
		boolean collisionFound = false;

		List<Allocation> currentAllocations = repository.findByProfessorId(newAllocation.getProfessorId());

		for (Allocation currentAllocation : currentAllocations) {
			if (hasCollision(currentAllocation, newAllocation)) {
				collisionFound = true;
				break;
			}

		}

		return collisionFound;
	}

	private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
		boolean collision = !currentAllocation.getId().equals(newAllocation.getId())
				&& currentAllocation.getProfessorId().equals(newAllocation.getProfessorId())
				&& currentAllocation.getDayOfWeek().equals(newAllocation.getDayOfWeek())
				&& currentAllocation.getStartHour().compareTo(newAllocation.getEndHour()) < 0
				&& newAllocation.getStartHour().compareTo(currentAllocation.getEndHour()) < 0;

		return collision;
	}

	public List<Allocation> findByProfessorId(Long id) {
		return repository.findByProfessorId(id);
	}

	public List<Allocation> findByCourseId(Long id) {
		return repository.findByCourseId(id);
	}
}

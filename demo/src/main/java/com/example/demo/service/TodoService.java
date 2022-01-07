package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistance.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	public String testService() {
		return "testService";
	}
	
	public List<TodoEntity> create(final TodoEntity entity) {
		
		//Validations (null check)
		validate(entity);
		
		repository.save(entity);
		log.info("entity saved. id: {}", entity.getId());
		
		return repository.findByUserId(entity.getId());
	}

	
	public List<TodoEntity> retrieve(final String userId) {
		return repository.findByUserId(userId);
	}	
	
	public List<TodoEntity> update(final TodoEntity entity) {
		
		//null check
		validate(entity);
		
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		if (original.isPresent()) {
			final TodoEntity todo = original.get();
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			repository.save(todo);
		}

		/*
		 * if use lamda 
			original.ifPresent(todo -> {
			
			//new set
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			//update
			repository.save(todo);
		});
		 * 
		 * */
		
		return retrieve(entity.getUserId());
	}
	
	private void validate(TodoEntity entity) {

		//null check
		if (entity == null) {
			log.warn("Entity is null!");
			throw new RuntimeException("Uknown user. null check");
		}
		
		if (entity.getUserId() == null) {
			log.warn("Unknown user.");
			throw new RuntimeException("Unknown user. null check");
		}		
	}
}

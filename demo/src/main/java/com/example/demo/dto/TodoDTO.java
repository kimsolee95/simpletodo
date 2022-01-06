package com.example.demo.dto;

import com.example.demo.model.TodoEntity;

public class TodoDTO {

	private String id;
	private String title;
	private boolean done;
	
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}
}
